package br.com.yamashita.sample.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSampleTests {

	/*
		@see https://www.javatpoint.com/java-8-stream
	 */
	public static void streamSamples() {
		/* Java 8 Stream
			Java provides a new additional package in Java 8 called java.util.stream. This package consists of classes, interfaces and enum to allows functional-style operations on the elements. You can use stream by importing java.util.stream package.
			Stream provides following features:
			 - Stream does not store elements.
			    It simply conveys elements from a source such as a data structure, an array, or an I/O channel,
			    through a pipeline of computational operations.
			 - Stream is functional in nature.
			    Operations performed on a stream does not modify it's source.
			    For example, filtering a Stream obtained from a collection produces a new Stream without the filtered elements, rather than removing elements from the source collection.
			 - Stream is lazy and evaluates code only when required.
			 - The elements of a stream are only visited once during the life of a stream.
			    Like an Iterator, a new stream must be generated to revisit the same elements of the source.

			You can use stream to filter, collect, print, and convert from one data structure to other etc. In the following examples, we have apply various operations with the help of stream.
			Java Stream Interface Methods = @see https://www.javatpoint.com/java-8-stream
		 */

		/* Java Example: Filtering Collection without using Stream
			In the following example, we are filtering data without using stream.
			This approach we are used before the stream package was released.
		 */

		List<Product> productsList = new ArrayList<Product>();
		//Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		List<Float> productPriceList = new ArrayList<Float>();
		//without Stream
		for (Product product : productsList) {
			// filtering data of list
			if (product.price < 30000) {
				productPriceList.add(product.price);    // adding price to a productPriceList
			}
		}
		System.out.println(productPriceList);   // displaying data

		//With Stream
		List<Float> productPriceList2 = productsList.stream()
				.filter(p -> p.price < 30000)  // filtering data
				.map(p -> p.price)               // fetching price
				.collect(Collectors.toList()); // collecting as list
		System.out.println(productPriceList2);


		/* Java Stream Iterating Example
			You can use stream to iterate any number of times.
			Stream provides predefined methods to deal with the logic you implement.
			In the following example, we are iterating,
			filtering and passed a limit to fix the iteration.
		 */
		Stream.iterate(1, element -> element + 1)
				.filter(element -> element % 5 == 0)
				.limit(5)
				.forEach(System.out::println);

		/* Java Stream Example: Filtering and Iterating Collection
			In the following example, we are using filter() method.
			Here, you can see code is optimized and very concise.
		 */
		// This is more compact approach for filtering data
		productsList.stream()
				.filter(product -> product.price == 30000)
				.forEach(product -> System.out.println(product.name));

		/* Java Stream Example : reduce() Method in Collection
			This method takes a sequence of input elements and combines
			them into a single summary result by repeated operation.
			For example, finding the sum of numbers, or accumulating elements into a list.

			In the following example, we are using reduce() method,
			which is used to sum of all the product prices.
		 */
		// This is more compact approach for filtering data
		Float totalPrice = productsList.stream()
				.map(product -> product.price)
				.reduce(0.0f, (sum, price) -> sum + price);   // accumulating price
		System.out.println(totalPrice);
		// More precise code
		float totalPrice2 = productsList.stream()
				.map(product -> product.price)
				.reduce(0.0f, Float::sum);   // accumulating price, by referring method sum of Float class
		System.out.println(totalPrice2);

		/* Java Stream Example: Sum by using Collectors Methods
			We can also use collectors to compute sum of numeric values.
			In the following example, we are using Collectors class
			and it's specified methods to compute sum of all the product prices.
		 */
		// Using Collectors's method to sum the prices.
		double totalPrice3 = productsList.stream()
				.collect(Collectors.summingDouble(product -> product.price));
		System.out.println(totalPrice3);

		/* Java Stream Example: Find Max and Min Product Price
			Following example finds min and max product price by using stream.
			It provides convenient way to find values without using imperative approach.
		 */
		// max() method to get max Product price
		Product productA = productsList.stream()
				.max((product1, product2) ->
						product1.price > product2.price ? 1 : -1).get();

		System.out.println(productA.price);
		// min() method to get min Product price
		Product productB = productsList.stream()
				.max((product1, product2) ->
						product1.price < product2.price ? 1 : -1).get();
		System.out.println(productB.price);

		/*
			Java Stream Example: count() Method in Collection
		 */
		// count number of products based on the filter
		long count = productsList.stream()
				.filter(product -> product.price < 30000)
				.count();
		System.out.println(count);

		/* Java Stream Example : Convert List into Set
			stream allows you to collect your result in any various forms.
			You can get you result as set, list or map and can perform manipulation on the elements.
		 */
		// Converting product List into Set
		Set<Float> productPriceList3 =
				productsList.stream()
						.filter(product -> product.price < 30000)   // filter product on the base of price
						.map(product -> product.price)
						.collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)
		System.out.println(productPriceList3);

		/*
			Java Stream Example : Convert List into Map
		 */
		// Converting Product List into a Map
		Map<Integer, String> productPriceMap =
				productsList.stream()
						.collect(Collectors.toMap(p -> p.id, p -> p.name));

		System.out.println(productPriceMap);

		/*
			Method Reference in stream
		 */
		List<Float> productPriceList4 =
				productsList.stream()
						.filter(p -> p.price > 30000)   // filtering data
						.map(Product::getPrice)         // fetching price by referring getPrice method
						.collect(Collectors.toList());  // collecting as list
		System.out.println(productPriceList4);

		/* Java Stream Filter
			Java stream provides a method filter() to filter stream elements on the basis
				of given predicate. Suppose you want to get only even elements of your list
				then you can do this easily with the help of filter method.

			This method takes predicate as an argument and returns
				a stream of consisting of resulted elements.

			Signature
				The signature of Stream filter() method is given below:

				Stream<T> filter(Predicate<? super T> predicate)
				Parameter:
				predicate: It takes Predicate reference as an argument.
					Predicate is a functional interface. So, you can also pass lambda expression here.

				Return
				It returns a new stream.
		 */

		/* Java Stream filter() example
			In the following example, we are fetching and iterating filtered data.
		 */
		productsList.stream()
				.filter(p -> p.price > 30000)     // filtering price
				.map(pm -> pm.price)             // fetching price
				.forEach(System.out::println);  // iterating price
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

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public float getPrice() {
			return price;
		}
	}


}
