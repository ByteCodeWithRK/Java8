package com.java8.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.java8.DataSource;
import com.java8.Players;

public class FunctionalInterfaceEx {

	public static void main(String[] args) {


		// Single abstract method and can have any no.of static or default 
		// java.util.function package
		// Runnable, Callable, Comparable, Comparator, ActionListner, etc.,

		//After Java8:
		//1. Consumer	2. Supplier	 3. Predicate	 4. Function	5. Unary	6. Binary

		//Syntax::
		@FunctionalInterface
		interface functional{
			void m1(); //abstract method
			//void m2(); //Violate principle of FI, if add more than one abstract method
			//Can write any no.of static or default methods
			default void m3() {
				//stmt
			}
			default void m4() {
				//stmt
			}
			static void m5() {
				//stmt
			}
			static void m6() {
				//stmt
			}
		}
	}
}



