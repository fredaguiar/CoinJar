package coinjar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinJarRestController {

	private float totalAmount;
	private float totalFluidOunce;
	
	@RequestMapping(method=RequestMethod.PUT,  value="/coinjar/add/{denomination}")
    public CoinJarRestResponse add(@PathVariable("denomination") String denomination) {
		
		Coin coin = Cache.getInstance().getCoin(denomination);
		if (coin == null) {
			
			throw new CoinJarException("Not found.");
		}
		
		// max allowed volume: 32 fluid ounce
		if (totalFluidOunce + coin.getFluidOunce() > 32) {
			throw new CoinJarException("Max 32 fluid ounce has been reached.");
		}

		add(coin);
		
		// Spring uses the Jackson JSON lib to automatically marshal the object into JSON
		return new CoinJarRestResponse(totalAmount, totalFluidOunce);
    }
	
	@RequestMapping(method=RequestMethod.PUT,  value="/coinjar/reset")
    public CoinJarRestResponse reset() {
        
		resetTotalAmount();
		return new CoinJarRestResponse(totalAmount, totalFluidOunce);
    }
	
	private synchronized void add(Coin coin) {
		
		totalAmount += coin.getAmount();
		totalFluidOunce += coin.getFluidOunce();
	}
	
	private synchronized void resetTotalAmount() {		
		
		totalAmount = 0;
		totalFluidOunce = 0;
	}

	@ExceptionHandler(CoinJarException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ResponseBody
    public ErrorResponse handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){

        return new ErrorResponse(ex.getMessage(), "400");
    }   
}
