package coinjar;

import java.util.HashMap;
import java.util.Map;

public class Cache {
	
	private static Cache cache;
	
	public static synchronized Cache getInstance() {
		if (cache == null) {
			cache = new Cache();
		}
		return cache;
	}
	
	private static Map<String, Coin> coinMap = new HashMap<String, Coin>();
	
	private Cache() {
		
		// initialize US coinage
		addCoin(Const.US_DOLLAR, Const.US_DOLLAR_PENNY, 0.01f, 19.05f, 1.52f);
		addCoin(Const.US_DOLLAR, Const.US_DOLLAR_NICKEL, 0.05f, 21.21f, 1.95f);
		addCoin(Const.US_DOLLAR, Const.US_DOLLAR_DIME, 0.10f, 17.91f, 1.35f);
		addCoin(Const.US_DOLLAR, Const.US_DOLLAR_25, 0.25f, 24.26f, 1.75f);
		addCoin(Const.US_DOLLAR, Const.US_DOLLAR_50, 0.50f, 30.61f, 2.15f);
		addCoin(Const.US_DOLLAR, Const.US_DOLLAR_PRESIDENT, 1f, 26.49f, 2.00f);
		addCoin(Const.US_DOLLAR, Const.US_DOLLAR_NATIVE, 1f, 26.49f, 2.00f);	
	}
	
	// Diameter and height in mm
	private void addCoin(
			String currency, 
			String denomination, 
			float amount, 
			float diameter, 
			float height) {
		
		// calculate fluid ounce
		float radius = diameter/2;
		float mm3 = 3.14f * radius * radius * height;
		float fluidOunce = mm3 / Const.FLUID_OUNCE_TO_MM3;
		
		System.out.println("denomination: " + denomination 
				+ " / mm3: " + mm3 
				+ " / fluidOunce: " + fluidOunce);
		
		coinMap.put(denomination,  new Coin(currency, denomination, amount, fluidOunce));
	}
	
	public Coin getCoin(final String denomination) {
		
		return coinMap.get(denomination);
	}
	

}