package br.com.yamashita.sample.helper;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Declaring repeatable annotation type
@Repeatable(Games.class)
@interface Game {
	String name();

	String day();
}

// Declaring container for repeatable annotation type
@Retention(RetentionPolicy.RUNTIME)
@interface Games {
	Game[] value();
}

// Repeating annotation
@Game(name = "Cricket", day = "Sunday")
@Game(name = "Hockey", day = "Friday")
@Game(name = "Football", day = "Saturday")
public class TypeAnnotationTests {
	/*
		@see https://www.javatpoint.com/java-8-type-annotations-and-repeating-annotations
	 */
	public static void typeAnnotationSamples() {
		/* Java Type and Repeating Annotations
			Java Type Annotations
			Java 8 has included two new features repeating and type annotations
			in its prior annotations topic. In early Java versions,
			you can apply annotations only to declarations.
			After releasing of Java SE 8 , annotations can be applied to any type use.
			It means that annotations can be used anywhere you use a type.
			For example, if you want to avoid NullPointerException in your code,
			you can declare a string variable like this:

			@NonNull String str;
			Following are the examples of type annotations not work on jdk8:
			//TODO: check JSR 305 status - https://jcp.org/en/jsr/detail?id=305
			//looks dead
			//https://stackoverflow.com/questions/35892063/which-nonnull-java-annotation-to-use
			These annotations are not available in JDK8:
			check: https://dzone.com/articles/java-8-type-annotations

			@NonNull List<String>
			List<@NonNull String> str
			Arrays<@NonNegative Integer> sort
			@Encrypted File file
			@Open Connection connection
			void divideInteger(int a, int b) throws @ZeroDivisor ArithmeticException
		 */
		// Getting annotation by type into an array
		Game[] game = TypeAnnotationTests.class.getAnnotationsByType(Game.class);
		for (Game game2 : game) {    // Iterating values
			System.out.println(game2.name() + " on " + game2.day());
		}

	}
}
