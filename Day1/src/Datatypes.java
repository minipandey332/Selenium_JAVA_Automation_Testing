
import java.util.ArrayList;  // for ArrayList
// Java.lang is automatic. We don't need to import. 
// Java.lang contains System, out, Math etc.....

// Structure of Java Program 
//Package Name
//Import
//Class

// We can have more package, we can have a class with the same name in different package. 
// pkg1.class1
// pkg2.class1



public class Datatypes {

	
	public void intdatatype() {
		
		int year = 2023;
		long longyear = 1000000;
		
		System.out.println("Year= "+ year);
		System.out.println("Long Year= "+longyear);
	}
	
	
	public void floatdatatype() {
		double pi = Math.PI;
		System.out.println("Double pi= "+ pi);
		
		ArrayList al; // this is not part of java.lang  , so i have to import it separatly.
		
	}
	
	public void booleandatatype() {
		
	}
	
	public void chardatatype() {
		
		
	}
	
}
