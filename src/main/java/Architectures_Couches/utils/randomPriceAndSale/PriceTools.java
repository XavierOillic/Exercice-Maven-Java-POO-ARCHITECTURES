package Architectures_Couches.utils.randomPriceAndSale;

import java.util.Random;

public class PriceTools {
	
	public static int generateRdmPrice () {
		
		Random rdm = new Random();
	
		int price = rdm.nextInt(9, 350);
				
		return price;
		
	}

}
