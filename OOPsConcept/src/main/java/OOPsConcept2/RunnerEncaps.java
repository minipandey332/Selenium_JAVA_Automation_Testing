package OOPsConcept2;

import com.ncs.OOPsConcept.EncapsDemo;

public class RunnerEncaps {

	public static void main(String args[])
	{
		EncapsDemo obj = new EncapsDemo();
		
		//obj.accname="Saving"; // Invalid, Protected is non-accessible outside same package
		obj.amount=90000; // public is always accessible within the pkg & outside the pkg.
		
		//obj.accno=101; //Invalid, Field is not visible as this is private & it only access within same class.
		
		obj.setter(101);
		
		System.out.println(obj.getter());
		
		
		
	}

}
