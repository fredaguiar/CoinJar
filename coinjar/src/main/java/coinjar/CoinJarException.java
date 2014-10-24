package coinjar;


public class CoinJarException extends RuntimeException {
	 
	private static final long serialVersionUID = 5031491000889926411L;
	private final String message;
     
    public CoinJarException(String message) {
    	this.message = message;
    }

	public String getMessage() {
		return message;
	}
 
}