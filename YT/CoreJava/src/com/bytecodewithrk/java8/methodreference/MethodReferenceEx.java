package com.bytecodewithrk.java8.methodreference;

import java.util.function.Consumer;

public class MethodReferenceEx extends MethodReferenceSuperEx{
	
	public MethodReferenceEx() {
		//System.out.println("\nFrom Default Constructor");

	}
	
	public MethodReferenceEx(String info) {
		System.out.print("\n Parameterized Constructor welcomes "+info);
	}
	
	public static void printNumber(int num) {
		System.out.println("===From PrintNumber===");
		for(int i=0;i<num;i++) {
			System.out.print(i);
		}
	}
	
	public void printChars(String s) {
		System.out.println("\n===From printChars===");
		for(int i=0;i<s.length();i++) {
			System.out.print(s.charAt(i)+" ");
		}
		
		Consumer<String> c2 = super::printString;
		c2.accept("ByteCodeWithRK from super class");
	}
	

	public static void main(String[] args) {
		
		//Method Reference 
		//Short block of code which is placed inside the method
		// and can be reused.
		//short block of Lambda Expression.
		
		//Before Method Reference(MR). i.e., using Lambda Expression(LE)
		
		Consumer<Integer> c = (param1) ->{
			for(int i=0;i<param1;i++) {
				//System.out.println(i);
			}
		};
		c.accept(5);
		
		//After Introducing Method Reference
		
		//Ways to represent Method Reference
		//1. Static Reference
		//syntax :: 
			//ClassName::MethodName
		//Calls: c1 ->accept() ->printNumber()
		Consumer<Integer> c1 = MethodReferenceEx::printNumber;
		c1.accept(7);
		
		
		//2. Instance Reference
		//First way of calling instance method from current class
		//syntax:: 
		//ObjectName::MethodName
		MethodReferenceEx mr = new MethodReferenceEx();
		Consumer<String> c2 = mr::printChars;
		c2.accept("ByteCodeWithRK");
		
		//syntax::  
		    //new ClassName()::MethodName
		//Second way of calling instance method from current class
		Consumer<String> c3 = new MethodReferenceEx()::printChars;
		c3.accept("Welcome to ByteCodeWithRK");
		
		//Third way of calling instance method from current class
		Consumer<String> c4 = new MethodReferenceSuperEx()::printString;
		c4.accept("Welcome to ByteCodeWithRK from super class");
		
	
		//3. Constructor reference
		//syntax for Default Consutructor:: 
			//ClassName::new
		DefaultConstructorFI dc = MethodReferenceEx::new;
		dc.test();
		
		//syntax for parameterized Consutructor::   
			//ClassName::new
		ParameterizedConstructorFI pc = MethodReferenceEx::new;
		pc.getinfo("ByteCodeWithRK");
		
	

	}

}
