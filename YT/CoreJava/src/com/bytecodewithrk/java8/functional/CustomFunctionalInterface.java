package com.bytecodewithrk.java8.functional;

@FunctionalInterface
public interface CustomFunctionalInterface<T, U, V, R> {

	R m1(T s, U s1, V s3);

	static void m2() {
		System.out.println("Static method m2");
	}
	static void m3() {
		System.out.println("Static method m3");
	}
	default void m4() {
		System.out.println("Static method m4");
	}
	default void m5() {
		System.out.println("Static method m5");
	}
}
