package com.ncs.MavenDemoProject;

public class RunnerArray {

	public static void main(String args[]) {
		
		//Method 1 : Array initialization 
		int[] nums = new int[5]; // 'nums' array created of length 5. All elements is 0.
		
		for(int i=0; i<nums.length; i++)
		{
			System.out.println(nums[i]+ ",");
		}
		
		
		
		//Method 2 : Array initialization
		
		//String[] text = new String[] {"Pune", "Raipur", "Jaipur"};
		
		 String[] text = {"Pune", "Raipur", "Jaipur"};
		
		for(String p : text)
		{
			System.out.println(p+ ",");
			
		}
		
		// Find average of all salaries
		
		long[] salaries = {100000,50000,70000,200000};
		
		ArraySalary obj = new ArraySalary();
		
		long ans = obj.avg_salary(salaries);
		System.out.println("Average salary is= "+ ans);
		
		
		// 2-D Array Implementation
		
		int[][] dd = new int[2][3];
		
		dd[0][0] = 1;
		dd[0][1] = 2;
		dd[0][2] = 3;
		
		dd[1][0] = 11;
		dd[1][1] = 22;
		dd[1][2] = 33;
		
		for(int i=0; i<=dd.length; i++)
		{
			for(int j=0; j<=dd[i].length; j++)
			{
				System.out.println(dd[i][j]+"  ");
				
			}
			System.out.println();
		}
		
		
		
	}
	
}
