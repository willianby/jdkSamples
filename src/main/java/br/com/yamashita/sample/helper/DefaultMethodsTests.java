package br.com.yamashita.sample.helper;

public class DefaultMethodsTests {

	/*
		@see https://www.javatpoint.com/java-default-methods
	 */
	public static void defaultMethodsSamples() {

		/* Java Default Methods
			Java provides a facility to create default methods inside the interface.
				Methods which are defined inside the interface and tagged with default are
				known as default methods. These methods are non-abstract methods.

			Java Default Method Example
			In the following example, Sayable is a functional interface that contains a
				default and an abstract method.
				The concept of default method is used to define a method with default implementation.
				You can override default method also to provide more specific implementation for the method.

			Let's see a simple
		 */
		DefaultMethods dm = new DefaultMethods();
		dm.say();   // calling default method
		dm.sayMore("Work is worship");  // calling abstract method

		/* Static Methods inside Java 8 Interface
			You can also define static methods inside the interface.
			Static methods are used to define utility methods.
			The following example explain, how to implement static method in interface?
		 */
		DefaultMethodsStatic dmStatic = new DefaultMethodsStatic();
		dmStatic.say();                                // calling default method
		dmStatic.sayMore("Work is worship");      // calling abstract method
		SayableStatic.sayLouder("Helloooo...");   // calling static method

		/* Abstract Class vs Java 8 Interface
			After having default and static methods inside the interface,
				we think about the need of abstract class in Java.
			An interface and an abstract class is almost similar except that you
				can create constructor in the abstract class whereas you can't do this in interface.
		 */
		AbstractTest a = new AbstractTest();
		int result1 = a.add(20, 10);    // calling abstract method
		int result2 = a.sub(20, 10);    // calling non-abstract method
		int result3 = AbstractClass.multiply(20, 10); // calling static method
		System.out.println("Addition: " + result1);
		System.out.println("Substraction: " + result2);
		System.out.println("Multiplication: " + result3);
	}

	interface Sayable {
		// Default method
		default void say() {
			System.out.println("Hello, this is default method");
		}

		// Abstract method
		void sayMore(String msg);
	}

	interface SayableStatic {
		// static method
		static void sayLouder(String msg) {
			System.out.println(msg);
		}

		// default method
		default void say() {
			System.out.println("Hello, this is default method");
		}

		// Abstract method
		void sayMore(String msg);
	}

	public static class DefaultMethods implements Sayable {
		public void sayMore(String msg) {        // implementing abstract method
			System.out.println(msg);
		}
	}

	public static class DefaultMethodsStatic implements SayableStatic {
		public void sayMore(String msg) {     // implementing abstract method
			System.out.println(msg);
		}
	}

	abstract static class AbstractClass {
		public AbstractClass() {        // constructor
			System.out.println("You can create constructor in abstract class");
		}

		static int multiply(int a, int b) {  // static method
			return a * b;
		}

		abstract int add(int a, int b); // abstract method

		int sub(int a, int b) {      // non-abstract method
			return a - b;
		}
	}

	public static class AbstractTest extends AbstractClass {
		public int add(int a, int b) {        // implementing abstract method
			return a + b;
		}
	}
}
