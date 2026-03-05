package edu.iris.dmc.seed;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;


import edu.iris.dmc.io.SeedStringBuilder;

import java.util.stream.Stream;

public class SeedStringBuilderTest {

	@Test
	public void t() {
		BTime b=new BTime();
		b.setYear(1995);
		b.setDayOfYear(195);
		b.setHour(0);
		b.setMinute(0);
		b.setSecond(0);
		b.setTenthMilliSecond(0);

		SeedStringBuilder s = new SeedStringBuilder();
		s.append(b);
		
	}

	@ParameterizedTest
	@MethodSource("intLeftData")
	public void testLeftPad(int value, int length, char padChar, String expected) {
		SeedStringBuilder s = new SeedStringBuilder();
		s.leftPad(value, length, padChar);
		assertEquals(expected, s.toString());
	}

	@ParameterizedTest
	@MethodSource("stringLeftData")
	public void testLeftPad(String value, int length, char padChar, String expected) {
		SeedStringBuilder s = new SeedStringBuilder();
		s.leftPad(value, length, padChar);
		assertEquals(expected, s.toString());
	}

	static Stream<Arguments> intLeftData() {
		return Stream.of(
				Arguments.of(0, 4, '1', "1110"),
				Arguments.of(45, 4, '0', "0045"),
				Arguments.of(678, 4, '0', "0678"),
				Arguments.of(1234, 4, '0', "1234"),
				Arguments.of(12345, 4, '0', "12345"),
				Arguments.of(123456, 4, '0', "123456")
		);
	}

	static Stream<Arguments> stringLeftData() {
		return Stream.of(
				Arguments.of("0", 4, '1', "1110"),
				Arguments.of("45", 4, '0', "0045"),
				Arguments.of("678", 4, '0', "0678"),
				Arguments.of("1234", 4, '0', "1234"),
				Arguments.of("12345", 4, '0', "12345"),
				Arguments.of("123456", 4, '0', "123456")
				);
	}


	@ParameterizedTest
	@MethodSource("intRightData")
	public void testRightPad(int value, int length, char padChar, String expected) {
		SeedStringBuilder s = new SeedStringBuilder();
		s.rightPad(value, length, padChar);
		assertEquals(expected, s.toString());
	}

	@ParameterizedTest
	@MethodSource("stringRightData")
	public void testRightPad(String value, int length, char padChar, String expected) {
		SeedStringBuilder s = new SeedStringBuilder();
		s.rightPad(value, length, padChar);
		assertEquals(expected, s.toString());
	}

	static Stream<Arguments> intRightData() {
		return Stream.of(
				Arguments.of(0, 4, '1', "0111"),
				Arguments.of(45, 4, '0', "4500"),
				Arguments.of(678, 4, '0', "6780"),
				Arguments.of(1234, 4, '0', "1234"),
				Arguments.of(12345, 4, '0', "12345"),
				Arguments.of(123456, 4, '0', "123456")
		);
	}

	static Stream<Arguments> stringRightData() {
		String f = new String();
		return Stream.of(
				Arguments.of("0", 4, '1', "0111"),
				Arguments.of("45", 4, '0', "4500"),
				Arguments.of("678", 4, '0', "6780"),
				Arguments.of("1234", 4, '0', "1234"),
				Arguments.of("12345", 4, '0', "12345"),
				Arguments.of("123456", 4, '0', "123456")
		);
	}

}
