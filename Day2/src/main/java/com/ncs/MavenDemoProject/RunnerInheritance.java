package com.ncs.MavenDemoProject;

public class RunnerInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BrowserInheritanceDemo B = new BrowserInheritanceDemo();
		//Base class have only below 2 method
		System.out.println("Call by Base Class: ");
		B.open();
		B.close();
		
		ChromeBrowser CB = new ChromeBrowser();
		
		// this class inherit base class, thus have above 2 more method
		System.out.println("Call by child class: ");
		CB.open();
		CB.refresh();
		CB.setting();
		
		CB.close();
		
		
		//This can also call below method, but need to do type-casting
		System.out.println("Call child's method by parent class using type-casting: ");
		//((ChromeBrowser) B).refresh(); // Invalid
		
		//((ChromeBrowser) B).setting(); // Invalid
		
		B = new ChromeBrowser(); // Valid
		
		  ((ChromeBrowser) B).refresh(); // Valid
	        ((ChromeBrowser) B).setting(); // Valid
	}

}
