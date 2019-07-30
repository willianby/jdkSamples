package br.com.yamashita.sample.helper;

import java.util.ArrayList;
import java.util.List;

public class ForEachTests {

	/*
		@see https://www.javatpoint.com/java-8-foreach
	 */
	public static void forEachSamples() {
		/* Java forEach loop
			Java provides a new method forEach() to iterate the elements.
			It is defined in Iterable and Stream interface.
			It is a default method defined in the Iterable interface.
			Collection classes which extends Iterable interface can use forEach loop to iterate elements.

			This method takes a single parameter which is a functional interface.
			So, you can pass lambda expression as an argument.

			forEach() Signature in Iterable Interface:
				default void forEach(Consumer<super T>action)
		 */

		List<String> gamesList = new ArrayList<String>();
		gamesList.add("Football");
		gamesList.add("Cricket");
		gamesList.add("Chess");
		gamesList.add("Hocky");
		System.out.println("------------Iterating by passing lambda expression--------------");
		gamesList.forEach(games -> System.out.println(games));

		/* Java Stream forEachOrdered() Method
			Along with forEach() method, Java provides one more method forEachOrdered().
			It is used to iterate elements in the order specified by the stream.

			Singnature:
				void forEachOrdered(Consumer<? super T> action)
			@see https://stackoverflow.com/questions/32797579/foreach-vs-foreachordered-in-java-8-stream
		 */
		System.out.println("------------Iterating parallel by passing lambda expression---------------");
		gamesList.stream().parallel().forEach(games -> System.out.println(games));
		System.out.println("------------Iterating parallel by passing lambda expression---------------");
		gamesList.stream().parallel().forEachOrdered(games -> System.out.println(games));
		System.out.println("------------Iterating by passing method reference---------------");
		gamesList.stream().parallel().forEach(System.out::println);
		System.out.println("------------Iterating parallel by passing method reference---------------");
		gamesList.stream().parallel().forEachOrdered(System.out::println);
	}
}
