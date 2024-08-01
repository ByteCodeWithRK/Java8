package com.bytecodewithrk.java8.functional;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.bytecodewithrk.DataSource;

public class SupolierFunctionalEx {

	public static void main(String[] args) {
		
		//Def: Which doesn't accept anthing but returns some value
		supplierWithAbstract();
		supplierWithCustomObjects();

	}

	private static void supplierWithCustomObjects() {
		Supplier<List<String>> s1 =() ->{
			return DataSource.getData().stream()
					.map(e -> e.getName())
					.collect(Collectors.toList());
					
		};
		System.out.println("Supplier::Custom Object::"+s1.get());
		
	}

	private static void supplierWithAbstract() {
		//Ex1
		Supplier<Integer> s1 =() ->{
			return 100;
		};
		System.out.println("Supplier::Abstract::get::Integer::"+s1.get());
		
		//Ex1
		Supplier<String> s2 =() ->{
			return "Welcome to ByteCodeWithRK";
		};
		System.out.println("Supplier::Abstract::get::String::"+s2.get());
	}

}
