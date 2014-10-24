package coinjar;

public class CoinJarRestResponse {
	
	private float totalFluidOunce;
	private float totalAmount;
	
	public CoinJarRestResponse (){
	}
	
	public CoinJarRestResponse (float totalAmount, float totalFluidOunce){

		this.totalAmount = totalAmount;
		this.totalFluidOunce = totalFluidOunce;
	}

	public float getTotalFluidOunce() {
		return totalFluidOunce;
	}

	public void setTotalFluidOunce(float totalFluidOunce) {
		this.totalFluidOunce = totalFluidOunce;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	
}
