package com.java8.functional;

import java.util.function.Predicate;

import com.java8.DataSource;

public class PredicateFunctionalInterfaceEx {

	public static void main(String[] args) {

		//3. Predicate
		// Which accepts single param and returns boolean value
		// Evaluate the condition(input) and returns boolean
		//Ex1
		predicateWithAbstractMethod();
		predicateWithDefaultMethods();
		predicateWithStaticMethods();
		predicateWithCustomObjectTypes();

	}

	public static void predicateWithCustomObjectTypes() {
		System.out.println("Predicate::Custom Object::");
		DataSource.getData().stream().map(e -> e.getName())
		.filter(s ->s.contains("Virat Kohli"))
		.forEach(System.out::print);;


	}
	private static void predicateWithStaticMethods() {
		//isEqual()
		//Compares the input param with actual
		Predicate<Integer> p = Predicate.isEqual(10);
		System.out.println("Predicate::Static::isEqual()"
				+p.test(20));

		//not
		//Negate the returned predicate value
		System.out.println("Predicate::Static::not()"
				+Predicate.not(p).test(20));

	}

	private static void predicateWithDefaultMethods() {
		//and()
		//If both predicates returns true then result is true else false
		Predicate<String> p =(param1) ->{
			boolean b = param1.startsWith("S");
			return b;
		};
		Predicate<String> p1 =(param1) ->{
			boolean b = param1.startsWith("J");
			return b;
		};
		System.out.println("Predicate::Default::and()::"
				+p.and(p1).test("Java"));

		//or()
		// Either one of the predicate is true then it is true else false

		System.out.println("Predicate::Default::or()::"
				+p.or(p1).test("Java"));

		//negate()
		//It will reverse the boolean value of predicate
		System.out.println("Predicate::Default::negate()::"
				+p1.negate().test("Java"));

	}

	private static void predicateWithAbstractMethod() {
		Predicate<String> string = (param1) ->{
			return param1.startsWith("W");
		};
		;
		System.out.println("Predicate::Abstract::test(String)::"
				+string.test("Java"));

		Predicate<Integer> integer = (param1) ->{
			return param1 > 18;
		};
		;
		System.out.println("Predicate::Abstract::test(Integer)::"
				+integer.test(200));
	}
}