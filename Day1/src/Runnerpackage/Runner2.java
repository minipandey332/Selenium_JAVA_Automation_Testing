package Runnerpackage;

import MiniPackage1.Welcome;

public class Runner2 {

	public static void main(String[] args) {

		// different package can have same class name.
		
		// either we can import it, or we can directly write full domain class name.
		
		Welcome w1 = new Welcome();
		w1.display();
		
		MiniPackage2.Welcome w2 = new MiniPackage2.Welcome();
		w2.display();
		
	}

}
