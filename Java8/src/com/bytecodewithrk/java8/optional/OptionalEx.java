package com.bytecodewithrk.java8.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bytecodewithrk.DataSource;
import com.bytecodewithrk.Players;

public class OptionalEx {

	public static void main(String[] args) {

		/*
		 * Optional Class::
		 * 1. Def::
		 * 		Optional class in java8 is used to avoid NullPointerException
		 * 2. Available in java.util.Optional package
		 * 3. It is a wrapper class that encapsulates the absence or presence of values.
		 * 4. It forces the developers to think about failure cases and take 
		 *    appropriate action to handle.
		 */

		/*
		 * Empty::
		 * 	Used to create empty optional object using static factory method
		 *  i.e., empty();
		 *  static <T> Optional<T> empty()
		 */
		emptyOptional();

		/*
		 * of::
		 * 	1. It return optional object from non-null values using static factory
		 *     of()
		 *     2.  Used if your are sure that the object must return non-null values.
		 *     3. Syntax:  static <T> Optional<T> of(T value)
		 */
		ofOptional();

		/*
		 * ofNullable::
		 *    1. Returns optional object from null or non-null values using static
		 *       factory method of Optional class ofNullable();
		 *    2. Syntax:  static <T> Optional<T> ofNullable(T value)
		 *    
		 *    
		 */
		ofNullableOptional();

		/*
		 * Get::
		 * 1. Used to get the data from optional class object
		 * 2. We will get NoSuchElementException if the optional class object is return null
		 * 3. It is best practice to use ifPresent()/isPresent() before applying get() method
		 * 4. Syntax:   T get()
		 *    
		 */
		getOptional();

		/*
		 * Conditional Methods in Optional Class::
		 * 	Used to check criteria and based on the criteria it will return the values
		 * 1. isPresent().
		 * 2. ifPresent()
		 * 
		 */
		/*
		 * isPresent::
		 * 	1. Used to check whether the values present in the optional and returns 
		 * 	   boolean value.
		 *     2. Syntax:    boolean isPresent()
		 */
		isPresentOptional();

		/*
		 * ifPresent::
		 * 	1. Used to check if the value is present in optional or not, if value exist
		 *     2. it will perform some action on the value
		 *     3. Syntax:   Optional<T> ifPresent(Consumer)
		 * 
		 */
		ifPresentOptional();



		/*
		 * orElse:
		 * 	1. Used to return dummy/default value when there is no value in optional 
		 * 	2. Syntax:: T  orElse(T value)
		 */

		orElseOptional();

		/*
		 * orElseGet::
		 * 	1. Used to return supplier when there is no value present in optional
		 * 	2. It is a lazy method, which will be executed on demand.
		 *     3. Syntax: T orElseGet(Supplier)
		 */

		orElseGetOptional();

		orElseVsorElseGet();

		/*
		 * orElseThrow::
		 * 	Used to throw the exception if the object of optional class returns empty.
		 * 	Syntax:: T orElseThrow(Supplier)
		 */

		orElseThrowOptional();
		/*
		 * map::
		 *    Transform the data
		 */
		mapOptional();

		/*
		 * Filter::
		 * 	Used to filter the data and return result based on given criteria
		 */
		filterOptional();


	}

	private static void filterOptional() {
		//With Wrapper types
		Optional<List<String>> opt = Optional.ofNullable(Arrays.asList("Java", "Springboot", "AWS"));
		opt.filter(e -> e.contains("AWS")).ifPresent(
				(e) -> System.out.println(e));

		//With Custom type
		Optional<List<String>> filterCust = Optional.of(DataSource.getData()
				.stream().map(Players::getName)
				.collect(Collectors.toList()));
		filterCust.filter(e -> e.contains("Sachin"))
		.ifPresent(e -> System.out.println(e));

	}

	private static void mapOptional() {
		//With Wrapper type
		Optional<String> map = Optional.of("JAVA");
		String name = map.map(e -> e.toLowerCase()).toString();
		System.out.println(name);

		//With Custom object
		Optional<List<String>> mapCust = Optional.of(DataSource.getData()
				.stream().map(Players::getName).collect(Collectors.toList()));
		mapCust.ifPresent(e -> {
			System.out.println(e);
		});

	}

	private static void orElseThrowOptional() {
		//With Wrapper types
		Optional<String> orElseThrow = Optional.empty();
		System.out.println(orElseThrow.orElseThrow(() 
				-> new RuntimeException("Please pass some value")));

		//With custom object
		Optional<List<Players>> orElseThrowCust = Optional.ofNullable(DataSource.getData());
		orElseThrowCust.orElseThrow(() -> new RuntimeException("Players not exist, Please add"
				+ " players to list"));

	}

	private static void orElseVsorElseGet() {
		//orElse vs orElseGet with wrapper types
		Optional<String> orElse = Optional.ofNullable("Java");
		System.out.println(orElse.get());
		String dummy = orElse.orElse(getDummyData());
		System.out.println(dummy);

		Optional<String> orElseGet = Optional.ofNullable("Microservices");
		System.out.println(orElseGet.get());
		String dummy1 = orElse.orElseGet(() -> getDummyData());
		System.out.println(dummy1);


	}


	private static String getDummyData() {
		System.out.println("Executing orElse with Early loading");
		return "Default";
	}


	private static void orElseGetOptional() {

		//With wrapper types
		Optional<String> orElseGet = Optional.empty();
		System.out.println(orElseGet.orElseGet(
				() -> {
					return "Dummay data";
				}
		));
		 
		//With custom objects
		Optional<List<Players>> orElseGetCust = Optional.ofNullable(DataSource.getData());
		System.out.println(orElseGetCust);
		List<Players> p =orElseGetCust.orElseGet(
				() -> {
					List<Players> list = new ArrayList<>();
					list.add(new Players(17,  "Rishab Pant", 		500, 	150, 	40, 	10));
					list.add(new Players(4,	  "Abhishek Sharma", 	200, 	200, 	50, 	35));
					return list;
				}
				);
		System.out.println(p);
	}

	private static void orElseOptional() {
		//With Wrapper types
		Optional<String> orElse = Optional.empty();
		//Avoids boilerplate code
		//if(orElse != null) {
		//	System.out.println("True part");
		//}
		System.out.println(orElse.orElse("Dummy Data"));


		//With Custom objects
		Optional<List<Players>> orElseCust = Optional.ofNullable(DataSource.getData());
		List<Players> list = new ArrayList<>();
		list.add(new Players(17,  "Rishab Pant", 		500, 	150, 	40, 	10));
		list.add(new Players(4,	  "Abhishek Sharma", 	200, 	200, 	50, 	35));
		//if(orElseCust != null) {
		//	System.out.println(orElseCust);
		//}
		System.out.println(orElseCust.orElse(list));

	}
	
	private static void ifPresentOptional() {
		//With Wrapper types
		Optional<String> opt = Optional.of("Welcome");
		opt.ifPresent(e -> System.out.println(e+" to Optional Class Example"));

		//With custom Object
		Optional<List<String>> names = Optional.of(DataSource.getData().stream()
				.map(Players::getName).collect(Collectors.toList()));

		names.ifPresent(e -> e.forEach(x -> System.out.println(x+" is a cricketer")));


	}

	private static void isPresentOptional() {
		//With Wrapper types
		Optional<String> opt = Optional.of("Welcome");
		if(opt.isPresent()) {
			System.out.println(opt.get());
		}

		//With custom Object
		Optional<List<String>> names = Optional.of(DataSource.getData().stream()
				.map(Players::getName).collect(Collectors.toList()));
		if(names.isPresent()) {
			System.out.println(names.get());
		}

	}

	private static void getOptional() {
		//1
		Optional<String> getOPtional = Optional.ofNullable("Welcome");
		System.out.println(getOPtional);
		//2
		Optional<String> getOPtionalWithNull = Optional.ofNullable(null);
		System.out.println(getOPtionalWithNull.get());

		//3
		Optional<String> getOPtionalWithIsPresent = Optional.ofNullable(null);
		if(getOPtionalWithIsPresent.isPresent())
			System.out.println(getOPtionalWithIsPresent.get());


	}

	private static void ofNullableOptional() {
		//Wrapper types
		Optional<String> ofNulllable = Optional.ofNullable("");
		System.out.println("Optional::ofNullable::"+ofNulllable.get());

		Optional<String> ofNulllableEmpty = Optional.ofNullable("   ");
		System.out.println("Optional::ofNullable::"+ofNulllableEmpty.get());

		Optional<String> ofNulllableNull = Optional.ofNullable(null);
		System.out.println("Optional::ofNullable::"+ofNulllableNull);
		System.out.println("Optional::ofNullable::"+ofNulllableNull.get());

		//Using custom Object
		Optional<List<Players>> custOfNullable = Optional.ofNullable(DataSource.getData());
		System.out.println(custOfNullable.get());

		Optional<List<String>> custOfNullableNull = Optional.ofNullable(DataSource.getData()
				.stream().map(Players::getName)
				.filter(e -> e.contains("Shewag"))
				.collect(Collectors.toList()));
		System.out.println(custOfNullableNull.get());

	}

	private static void ofOptional() {
		//Optional class with wrapper types
		Optional<String> of = Optional.of("Welcome to Java");
		System.out.println("OPtional::Of:: "+of.get());

		//Optional class with custom types
		Optional<List<String>> custOf= Optional.of(
				DataSource.getData().stream().map(Players::getName)
				.collect(Collectors.toList()));
		System.out.println(custOf.get());

	}

	private static void emptyOptional() {

		Optional<String> empty = Optional.empty();
		System.out.println(empty);
	}

}
