package br.com.yamashita.sample.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaCollectorsTests {

	/*
		@see https://www.javatpoint.com/java-8-collectors
	 */
	public static void collectorsSamples() {
		/* Java Collectors
			Collectors is a final class that extends Object class.
			It provides reduction operations, such as accumulating elements into collections,
				summarizing elements according to various criteria, etc.

			Java Collectors class provides various methods to deal with element

		 */
		List<Product> productsList = new ArrayList<>();
		//Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		List<Float> productPriceList =
				productsList.stream()
						.map(x -> x.price)                // fetching price
						.collect(Collectors.toList());  // collecting as list
		System.out.println(productPriceList);

		/*
			Java Collectors Example: Converting Data as a Set
		 */
		Set<Float> productPriceList2 =
				productsList.stream()
						.map(x -> x.price)               // fetching price
						.collect(Collectors.toSet());  // collecting as list
		System.out.println(productPriceList2);

		/*
			Java Collectors Example: using sum method
		 */
		Double sumPrices =
				productsList.stream()
						.collect(Collectors.summingDouble(x -> x.price));  // collecting as list
		System.out.println("Sum of prices: " + sumPrices);
		Integer sumId =
				productsList.stream().collect(Collectors.summingInt(x -> x.id));
		System.out.println("Sum of id's: " + sumId);

		/*
			Java Collectors Example: Getting Product Average Price
		 */
		Double average = productsList.stream()
				.collect(Collectors.averagingDouble(p -> p.price));
		System.out.println("Average price is: " + average);

		/*
			Java Collectors Example: Counting Elements
		 */
		Long noOfElements = productsList.stream()
				.collect(Collectors.counting());
		System.out.println("Total elements : " + noOfElements);
	}

	static class Product {
		int id;
		String name;
		float price;

		public Product(int id, String name, float price) {
			this.id = id;
			this.name = name;
			this.price = price;
		}
	}
}
