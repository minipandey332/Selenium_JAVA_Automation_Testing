package com.ncs.MavenDemoProject;

public class ArraySalary {

	public long avg_salary(long[] salaries)
	{
		long ans=0;
		long sum=0;
		
		for(long a: salaries)
		{
			sum += a;
		}
		
		ans = sum/(salaries.length);
		
		return ans;
	}

}
