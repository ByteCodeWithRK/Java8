package com.bytecodewithrk.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bytecodewithrk.DataSource;
import com.bytecodewithrk.Players;

public class StreamAPIEx {

	public static void main(String[] args) {
		
	 /*
	  * 1. Def: A sequence of elements on whcih we can iterate and 
	  *         perform operations
	  * 2. It's a pipeline which operates on elements on demand.
	  * 	A1 -> A2 -> A3 -> ...
	  * 3. Stream works with collection and Arrays only.
	  * 4. It performs actions on the copy of the original object
	  * 5. Available in java.util.stream package
	  * 6. It having 2 parts in it's action
	  * 	i. Intermediate Operations
	  * 		It transforms the given stream into other stream.
	  * 		Filter, Map, floatMap, Sorted, Peek, Skip, Limit, etc.,
	  * 	ii. Terminal Operations
	  * 	    Appears at the end
	  * 	    ForEach, forEachOrdered, toArray, min, max, Count,
	  *         anyMatch, allMatch, noneMatch, findFirst, findAny,
	  *         reduce, etc.,
	  */
		//Creation of Stream
		creationOfStreams();
		
		//Intermediate Operations
		/*
		 * Filter:: 
		 *  Def::Travers all the elements of collection and filter the elements based
		 *  on given condition
		 *  Syntax: Stream<T> filter(Predicate)
		 */
		filterIntermediateOperation();
		/*
		 * Map:: It transforms or manipulates the elements
		 * Stream<R> map(Function)
		 */
		mapIntermediateOperation();
		/*
		 * flatMap:: flatten a stream of collections to a stream of objects
		 * syntax:: Stream<R> flatMap(Function)
		 */
			
		flatMapIntermediateOperation();
		/*
		 * Difference b/w map() and flatMap()
		 * 1. map process stream of values where as flatMap process stream of 
		 *    stream values
		 * 2. Map only performs mapping but flatMap will do mapping along with 
		 *    flattening(merging)
		 * 3. Map will do transformation of stream where as flatMap will 
		 *    do transformation of stream of stream 
		 * 4. Map used in one-to-one mapping, flatmap used in one-to- many mapping
		 * 5. Map is used when taking single input and producing single value, 
		 *    but flatMap takes single input and producing multiple values.
		 */
		
		/*
		 * Distinct::
		 * 	It returns new stream with distinct/unique values
		 * syntax:  Stream<T> distinct()
		 */
		distinctIntermediateOperation();
		
		/*
		 * Sorted:
		 * 	Used to sort the elements from the given input
		 *  By default it sort the data in natural order.
		 *  syntax:: Stream<T> sorted() 
		 *           Stream<T> sorted(Comparator) 
		 *  Sorted() are overloaded
		 */
		
		sortedIntermediateOperation();
		
		/*
		 * limit:
		 *   limits the no.of elements to be retrieved or displayed
		 *   syntax:: Stream<T> limit(long n)
		 * 
		 */
		limitIntermediateOperation();
		
		/*
		 * skip::
		 *  Used to ignore/skip the number of elements from the given input
		 *  syntax:: Stream<T> skip(long n)
		 *  if you pass -ve value, will get IllegalArgumentException
		 *  if you pass n > size of the stream, will gives empty stream
		 */
		skipIntermediateOperation();
		
		/*
		 * peek::
		 * 	 It will return new stream consisting of all the elements from 
		 *   original stream after applying consumer action
		 *   It will works with terminal operators only
		 *   
		 *   syntax:: Stream<T> peek(Consumer) 
		 */
		peekIntermediateOperation();
		
		//Terminal Operations
		/*
		 * forEach & forEachOrdered::
		 * 	forEach:: It operates on collection and performs action on each element.
		 *  syntax: void forEach(Consumer)
		 * forEachOrdered:: It operates on collection, performs action on each element and
		 *                  maintains insertion order.
		 *  syntax: void forEachOrdered(Consumer)
		 * 
		 */
		forEachTerminalOperation();
		forEachOrderedTerminalOperation();
		
		/*
		 * min::
		 *  Used to find the minimum or smallest element in the stream
		 *  syntax:  Optional<T> min(Comparator)
		 *  
		 */
		minTerminalOperation();
		
		/*
		 * max::
		 * Used to find maximum or highest element in the stream
		 * syntax:  Optional<T> max(Comparator)
		 */
		maxTerminalOperation();
		
		/*
		 * Count::
		 *   Used to find the no.of elements in the stream or find the no.of 
		 *   elements in the stream based on input
		 *   syntax:: Long count();
		 */
		
		countTerminalOperation();
		
		/*
		 * anyMatch::
		 * 	Used to check that the stream should contain atleast one element
		 *  syntax:: boolean anyMatch(Predicate)
		 */
		
		anyMatchTerminalOperation();
		
		/*
		 * allMatch::
		 * 		All the elements in the stream should satisfy the provided input/criteria
		 *  syntax:: boolean allMatch(Predicate)
		 */
		allMatchTerminalOperation();
		
		/*
		 * noneMatch::
		 * 	Used to check that stream doen't contain any match elements
		 *  boolean noneMatch(Predicate);
		 */
		noneMatchTerminalOperation();
		
		/*
		 * findFirst::
		 * 	To find out the first occurance of element from the stream
		 *   syntax::  Optional<T> findFirst();
		 */
		findFirstTerminalOperation();
		
		/*
		 * findAny::
		 * 	finds any element from the stream
		 * syntax:: Optional<T> findAny();
		 */
		findAnyTerminalOperation();
		
		/*
		 * findFirst() vs findAny()
		 * 1. findFirst will get the first element from the stream and findAny will not 
		 *    guarantee of the order(randomly finds the elements)
		 * 2. We won't see the difference between these two method in non-parallel streams
		 */
		
		/*
		 * reduce::
		 * 	
		 */
		
		
		 
		Collectors.counting();
		
	}
	
	private static void findAnyTerminalOperation() {
		//findAny with wrapper types
		List<String> list = Arrays.asList("SUN", "MON", "TUE", "THU", "FRI", "SAT");
		list.stream().findAny().ifPresent(System.out::println);
		
		//findAny with Custom types
			DataSource.getData().stream().map(e->e.getName()).
			findAny().ifPresent(System.out::println);
				
	}

	private static void findFirstTerminalOperation() {
		//findFirst with wrapper types
		Stream<String> findFirst = Stream.of("SUN", "MON", "TUE", "THU", "FRI", "SAT");
		//findFirst.findFirst().ifPresent(System.out::println);
		
		//findFirst with Custom types
		//DataSource.getData().stream().map(e->e.getName())
		//		.findFirst().ifPresent(System.out::println);
	}

	private static void noneMatchTerminalOperation() {
		//noneMatch with Wrapper types
		Stream<String> noneMatch = Stream.of("SUN", "MON", "TUE", "THU", "FRI", "SAT");
		//System.out.println(noneMatch.noneMatch(s -> s.startsWith("S")));
		
		//noneMatch with Custom types
		//System.out.println(DataSource.getData().stream().map(e->e.getName())
		//		.noneMatch(e -> e.startsWith("H")));
	}

	private static void allMatchTerminalOperation() {
		//allMatch with generic types
		Stream<String> allMatch = Stream.of("SUN", "MON", "TUE", "THU", "FRI", "SAT");
		//System.out.println(allMatch.allMatch(s -> s.startsWith("S")));
		
		//allMatch with custom types
		//System.out.println(DataSource.getData().stream().map(e->e.getName())
		//		.allMatch(e -> e.startsWith("S")));
				
	}

	private static void anyMatchTerminalOperation() {
		//anyMatch with generic types
		Stream<String> anyMatch = Stream.of("SUN", "MON", "TUE", "THU", "FRI", "SAT");
		//System.out.println(anyMatch.anyMatch(s -> s.contains("SAT")));
		
		//anyMatch with custom types
		//System.out.println(DataSource.getData().stream().map(Players::getName)
		//		.anyMatch(s -> s.contains("MS Dhoni")));
	}

	private static void countTerminalOperation() {
		//count with generic types
		List<Integer> count = Arrays.asList(5, 1, 6, 7, 9, 10, 3,6,6);
		//System.out.println(count.stream().count());
				
		//System.out.println(count.stream().collect(Collectors.counting()));
				
		//System.out.println(count.stream().filter(a -> a==6).count());
				
		//count with object types
				
		//System.out.println(DataSource.getData().stream().count());
		//System.out.println(DataSource.getData().stream().collect(Collectors.counting()));
		//System.out.println(DataSource.getData().stream().map(Players::getName) 
		//		.filter(e -> e.equals("Virat Kohli")).count());
		
	}

	private static void maxTerminalOperation() {
		//max with generic types
		List<Integer> max = Arrays.asList(5, 1, 6, 7, 9, 10, 3);
		//System.out.println(max.stream().max((a,b) -> a.compareTo(b)).get());
				
		//max with custom object
		Optional<Long> maxFours = DataSource.getData().stream()
			.map(Players::getFours).max((a,b) ->a.compareTo(b));
		//System.out.println(maxFours.get());
	}


	private static void minTerminalOperation() {
		//min with generic types
		List<Integer> min = Arrays.asList(5, 1, 6, 7, 9, 10, 3);
		//System.out.println(min.stream().min((a,b) -> a.compareTo(b)).get());
		
		//min with custom object
		 Optional<Long> minFours = DataSource.getData().stream()
				 .map(Players::getFours).min((a,b) ->a.compareTo(b));
		 //System.out.println(minFours.get());
	}


	private static void forEachOrderedTerminalOperation() {
		//forEachOrdered with generic types
		List<Integer> list = Arrays.asList(5, 1, 6, 7, 9, 10, 3);
		//list.stream().forEachOrdered(System.out::println);
						
		//forEachOrdered with custom types
		//DataSource.getData().stream().
		//	forEachOrdered(System.out::println);	
	}

	private static void forEachTerminalOperation() {
		//forEach with generic types
		List<Integer> list = Arrays.asList(5, 1, 6, 7, 9, 10, 3);
		//list.stream().forEach(System.out::println);
						
		//forEach with custom types
		//DataSource.getData().stream().
		//	forEach(System.out::println);				
	}

	private static void peekIntermediateOperation() {
		
		//peek with generic types
		List<Integer> list = Arrays.asList(5, 1, 6, 7, 9, 10, 3);
		//List<Integer> peekList = list.stream().peek(e -> 
		//	{System.out.println(e*2);})
		//		.collect(Collectors.toList());
		//System.out.println(peekList);
		
		//peek with custom types
		//DataSource.getData().stream().
		//	peek(e -> System.out.println(e.getName())).forEach(System.out::println);
	}

	private static void skipIntermediateOperation() {
		//skip with generic types
		List<Integer> list = Arrays.asList(5, 1, 6, 7, 9, 10, 3);
		//list.stream().skip(8).forEach(System.out::println);
		
		//skip with custom types
		//DataSource.getData().stream().
		//	skip(5).forEach(System.out::println);
	}

	private static void limitIntermediateOperation() {
		//limit with generic types
		List<Integer> list = Arrays.asList(5, 1, 6, 7, 9, 10, 3);
		//list.stream().limit(5).forEach(System.out::println);
		
		//limit with custom types
		//DataSource.getData().stream().distinct().
		//      limit(2).forEach(System.out::println);
	}

	private static void sortedIntermediateOperation() {
		//sorted with generic types
		List<Integer> list = Arrays.asList(5, 1, 6, 7, 9, 10, 3);
		//list.stream().sorted().forEach(System.out::println); //Natural order
						//or
		//list.stream().sorted(Comparator.naturalOrder())
		//	.forEach(System.out::println);
		
		//list.stream().sorted(Comparator.reverseOrder())//Reverse order
		//	.forEach(System.out::println);
		
		//sorted with custom types
		//DataSource.getData().stream().sorted(
		//		Comparator.comparing(Players::getName))
		//		.forEach(System.out::println);
		
		//DataSource.getData().stream().sorted(
		//		Comparator.comparing(Players::getName).reversed())
		//		.forEach(System.out::println);
	}

	private static void distinctIntermediateOperation() {
		//Distinct with generic types
		List<Integer> list = Arrays.asList(1,2,3,4,5,5,4,2);
		//list.stream().distinct().forEach(System.out::println);
		
		//Distinct with custom types
		//DataSource.getData().stream().distinct()
		//	.forEach(System.out::println);
		
	}

	private static void flatMapIntermediateOperation() {
		//flatMap with Generic values
		String[][] array = new String[][] {{"a", "b","c"}, {"d","e","f"}};
		//Arrays.stream(array).flatMap(x -> Arrays.stream(x))
		//.forEach(System.out::println);
		// [{"a", "b","c"} {"d","e","f"}] -> ["a", "b", "c", "d", "e", "f"]
		
	}

	private static void mapIntermediateOperation() {
		// Map with generic values
		List<String> list = Arrays.asList("1", "2", "3", "4", "5");
		//System.out.println(list);
		//list.stream().map(Integer::valueOf)
		//	.forEach(System.out::println);
		
		//Map with custom objects
		//DataSource.getData().stream().map(e -> e.getName())
		//		.forEach(System.out::println);
	}

	private static void filterIntermediateOperation() {
		
		//Filter with Generic type
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		//list.stream().filter(i->i%2==0).forEach(System.out::println);
		
		//Filter with Custom type
		//DataSource.getData().stream().filter(e -> e.getSixes() == 62)
		//	.forEach(System.out::println);
		
		
	}

	private static void creationOfStreams() {
		//Stream with fixed values
		Stream<Integer> stream = Stream.of(1,2,3,4,5);
		//stream.map(e -> e*2).forEach(System.out::println);
		
		//Stream with Array of values
		Stream<Integer> array = Stream.of(new Integer[]
				{10,20,30,40,50});
		//array.map(e -> e*2).forEach(System.out::println);
		
		//Stream with list of values
		List<Integer> list = new ArrayList<>();
		list.add(100);list.add(200);list.add(300);
		list.add(400);list.add(500);
		//list.stream().map(e -> (e+5)).forEach(System.out::println);
		
		//Stream with generate()
		Stream<Integer> generate = Stream.generate(
				() -> (new Random()).nextInt(100));
		//generate.limit(5).forEach(System.out::println);
		
		//Concatenation of streams
		Stream<Integer> concat = Stream.concat(stream, array);
		//concat.forEach(System.out::println);
		
		//Creation of empty stream
		Stream<Integer> empty = Stream.empty();
		//empty.forEach(System.out::println);
		
		//Iterate with Stream
		Stream<Integer> iterate = Stream
				.iterate(5, i->i<200, i -> i*2);
		//iterate.forEach(System.out::println);
				
	}
}
	
