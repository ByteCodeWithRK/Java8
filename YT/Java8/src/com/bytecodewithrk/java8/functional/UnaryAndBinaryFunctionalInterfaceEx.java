package com.bytecodewithrk.java8.functional;

import java.util.function.UnaryOperator;

import com.bytecodewithrk.DataSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class UnaryAndBinaryFunctionalInterfaceEx {

	public static void main(String[] args) {
		
		//UnaryOperator:
		/*
		 * 1. An operator which takes single value and return single value of 
		 *    same type.
		 * 2. Available in java.util.function package
		 * 3. Sub interface of Function functional interface
		 */
		 //It has 2 method
		//1. apply();
		unaryOperatorWithAbstractMethod();
		
		//2. identity() : return input value as result
		unaryOperatorWithStaticMethod();
		
		
		//BinaryOperator
		/*
		 * 1. An operator which takes 2 value and return single value of 
		 *    same type
		 * 2. Available in java.util.function package
		 * 3. it is sub interface BiFuntion interface
		 */
		//it having 3 methods
		//1. apply()
		binaryOperatorWithAbstractMethod();
		//2. minBy()
		binaryOperatorWithStaticMethods();
		//binaryOperatorWithCustomObject();
		
		
	}

	

	private static void binaryOperatorWithStaticMethods() {
		
		//2. minBy()
		BinaryOperator<String> bi = BinaryOperator.minBy(
				Comparator.naturalOrder());
		System.out.println("BinaryOperator::Static::minBy::"+
				bi.apply("Springboot", "Java"));
		
		
		//3. maxBy()
		BinaryOperator<String> bi1 = BinaryOperator.maxBy(
				Comparator.naturalOrder());
		System.out.println("BinaryOperator::Static::maxBy::"+
				bi1.apply("Springboot", "Java"));
		
	}

	private static void binaryOperatorWithAbstractMethod() {
		BinaryOperator<Integer> bi =(param1, param2) ->{
			return param1*param2;
		};
		System.out.println("BinaryOperator::Abstract::Apply::"
					+bi.apply(10, 20));
	}

	private static void unaryOperatorWithStaticMethod() {
		UnaryOperator<Integer> u1 = UnaryOperator.identity();
		System.out.println("UnaryOperator::Static::Identity::"
						+u1.apply(10));

	}

	private static void unaryOperatorWithAbstractMethod() {
		UnaryOperator<Integer> u1 = (param1) ->{
			return param1*10;
		};
		System.out.println("UnaryOperator::abstract::apply::"+u1.apply(5));
	}

}
