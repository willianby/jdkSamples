package br.com.yamashita;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Java7Sample {

	static void testesJava7() {
		/* Java 7 JDBC Improvements
			https://www.javatpoint.com/java-7-jdbc-improvement
		 */

		/* String in Switch Statement
			In Java 7, Java allows you to use string objects in the expression of switch statement.
			In order to use string, you need to consider the following points:

			It must be only string object.
			Object game = "Hockey"; // It is not allowed
			    String game = "Hockey"; // It is OK.
			String object is case sensitive.
			"Hickey" and "hocker" are not equal.
			No Null object
			be careful while passing string object, passing a null object cause to NullPointerException.
		 */
		String game = "Cricket";
		switch (game) {
			case "Hockey":
				System.out.println("Let's play Hockey");
				break;
			case "Cricket":
				System.out.println("Let's play Cricket");
				break;
			case "Football":
				System.out.println("Let's play Football");
		}

		/* Java 7 Catch Multiple Exceptions
			Java allows you to catch multiple type exceptions in a single catch block.
			It was introduced in Java 7 and helps to optimize code.

			You can use vertical bar (|) to separate multiple exceptions in catch block.

			An old, prior to Java 7 approach to handle multiple exceptions.
		 */
		try {
			int[] array = new int[10];
			array[10] = 30 / 0;
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		/* The try-with-resources statement
			In Java, the try-with-resources statement is a try statement that declares one or more resources. The resource is as an object that must be closed after finishing the program. The try-with-resources statement ensures that each resource is closed at the end of the statement execution.

			You can pass any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable.

			The following example writes a string into a file. It uses an instance of FileOutputStream to write data into the file. FileOutputStream is a resource that must be closed after the program is finished with it. So, in this example, closing of resource is done by itself try.
		 */

		// Using multiple resources
		String abcFilePath = "/Users/wyamashita/Dev/Repositorios/jdk12Sample/jdk12/src/main/resources/abc.txt";
		try (FileOutputStream fileOutputStream = new FileOutputStream(abcFilePath);
		     InputStream input = new FileInputStream(abcFilePath)) {
			// -----------------------------Code to write data into file--------------------------------------------//
			String msg = "Welcome to Java Tutorial!";
			byte[] byteArray = msg.getBytes();  // Converting string into byte array
			fileOutputStream.write(byteArray);  // Writing  data into file
			System.out.println("------------Data written into file--------------");
			System.out.println(msg);
			// -----------------------------Code to read data from file---------------------------------------------//
			// Creating input stream instance
			DataInputStream inst = new DataInputStream(input);
			int data = input.available();
			// Returns an estimate of the number of bytes that can be read from this input stream.
			byte[] byteArray2 = new byte[data]; //
			inst.read(byteArray2);
			String str = new String(byteArray2); // passing byte array into String constructor
			System.out.println("------------Data read from file--------------");
			System.out.println(str); // display file data
		} catch (Exception exception) {
			System.out.println(exception);
		}

		/* Type Inference for Generic Instance Creation
			In Java 7, Java provides improved compiler which is enough smart to infer the type of generic instance.
			Now, you can replace the type arguments with an empty set of type parameters (<>).
			This pair of angle brackets is informally called the diamond.
		 */
		// In Java 6 and earlier
		List<Integer> listGeneric = new ArrayList<Integer>();
		listGeneric.add(12);
		for (Integer element : listGeneric) {
			System.out.println(element);
		}
		// In Java 7
		List<Integer> listGeneric2 = new ArrayList<>(); // Here, diamond is used
		listGeneric2.add(12);
		for (Integer element : listGeneric2) {
			System.out.println(element);
		}

		/* Java Numeric Literals with Underscore
			Java allows you to use underscore in numeric literals. This feature was introduced in Java 7.
			This feature enables you, for example, to separate groups of digits in numeric literals,
			which can improve the readability of your source code.

			The following points are considerable:

			You cannot use underscore at the beginning or end of a number.
			Ex. int a = _10; // Error, this is an identifier, not a numeric literal
			Ex. int a = 10_; // Error, cannot put underscores at the end of a number
			You cannot use underscore adjacent to a decimal point in a floating point literal.
			Ex. float a = 10._0; // Error, cannot put underscores adjacent to a decimal point
			Ex. float a = 10_.0; // Error, cannot put underscores adjacent to a decimal point
			You cannot use underscore prior to an F or L suffix
			Ex. long a = 10_100_00_L; // Error, cannot put underscores prior to an L suffix
			Ex. float a = 10_100_00_F; // Error, cannot put underscores prior to an F suffix
			You cannot use underscore in positions where a string of digits is expected.
		 */
		// Underscore in integral literal
		int a = 10_00000;
		System.out.println("a = " + a);
		// Underscore in floating literal
		float b = 10.5_000f;
		System.out.println("b = " + b);
		// Underscore in binary literal
		int c = 0B10_10;
		System.out.println("c = " + c);
		// Underscore in hexadecimal literal
		int d = 0x1_1;
		System.out.println("d = " + d);
		// Underscore in octal literal
		int e = 01_1;
		System.out.println("e = " + e);
	}
}
