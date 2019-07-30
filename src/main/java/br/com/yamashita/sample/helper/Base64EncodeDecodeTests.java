package br.com.yamashita.sample.helper;

import java.util.Base64;

public class Base64EncodeDecodeTests {

	/*
		@see https://www.javatpoint.com/java-base64-encode-decode
	 */
	public static void encodeDecodeSamples() {

		/* Java Base64 Encode and Decode
			Java provides a class Base64 to deal with encryption.
				You can encrypt and decrypt your data by using provided methods.
				You need to import java.util.Base64 in your source file to use its methods.

			This class provides three different encoders and decoders to encrypt information at each level.
				You can use these methods at the following levels.

			Basic Encoding and Decoding
			It uses the Base64 alphabet specified by Java in RFC 4648 and RFC 2045 for encoding and decoding operations.
				The encoder does not add any line separator character.
				The decoder rejects data that contains characters outside the base64 alphabet.

			URL and Filename Encoding and Decoding
			It uses the Base64 alphabet specified by Java in RFC 4648 for encoding and decoding operations.
				The encoder does not add any line separator character.
				The decoder rejects data that contains characters outside the base64 alphabet.

			MIME
			It uses the Base64 alphabet as specified in RFC 2045 for encoding and decoding operations.
				The encoded output must be represented in lines of no more than 76
					characters each and uses a carriage return '\r' followed immediately by
					a linefeed '\n' as the line separator.
				No line separator is added to the end of the encoded output.
				All line separators or other characters not found in the base64 alphabet table are ignored in decoding operation.
		 */


		/*
			Java Base64 Example: Basic Encoding and Decoding
		 */

		// Getting encoder
		Base64.Encoder encoder = Base64.getEncoder();
		// Creating byte array
		byte[] byteArr = {1, 2};
		// encoding byte array
		byte[] byteArr2 = encoder.encode(byteArr);
		System.out.println("Encoded byte array: " + byteArr2);
		byte[] byteArr3 = new byte[5];               // Make sure it has enough size to store copied bytes
		int x = encoder.encode(byteArr, byteArr3);    // Returns number of bytes written
		System.out.println("Encoded byte array written to another array: " + byteArr3);
		System.out.println("Number of bytes written: " + x);

		// Encoding string
		String str = encoder.encodeToString("JavaTpoint".getBytes());
		System.out.println("Encoded string: " + str);
		// Getting decoder
		Base64.Decoder decoder = Base64.getDecoder();
		// Decoding string
		String dStr = new String(decoder.decode(str));
		System.out.println("Decoded string: " + dStr);

		/*
			Java Base64 Example: URL Encoding and Decoding
		 */
		// Getting encoder
		Base64.Encoder urlEncoder = Base64.getUrlEncoder();
		// Encoding URL
		String eUrlStr = urlEncoder.encodeToString("http://www.javatpoint.com/java-tutorial/".getBytes());
		System.out.println("Encoded URL: " + eUrlStr);
		// Getting decoder
		Base64.Decoder urlDecoder = Base64.getUrlDecoder();
		// Decoding URl
		String dUrlStr = new String(urlDecoder.decode(eUrlStr));
		System.out.println("Decoded URL: " + dUrlStr);


		/*
			Java Base64 Example: MIME Encoding and Decoding
		 */
		// Getting MIME encoder
		Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
		String message = "Hello, \nYou are informed regarding your inconsistency of work";
		String eMimeStr = mimeEncoder.encodeToString(message.getBytes());
		System.out.println("Encoded MIME message: " + eMimeStr);

		// Getting MIME decoder
		Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
		// Decoding MIME encoded message
		String dMimeStr = new String(mimeDecoder.decode(eMimeStr));
		System.out.println("Decoded message: " + dMimeStr);


	}
}
