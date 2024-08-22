package com.bytecodewithrk.java8.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.bytecodewithrk.DataSource;
import com.bytecodewithrk.Players;

public class CollectorsEx {

	public static void main(String[] args) {

		/*
		 * Collectors::
		 * 	 1. An Utility class which contains lot of methods to perform various operations
		 *      using stream api.
		 *   2. Avaiable in java.util.stream.Collectors package
		 */

		/*
		 * Counting::
		 * 	Used to find the no.of elements/objects in Stream.
		 */
		countingCollectors();

		/*
		 * Joining::
		 * 	Used to join the elements separated by delimiter
		 */
		joiningCollectors();

		/*
		 * Filtering::
		 *     Used to filter the data and return the data based on filtered criteria
		 */
		filteringCollectors();
	}

	private static void filteringCollectors() {
		//With wrapper type
		List<Integer> list = Arrays.asList(1,2,3,4,5);

		System.out.println("Collectors::Filtering::Wrapper:: "+
				list.stream().filter(e -> e%2 ==0) .collect(Collectors.toList()));

		//With Custom type
		System.out.println("Collectors::Filtering::Custom:: "+
				DataSource.getData().stream().filter(e -> e.getFours() >100)
				.collect(Collectors.toList()));
	}

	private static void joiningCollectors() {
		//With Wrapper type
		List<String> list = Arrays.asList("Java", "SpringBoot", "Microservices", "AWS");
		System.out.println("Collectors::Joining(Delimiter)::Wrapper:: "+
				list.stream().collect(Collectors.joining("::")));

		System.out.println("Collectors::Joining()::Wrapper:: "+
				list.stream().collect(Collectors.joining()));

		System.out.println("Collectors::Joining(delimiter, prefix, suffix)::Wrapper:: "+
				list.stream().collect(Collectors.joining("::", "[", "]")));

		//With Custom type
		System.out.println("Collectors::Joining::Custom:: "+
				DataSource.getData().stream().map(Players::getName)
				.collect(Collectors.joining()) );

		System.out.println("Collectors::Joining::Custom:: "+
				DataSource.getData().stream().map(Players::getName)
				.collect(Collectors.joining(" -> ")) );

		System.out.println("Collectors::Joining::Custom:: "+
				DataSource.getData().stream().map(Players::getName)
				.collect(Collectors.joining(" -> ", "[", "]")) );
	}


	private static void countingCollectors() {
		//With Wrapper type
		List<Integer> list = Arrays.asList(1, 2,3,4,5);
		System.out.println("Collectors::Counting::Wrapper:: "
				+list.stream().collect(Collectors.counting()));

		//With custom object
		Long listCust = DataSource.getData().stream()
				.collect(Collectors.counting());
		System.out.println("Collectors::Counting::Custom:: "+listCust);
	}

}
