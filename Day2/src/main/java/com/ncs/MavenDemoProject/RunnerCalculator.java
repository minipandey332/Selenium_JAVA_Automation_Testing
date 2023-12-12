package com.ncs.MavenDemoProject;

public class RunnerCalculator {

	public static void main(String[] args) {
		
		// For static member method, we can call directly using class name. We don't need to make object.
		
		System.out.println("Addition : "+ Calculator.addition(13, 20));
		System.out.println("Subs: "+ Calculator.subs(23, 25));
		System.out.println("Multiply: "+ Calculator.mult(2, 10));
		System.out.println("Division: "+ Calculator.div(3, 0));
		
	}

}
