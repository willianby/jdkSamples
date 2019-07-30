package br.com.yamashita;

import static br.com.yamashita.sample.helper.Base64EncodeDecodeTests.encodeDecodeSamples;
import static br.com.yamashita.sample.helper.DefaultMethodsTests.defaultMethodsSamples;
import static br.com.yamashita.sample.helper.ForEachTests.forEachSamples;
import static br.com.yamashita.sample.helper.FunctionalInterfaceTests.functionalInterfaces;
import static br.com.yamashita.sample.helper.JavaCollectorsTests.collectorsSamples;
import static br.com.yamashita.sample.helper.LambdaTests.lambdaSamples;
import static br.com.yamashita.sample.helper.MethodReferenceTests.methodReferenceSamples;
import static br.com.yamashita.sample.helper.OptionalTests.optionalSamples;
import static br.com.yamashita.sample.helper.ParallelArraySortingTests.parallelArraySortingSamples;
import static br.com.yamashita.sample.helper.ParameterReflectionTests.parameterReflectionSamples;
import static br.com.yamashita.sample.helper.StreamSampleTests.streamSamples;
import static br.com.yamashita.sample.helper.StringJoinerTests.stringJoinerSamples;
import static br.com.yamashita.sample.helper.TypeAnnotationTests.typeAnnotationSamples;
import static br.com.yamashita.sample.helper.enhancedTypeInferenceTests.enhancedTypeInferenceSamples;

public class Java8Sample {

	static void testesJava8() {
		/*  Leitura recomendada
			https://blog.tecsinapse.com.br/stream-api-e-fun%C3%A7%C3%B5es-lambda-no-java-8-9941e8ae95d8
		 */
		lambdaSamples();
		methodReferenceSamples();
		functionalInterfaces();
		streamSamples();
		encodeDecodeSamples();
		defaultMethodsSamples();
		forEachSamples();
		collectorsSamples();
		stringJoinerSamples();
		optionalSamples();
		//How to execute javascript code inside jvm. - https://www.javatpoint.com/java-nashorn
		parallelArraySortingSamples();
		enhancedTypeInferenceSamples();
		parameterReflectionSamples();
		typeAnnotationSamples();
		/* Java 8 JDBC Improvements
			@see https://www.javatpoint.com/java-8-jdbc-improvements

			In Java 8, Java made two major changes in JDBC API.

			1) The JDBC-ODBC Bridge has been removed.
			Oracle does not support the JDBC-ODBC Bridge. Oracle recommends that you use JDBC drivers provided by the vendor of your database instead of the JDBC-ODBC Bridge.

			2) Added some new features in JDBC 4.2.
			Java JDBC 4.2 introduces the following features:

			Addition of REF_CURSOR support.
			Addition of java.sql.DriverAction Interface
			Addition of security check on deregisterDriver Method in DriverManager Class
			Addition of the java.sql.SQLType Interface
			Addition of the java.sql.JDBCType Enum
			Add Support for large update counts
			Changes to the existing interfaces
			Rowset 1.2: Lists the enhancements for JDBC RowSet.
		 */
	}
}
