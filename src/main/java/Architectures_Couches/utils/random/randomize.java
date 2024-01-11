package Architectures_Couches.utils.random;

import java.util.Random;

public class randomize {
	
	public void randomizeNb() {

		Random random = new Random();
	
		int rdm = 0;
	
		for (int i = 0; i <= 10; i++ ) {
			rdm = random.nextInt(1, 10);
				
		}System.out.println(rdm);
		
	}
}
