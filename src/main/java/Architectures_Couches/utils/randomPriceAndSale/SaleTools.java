package Architectures_Couches.utils.randomPriceAndSale;

import java.util.Random;

public class SaleTools {
	
	public static int generateRdmSale () {
		
		Random rdm = new Random();
	
		int sale = rdm.nextInt(0, 20);
				
		return sale;
		
	}

}
