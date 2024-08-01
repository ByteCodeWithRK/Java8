package com.bytecodewithrk.java8.lambda;

import java.util.function.Consumer;

public class LambdaEx{ // implements Runnable{

	public static void main(String[] args) {
		
		//After Lambda
		//Ex1
		Runnable r =() -> {
			System.out.println("After Lambda");
		};		
		
		Thread t1 = new Thread(r);
		t1.start();
		
		//Ex2
		Consumer c =(s) ->{
			System.out.println("From consumer::"+s);
		};
		c.accept("Welcome to ByteCodeWithRK");
			
		//Before Lambda
		//LambdaEx le = new LambdaEx();
		//Thread t= new Thread(le);
		//t.start();
	
	}

	//@Override
	//public void run() {
	//	System.out.println("Before Lambda:: Implemented by Runnable");
	//}

}

