package com.bytecodewithrk.java8.defaultmethods;

public interface Interface1 {
	
   public default void m1() {
	 System.out.println("Interface1:: m1 method");
		
   }
   
   public default void m2() {
	 System.out.println("Interface1:: m2 method");
		
   }
   
   //void m3();
}
