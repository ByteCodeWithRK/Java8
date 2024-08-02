package com.bytecodewithrk.java8.functional;

import java.util.List;
import java.util.function.Consumer;

import com.bytecodewithrk.DataSource;
import com.bytecodewithrk.Players;

public class ConsumerFunctionalEx {

	public static void main(String[] args) {
		
		
		//Consumer  Def:: Accepts Single parameter and doesn't return anythin
		//Consumer having 2 methods
		//1.Accept()
		consumerWithAbstractMethod();
		//Ex1:
		//2.andThen()
		//f1.andThen(f2)
		consumerWithDefaultMethod();
		consumerWithCustomObjects();
		

	}

	private static void consumerWithCustomObjects() {
		Consumer<List<Players>> c1 =(param1)->{
			param1.stream().forEach(System.out::println);
		};
		c1.accept(DataSource.getData());
	}

	private static void consumerWithDefaultMethod() {
		Consumer<Integer> c1 = (param1)->{
			System.out.println("Consumer::Default::andThen::c1::"
		              +param1*param1);
		};
		Consumer<Integer> c2 = (param1)->{
			System.out.println("Consumer::Default::andThen::c2::"
		              +param1*param1*param1);
		};
		c1.andThen(c2).accept(10);
	}

	private static void consumerWithAbstractMethod() {
		Consumer<String> c1 = (param1)->{
			System.out.println("Consumer::Abstract::accept::"
		              +param1.toLowerCase());
		};
		c1.accept("BYTECODEWITHRK");
	}

}
