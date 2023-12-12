package com.ncs.MavenDemoProject;

public class ConstructorDemo {

	int x; int y;
	static int counter=0;
	
	ConstructorDemo(){
		++counter;
		System.out.println("Deafult constructor works!");
		System.out.println("Object Created "+ counter + " times");
		
		x=-1; y=-1;
	}
	
	ConstructorDemo(int val1, int val2)
	{
		System.out.println("Parameterized constructor works !");
		x=val1;
		y=val2;
		
		System.out.println("x= "+x+ " , y= "+y);
	}
	
	
}
