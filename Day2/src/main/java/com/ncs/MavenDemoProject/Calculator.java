package com.ncs.MavenDemoProject;

 class Calculator {

	public static int addition(int n1, int n2)
	{
		return (n1+n2);
	}
	
	public static int subs(int n1, int n2)
	{
		if(n1>n2)
		return (n1-n2);
		
		else return (n2-n1);
	}
	
	public static long mult(int n1 , int n2)
	{
		long ans;
		ans = n1*n2;
		return ans;
	}
	
	public static double div(int n1, int n2)
	{
		if(n2==0) return -1;
		else 
			return (double)(n1/n2);
	}
	
}
