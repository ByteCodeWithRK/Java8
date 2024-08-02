package com.bytecodewithrk.java8.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class OtherFunctionalInterfaces {

	public static void main(String[] args) {
		
		/*
		 * 1. Bi<FunctionalInterface>
		 * 2. <SS><FunctionalInterface> i.e., IntConsumer, IntSupplier
		 * 3. Obj<SS><FunctionalInterface>
		 * 4. To<SS><FunctionalInterface>
		 * 5. <SS>To<XX><FunctionalInterface>
		 * Here SS and XX represents any datatype like Integer, Long, 
		 * Float, Double, Boolean
		 */
		
		/*
		 * 1. Bi<FunctionalInterface>
		 * Def: It will take extra input parameter as an input to the 
		 *      functional interface
		 *   i. It is not applicable for all the functional interfaces
		 *      Supplier, UnaryOperator and BinaryOperator
		 *   ii. Applicable for Consumer, Predicate and Function interfaces
		 *      
		 */
		biFunctionalInterfaces();
		
		/*
		 * 2. <SS><FunctionalInterface> i.e., IntConsumer, IntSupplier
		 *  	i. Def:: It takes SS types as input value
		 *  	ii. Available in java.uti.function package
		 *  	iii. It is applicable for Consumer, Supplier(returns SS type), 
		 *  		Predicate, Function, UnaryOperators and BinaryOperators
		 *  
		 */
		wrapperTypeFunctionalInterfaces();
		
		/*
		 * 3. Obj<SS><FunctionalInterface>
		 *  	i. Def : It takes 2 inputs and of type Object 
		 *  	   and wrapper type and return nothing
		 *		ii. It is applicable for consumer functional interface only
		 */
		objectAndWrapperTypeInputFunctionalInterfaces();
	
		/*
		 *  4. To<SS><FunctionalInterface>
		 *  	i. Def:: A function which takes single value as input 
		 *  	   and return <SS> type.
		 *  	ii.Here SS represents Int, Long, Double
		 *  	iii. Applicable for Function and BiFunction functional 
		  		 	 interfaces only
		 *  	iv. Available in java.uti.function package 
		 */
		toWrapperTypeFunctionalInterface();
		
		/*
		 * <SS>To<XX><FunctionalInterface>
		 * 1. Def:: A function which takes SS as input value and returns XX type
		 * 2. Available in java.util.function package
		 * 3. It is applicable to Function interface only
		 * 4. Here SS and XX represents Int, Long and Double
		 * 
		 */
		wrapperToOtherWrapperTypeFunctionalInterfaces();
		 
		
	}

	private static void wrapperToOtherWrapperTypeFunctionalInterfaces() {
		IntToDoubleFunction intToLongFun =(param1) ->{
		 	return param1;
	 };
	 System.out.println("IntToLongFunction:: "
			 +intToLongFun.applyAsDouble(10));
	 //IntToLongFunction
	 //LongToDoubleFunction
	 //LongToIntFunction
	 //DoubleToIntFunction
	 //DoubleToLongFunction
		
	}

	private static void toWrapperTypeFunctionalInterface() {
		
		ToIntFunction<Integer> toIntFun = (param1)->{
			return param1.intValue();
		};
		System.out.println("ToIntFunction:: "+toIntFun.applyAsInt(10));
		//ToLongFunction
		//ToDoubleFunction
		//ToIntBiFunction
		//ToDoubleBiFunction
		//ToLongBiFunction
	}

	private static void objectAndWrapperTypeInputFunctionalInterfaces() {

		List<Integer> list = Arrays.asList(10,20, 30,40,50);
		
		ObjIntConsumer<List<Integer>> objIntCon =(param1, param2) ->{
			if(param1.contains(param2))
				System.out.println("ObjIntConsumer:: "+param2+" :: exist");
			else
				System.out.println("ObjIntConsumer:: "+param2
						+" :: not exist");
		};
		objIntCon.accept(list, 70);
		//ObjLongConsumer
		//ObjDoubleConsumer
	}





















	private static void wrapperTypeFunctionalInterfaces() {
		DoubleConsumer sscon = (param1) ->{
			System.out.println("IntConsumer::"+param1);
		};
		sscon.accept(10);
		
		LongSupplier longSup = () ->{
			return 200000000;
		};
		System.out.println("LongSupplier::"+longSup.getAsLong());
		
		LongPredicate longPre = (param1) ->{
			return param1 == 10;
		};
		System.out.println("LongPredicate::"+longPre.test(10));
		
		IntFunction<Integer> intFun = (param1) ->{
			return param1*param1;
		};
		System.out.println("LongPredicate::"+intFun.apply(10));
		
		IntUnaryOperator intUnary = IntUnaryOperator.identity(); 
        System.out.println("IntUnaryOperator::"+intUnary.applyAsInt(10)); 
        
        IntBinaryOperator intBinary = (param1, param2) -> param1 + param2;
        System.out.println("IntBinaryOperator::"+intBinary.applyAsInt(10,10)); 

	}

	private static void biFunctionalInterfaces() {
		
		BiFunction<Integer, Integer, Integer> bifun = (param1, param2) ->{
			return param1*param2;
		};
		System.out.println("BiFunction::"+bifun.apply(10,10));
		
		BiConsumer<Integer, Integer> bicon = (param1, param2) ->{
			System.out.println("BiConsumer::"+(param1+param2));
		};
		bicon.accept(10,20);
		
		BiPredicate<String,Integer> bipre = (param1, param2) ->{
			return param1.length() ==param2;
		};
		System.out.println("BiPredicate::"+bipre.test("ByteCodeWithRK",14));
	
		
		
	}

}























/*
 * 1. Bi<FunctionalInterface>
 * 2. XX<Functional Interface>
 * 3. ObjectXX<FunctionalInterface>
 * 4. ToXX<FunctionalInterface>
 * 5. XXToXX<FunctionalInterface>
 * 
 * Here XX represent wrapper classes like Integer, Long,Float
 *  Double, String, Boolean types.
 * 
 */
//Bi<FunctionalInterface>