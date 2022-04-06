package com.hcl.myproject.oop.vehicle;

public class MercCoupeWithBoat extends MercCoupe implements SupportsFloating {
	
	public MercCoupeWithBoat() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public MercCoupeWithBoat(int wheels) {
		// TODO Auto-generated constructor stub
		super(wheels);
	}
	
	public void floater() {
		System.out.println("I can also float");
	}
}
