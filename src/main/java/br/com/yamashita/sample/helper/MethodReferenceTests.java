package br.com.yamashita.sample.helper;

import java.util.function.BiFunction;

public class MethodReferenceTests {

	/*
		@see https://www.javatpoint.com/java-8-method-reference
	 */
	public static void methodReferenceSamples() {
		/* Java Method References
			Java provides a new feature called method reference in Java 8.
			Method reference is used to refer method of functional interface.
			It is compact and easy form of lambda expression.
			Each time when you are using lambda expression to just referring a method,
			you can replace your lambda expression with method reference. In this tutorial,
			we are explaining method reference concept in detail.

			Types of Method References
			There are following types of method references in java:

			Reference to a static method.
			Reference to an instance method.
			Reference to a constructor.
		 */

		/* Reference to a Static Method
			You can refer to static method defined in the class.
			Following is the syntax and example which describe the
			process of referring static method in Java.
		 */

		// Referring static method
		Sayable sayable = MethodReferenceTests::saySomething;
		// Calling interface method
		sayable.say();

		Thread t2 = new Thread(MethodReferenceTests::ThreadStatus);
		t2.start();

		/* You can also use predefined functional interface to refer methods.
		In the following example, we are using BiFunction interface and using it's apply() method.
		 */
		BiFunction<Integer, Integer, Integer> adder = Arithmetic::add;
		int result = adder.apply(10, 20);
		System.out.println(result);

		/* You can also override static methods by referring methods.
			In the following example, we have defined and overloaded three add methods.
		 */
		BiFunction<Integer, Integer, Integer> adder1 = Arithmetic::add;
		BiFunction<Integer, Float, Float> adder2 = Arithmetic::add;
		BiFunction<Float, Float, Float> adder3 = Arithmetic::add;
		int result1 = adder1.apply(10, 20);
		float result2 = adder2.apply(10, 20.0f);
		float result3 = adder3.apply(10.0f, 20.0f);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);

		MethodReferenceTests methodReference = new MethodReferenceTests(); // Creating object
		// Referring non-static method using reference
		SayableInstance sayableInstance = methodReference::saySomethingInstance;
		// Calling interface method
		sayableInstance.saySomethingInstance();
		// Referring non-static method using anonymous object
		SayableInstance sayable2 = new MethodReferenceTests()::saySomethingInstance; // You can use anonymous object also
		// Calling interface method
		sayable2.saySomethingInstance();

		/* Reference to an Instance Method
			like static methods, you can refer instance methods also.
			In the following example,
			we are describing the process of referring the instance method.
		 */
		// In the following example, we are referring non-static methods.
		// You can refer methods by class object and anonymous object.
		MethodReferenceTests methodReferenceNonStatic2 = new MethodReferenceTests(); // Creating object
		// Referring non-static method using reference
		SayableNonStatic sayableNonStatic = methodReference::saySomethingNonStatic;
		// Calling interface method
		sayable.say();
		// Referring non-static method using anonymous object
		SayableNonStatic sayableNonStatic2 = new MethodReferenceTests()::saySomethingNonStatic; // You can use anonymous object also
		// Calling interface method
		sayableNonStatic2.saySomethingNonStatic();


		/* In the following example,
			we are referring instance (non-static) method.
			Runnable interface contains only one abstract method.
			So, we can use it as functional interface.
		 */
		Thread t3 = new Thread(new MethodReferenceTests()::printnMsg);
		t3.start();

		/* In the following example, we are using BiFunction interface.
			It is a predefined interface and contains a functional method apply().
			Here, we are referring add method to apply method.
		 */
		BiFunction<Integer, Integer, Integer> addNonStatic = new Arithmetic()::addNonStatic;
		int result4 = adder.apply(10, 20);
		System.out.println(result);

		/* Reference to a Constructor
			You can refer a constructor by using the new keyword.
			Here, we are referring constructor with the help of functional interface.
		 */
		Messageable hello = Message::new;
		hello.getMessage("Hello");
	}

	public static void saySomething() {
		System.out.println("Hello, this is static method.");
	}

	public static void ThreadStatus() {
		System.out.println("Thread is running...");
	}

	public void saySomethingInstance() {
		System.out.println("Hello, this is static method.");
	}

	public void saySomethingNonStatic() {
		System.out.println("Hello, this is static method.");
	}

	public void printnMsg() {
		System.out.println("Hello, this is instance method");
	}

	interface Messageable {
		Message getMessage(String msg);
	}

	interface Sayable {
		void say();
	}

	interface SayableInstance {
		void saySomethingInstance();
	}

	interface SayableNonStatic {
		void saySomethingNonStatic();
	}

	static class Message {
		Message(String msg) {
			System.out.print(msg);
		}
	}

	static class Arithmetic {
		public static int add(int a, int b) {
			return a + b;
		}

		public static float add(int a, float b) {
			return a + b;
		}

		public static float add(float a, float b) {
			return a + b;
		}

		public int addNonStatic(int a, int b) {
			return a + b;
		}
	}
}
