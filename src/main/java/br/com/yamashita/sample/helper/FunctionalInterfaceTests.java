package br.com.yamashita.sample.helper;

public class FunctionalInterfaceTests {

	/*
		@see https://www.javatpoint.com/java-8-functional-interfaces
	 */
	public static void functionalInterfaces() {
		/* Java Functional Interfaces
			An Interface that contains exactly one abstract
			 method is known as functional interface.
			 It can have any number of default, static methods but can
			 contain only one abstract method. It can also declare methods of object class.

			Functional Interface is also known as Single Abstract Method
			Interfaces or SAM Interfaces.
			It is a new feature in Java, which helps to achieve functional programming approach.
		 */
		FunctionalInterfaceExample fie = new FunctionalInterfaceExample();
		fie.say("Hello there");

		/*
			A functional interface can have methods of object class. See in the following example.
		 */
		FunctionalInterfaceExample2 fie2 = new FunctionalInterfaceExample2();
		fie2.say("Hello there");

		/*
			In the following example, a functional interface is extending to a non-functional interface.
		 */

		FunctionalInterfaceExample3 fie3 = new FunctionalInterfaceExample3();
		fie3.say("Hello there");
		fie3.doIt();
	}

	@FunctionalInterface
	interface Sayable {
		void say(String msg);
	}

	@FunctionalInterface
	interface Sayable2 {
		void say(String msg);   // abstract method

		// It can contain any number of Object class methods.
		int hashCode();

		String toString();

		boolean equals(Object obj);
	}

	interface Doable {
		default void doIt() {
			System.out.println("Do it now");
		}
	}

	@FunctionalInterface
	interface Sayable3 extends Doable {
		void say(String msg);   // abstract method
	}

	public static class FunctionalInterfaceExample implements Sayable {
		public void say(String msg) {
			System.out.println(msg);
		}
	}

	public static class FunctionalInterfaceExample2 implements Sayable2 {
		public void say(String msg) {
			System.out.println(msg);
		}
	}

	public static class FunctionalInterfaceExample3 implements Sayable3 {
		public void say(String msg) {
			System.out.println(msg);
		}
	}
}
