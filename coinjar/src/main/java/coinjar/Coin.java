package coinjar;

public class Coin {
	
	private String currency;
	private String denomination;
	private float amount;
	private float fluidOunce;
	
	public Coin (){
	}
	
	public Coin (String currency, String denomination, float amount, float fluidOunce){
		
		this.currency = currency;
		this.denomination = denomination;
		this.amount = amount;
		this.fluidOunce = fluidOunce;
	}
	
	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getFluidOunce() {
		return fluidOunce;
	}

	public void setFluidOunce(float fluidOunce) {
		this.fluidOunce = fluidOunce;
	}

}
