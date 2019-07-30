package br.com.yamashita.sample.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LambdaTests {

	/*
		@see https://www.javatpoint.com/java-lambda-expressions
	 */
	public static void lambdaSamples() {
		/* Java Lambda Expressions
			Lambda expression is a new and important feature of Java which was included in Java SE 8.
			It provides a clear and concise way to represent one method interface using an expression.
			It is very useful in collection library. It helps to iterate, filter and extract data from collection.

			The Lambda expression is used to provide the implementation of an interface which has functional interface.
			It saves a lot of code. In case of lambda expression,
			we don't need to define the method again for providing the implementation.
			Here, we just write the implementation code.

			Java lambda expression is treated as a function, so compiler does not create .class file.

			Functional Interface
			Lambda expression provides implementation of functional interface.
			An interface which has only one abstract method is called functional interface.
			Java provides an anotation @FunctionalInterface,
			which is used to declare an interface as functional interface.

			Why use Lambda Expression
			To provide the implementation of Functional interface.
			Less coding.
			Java Lambda Expression Syntax
			(argument-list) -> {body}
			Java lambda expression is consisted of three components.

			1) Argument-list: It can be empty or non-empty as well.

			2) Arrow-token: It is used to link arguments-list and body of expression.

			3) Body: It contains expressions and statements for lambda expression.

			No Parameter Syntax

			() -> {
			//Body of no parameter lambda
			}
			One Parameter Syntax

			(p1) -> {
			//Body of single parameter lambda
			}
			Two Parameter Syntax

			(p1,p2) -> {
			//Body of multiple parameter lambda
			}
			Let's see a scenario where we are not implementing Java lambda expression.
			Here, we are implementing an interface without using lambda expression.

		 */

		int width = 10;

		//without lambda, Drawable implementation using anonymous class
		Drawable d = new Drawable() {
			public void draw() {
				System.out.println("Drawing " + width);
			}
		};
		d.draw();

		//with lambda
		Drawable d2 = () -> {
			System.out.println("Drawing " + width);
		};
		d2.draw();


		//No Parameter
		Sayable s = () -> {
			return "I have nothing to say.";
		};
		System.out.println(s.say());


		// Lambda expression with single parameter.
		SayableWithParameter s1 = (name) -> {
			return "Hello, " + name;
		};
		System.out.println(s1.say("Sonoo"));

		// You can omit function parentheses
		SayableWithParameter s2 = name -> {
			return "Hello, " + name;
		};
		System.out.println(s2.say("Sonoo"));

		// Multiple parameters in lambda expression
		Addable ad1 = (a, b) -> (a + b);
		System.out.println(ad1.add(10, 20));

		// Multiple parameters with data type in lambda expression
		Addable ad2 = (int a, int b) -> (a + b);
		System.out.println(ad2.add(100, 200));

		// Lambda expression without return keyword.
		Addable ad3 = (a, b) -> (a + b);
		System.out.println(ad1.add(10, 20));

		// Lambda expression with return keyword.
		Addable ad4 = (int a, int b) -> {
			return (a + b);
		};
		System.out.println(ad2.add(100, 200));

		//Java Lambda Expression Example: Foreach Loop
		List<String> list = new ArrayList<String>();
		list.add("ankit");
		list.add("mayank");
		list.add("irfan");
		list.add("jai");

		list.forEach(
				(n) -> System.out.println(n)
		);

		// You can pass multiple statements in lambda expression
		SayableWithParameter person = (name) -> {
			String str1 = "Say my name... ";
			String str2 = str1 + name;
			return str2;
		};
		System.out.println(person.say("Heisenberg!"));

		//Thread Example without lambda
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("Thread1 is running...");
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		//Thread Example with lambda
		Runnable r2 = () -> {
			System.out.println("Thread2 is running...");
		};
		Thread t2 = new Thread(r2);
		t2.start();

		/* Java Lambda Expression Example: Comparator
			Java lambda expression can be used in the collection framework.
			It provides efficient and concise way to iterate, filter and fetch data.
			Following are some lambda and collection examples provided.
		 */
		List<Product> productList = new ArrayList<Product>();

		//Adding Products
		productList.add(new Product(1, "HP Laptop", 25000f));
		productList.add(new Product(3, "Keyboard", 300f));
		productList.add(new Product(2, "Dell Mouse", 150f));

		System.out.println("Sorting on the basis of name...");

		// implementing lambda expression
		Collections.sort(productList, (p1, p2) -> {
			return p1.name.compareTo(p2.name);
		});
		for (Product p : productList) {
			System.out.println(p.id + " " + p.name + " " + p.price);
		}

		/*
			Java Lambda Expression Example: Filter Collection Data
		 */
		List<Product> productFilterList = new ArrayList<Product>();
		productFilterList.add(new Product(1, "Samsung A5", 17000f));
		productFilterList.add(new Product(3, "Iphone 6S", 65000f));
		productFilterList.add(new Product(2, "Sony Xperia", 25000f));
		productFilterList.add(new Product(4, "Nokia Lumia", 15000f));
		productFilterList.add(new Product(5, "Redmi4 ", 26000f));
		productFilterList.add(new Product(6, "Lenevo Vibe", 19000f));

		// using lambda to filter data
		Stream<Product> filtered_data = productFilterList.stream().filter(p -> p.price > 20000);

		// using lambda to iterate through collection
		filtered_data.forEach(
				product -> System.out.println(product.name + ": " + product.price)
		);
	}

	//Lambda tests
	interface Drawable {
		void draw();
	}

	//Lambda tests
	interface Sayable {
		String say();
	}

	//Lambda tests
	interface SayableWithParameter {
		String say(String name);
	}

	//Lambda tests
	interface Addable {
		int add(int a, int b);
	}

	//Lambda tests
	static class Product {
		int id;
		String name;
		float price;

		public Product(int id, String name, float price) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
		}
	}
}
