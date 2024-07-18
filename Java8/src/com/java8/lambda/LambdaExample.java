package com.java8.lambda;

public class LambdaExample {//implements Runnable{

	public static void main(String[] args) {
		
		LambdaExample lambda = new LambdaExample();
		
		//Thread t = new Thread(lambda);
		//t.start();
		
		Runnable r =() -> {
			System.out.println("Lambda style without implementing Runnable interface");
		};
		Thread t = new Thread(r);
		t.start();
	}
	/*
	 * @Override public void run() {
	 * System.out.println("Implemented by runnable interface"); }
	 */	
	

}
