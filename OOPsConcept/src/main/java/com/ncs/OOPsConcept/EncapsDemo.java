package com.ncs.OOPsConcept;

public class EncapsDemo { 

	private int accno;
	protected String accname;
	public int amount;
	
	public void setter(int val) {
		accno=val;
	}
	
	public int getter() {
		return accno;
	}
	
}
