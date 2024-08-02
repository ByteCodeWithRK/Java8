package com.bytecodewithrk.java8.functional;

import java.util.function.Consumer;

public class CustomFunctionalInterfaceEx {
	
	void customMethod(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		
		/*
		 *
		 *Syntax::
			@FunctionalInterface
			interface <custom_interface_name>{
				void m1();
				//Static
				//Default methods
			}
		*/
		
		Consumer<String> consumer = (param1) ->{
			System.out.println(param1);
		};
		consumer.accept("ByteCodeWithRK");
		
		CustomFunctionalInterface<String, String, Integer,Integer> custFun =
				(param1, param2, param3) ->{
			return param1.length()+param2.length()+param3;
		};
		System.out.println("Custom Functional Interface::"+
				custFun.m1("Welcome"," To",10));
	
		
		

	}
	
	
	

}
	