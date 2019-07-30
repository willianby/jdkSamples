package br.com.yamashita.sample.helper;

import java.util.ArrayList;
import java.util.List;

public class enhancedTypeInferenceTests {

	/*
		@see https://www.javatpoint.com/java-8-type-inference
	 */
	public static void enhancedTypeInferenceSamples() {

		/* Java Type Inference
			Type inference is a feature of Java which provides ability to compiler to look
			at each method invocation and corresponding declaration to determine the type of arguments.

			Java provides improved version of type inference in Java 8.
			the following example explains, how we can use type inference in our code:

			Here, we are creating arraylist by mentioning integer type explicitly at both side.
			The following approach is used earlier versions of Java.
				List<Integer> list = new ArrayList<Integer>();

			In the following declaration, we are mentioning type of arraylist at one side.
			This approach was introduce in Java 7.
			Here, you can left second side as blank diamond and compiler will infer type
			of it by type of reference variable.
				List<Integer> list2 = new ArrayList<>();

			Improved Type Inference
			In Java 8, you can call specialized method without explicitly mentioning of type of arguments.
				showList(new ArrayList<>());
		 */
		// An old approach(prior to Java 7) to create a list
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(11);
		showList(list1);
		// Java 7
		List<Integer> list2 = new ArrayList<>(); // You can left it blank, compiler can infer type
		list2.add(12);
		showList(list2);
		// Compiler infers type of ArrayList, in Java 8
		showList(new ArrayList<>());


		/* Java Type Inference Example 2
			You can also create your own custom generic class and methods.
			In the following example, we are creating our own generic class and method.
		 */
		GenericClass<String> genericClass = new GenericClass<String>();
		genericClass.setName("Peter");
		System.out.println(genericClass.getName());

		GenericClass<String> genericClass2 = new GenericClass<>();
		genericClass2.setName("peter");
		System.out.println(genericClass2.getName());

		// New improved type inference
		System.out.println(genericClass2.genericMethod(new GenericClass<>()));
	}

	public static void showList(List<Integer> list) {
		if (!list.isEmpty()) {
			list.forEach(System.out::println);
		} else System.out.println("list is empty");
	}

	static class GenericClass<X> {
		X name;

		public X getName() {
			return name;
		}

		public void setName(X name) {
			this.name = name;
		}

		public String genericMethod(GenericClass<String> x) {
			x.setName("John");
			return x.name;
		}
	}
}
