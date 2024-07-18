package com.java8.staticmethods;

public class StaticMethod implements StaticInterface1 {
	
	//@Override
	public static void m1() {
		System.out.println("StaticMethod:: m1 method");
	}

	public static void main(String[] args) {
		m1();
		StaticInterface1.m1();
		StaticInterface1.m2();

	}

}
