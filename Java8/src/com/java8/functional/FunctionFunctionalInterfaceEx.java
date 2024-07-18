package com.java8.functional;

import java.util.function.Function;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.DataSource;
import com.java8.Players;

public class FunctionFunctionalInterfaceEx {

	public static void main(String[] args) {

		/*4. Function
		 * It's an functional interface from java8
		 * Def:	It takes single input parameter and return single value.
		 */
		//Function functional interface having different methods in it

		//1. apply();
		functionWithAbstractMethod();
		functionWithDefaultMethods();
		functionWithStaticMethods();
		functionWithCustomObjects();//Custom object
	}
	
	public static void functionWithAbstractMethod() {
		Function<String, Integer> fun = (param1) -> { return param1.length();};
		System.out.println("Function::Abstract::Apply::"+fun.apply("ByteCodeWithRK"));

	}

	public static void functionWithDefaultMethods() {
		//2. andThen() ii.e., f1.andThen(f2)
		Function<Integer, Integer> test = (param1) ->{
			return param1 * param1;
		};
		//test.apply(2); //4
		Function<Integer, Integer> test1 = (param1) ->{
			return param1 +10;
		};
		System.out.println("Function::default::andThen::"+test.andThen(test1).apply(7)); //59

		//3. compose()
		//f2.compose(f1). i.e., f1 followed by f2 will be executed.
		System.out.println("Function::default::Compose::"
				+test.compose(test1).apply(4)); //

	}

	public static void functionWithStaticMethods() {
		//4. Identity()
		//Takes whatever input return the same value
		Function<Integer, Integer> identity = Function.identity();
		System.out.println("Function::Static::Identity::"+identity.apply(8));

	}

	//Custom Object
	public static void functionWithCustomObjects() {
		Function<List<Players>, List<String>> custom =(param1) ->{
			return param1.stream().map(e -> e.getName())
					//.filter(s ->s.contains("MS Dhoni"))
					.collect(Collectors.toList());
		};
		System.out.println("Function::Custom::"+
				custom.apply(DataSource.getData()));
	}

}
