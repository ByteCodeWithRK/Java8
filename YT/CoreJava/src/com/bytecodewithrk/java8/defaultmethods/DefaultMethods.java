package com.bytecodewithrk.java8.defaultmethods;

public class DefaultMethods implements Interface1
     ,Interface2{
	
	@Override
	public void m1() {
		System.out.println("To avoid Diamond problems");
	}
	
	public void m4() {
	    Interface1.super.m1();
	    Interface2.super.m1();
	}
	    
    
	public static void main(String a[]) {
		DefaultMethods dm = new DefaultMethods();
		dm.m1();
		dm.m4();
	}
}
