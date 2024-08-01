package com.bytecodewithrk.java8.methodreference;

public class MethodReferenceSuperEx {
	
	
	MethodReferenceSuperEx(){
		System.out.println("From super class Default constructor");
	}
	
	public void printString(String s) {
		System.out.println("\n"+s);
	}
	
	public static void printStaticString(String s) {
		System.out.println("\n"+s);
	}

}
