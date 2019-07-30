package br.com.yamashita.sample.helper;

import java.util.StringJoiner;

public class StringJoinerTests {

	/*
		@see https://www.javatpoint.com/java-stringjoiner
	 */
	public static void stringJoinerSamples() {
		/* Java StringJoiner
			Java added a new final class StringJoiner in java.util package.
			It is used to construct a sequence of characters separated by a delimiter.
			Now, you can create string by passing delimiters like comma(,), hyphen(-) etc.
			You can also pass prefix and suffix to the char sequence.
		 */
		StringJoiner joinNames = new StringJoiner(","); // passing comma(,) as delimiter

		// Adding values to StringJoiner
		joinNames.add("Rahul");
		joinNames.add("Raju");
		joinNames.add("Peter");
		joinNames.add("Raheem");

		System.out.println(joinNames);

		/*
			Java StringJoiner Example: adding prefix and suffix
		 */
		StringJoiner joinNames2 = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter

		// Adding values to StringJoiner
		joinNames2.add("Rahul");
		joinNames2.add("Raju");
		joinNames2.add("Peter");
		joinNames2.add("Raheem");

		System.out.println(joinNames2);

		/* StringJoiner Example: Merge Two StringJoiner
			The merge() method merges two StringJoiner objects excluding of
			prefix and suffix of second StringJoiner object.
		 */
		StringJoiner joinNames3 = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter

		// Adding values to StringJoiner
		joinNames3.add("Rahul").add("Raju");

		// Creating StringJoiner with :(colon) delimiter
		StringJoiner joinNames4 = new StringJoiner(":", "[", "]");  // passing colon(:) and square-brackets as delimiter

		// Adding values to StringJoiner
		joinNames4.add("Peter").add("Raheem");

		// Merging two StringJoiner
		StringJoiner merge = joinNames3.merge(joinNames4);
		System.out.println(merge);

	}
}
