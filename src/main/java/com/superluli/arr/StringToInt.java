package com.superluli.arr;

/*
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringToInt {

	public static void main(String[] args) {
		System.err.println(myAtoi(null));
		System.err.println(myAtoi(""));
		System.err.println(myAtoi("av"));
		System.err.println(myAtoi("+0"));
		System.err.println(myAtoi("+0123"));
		System.err.println(myAtoi("+123"));
		System.err.println(myAtoi("123"));
		System.err.println(myAtoi("-123"));
		System.err.println(myAtoi("-123cdsxc"));
		System.err.println(myAtoi("2147483647"));
		System.err.println(myAtoi("2147483648"));
		System.err.println(myAtoi("-2147483647"));
		System.err.println(myAtoi("-2147483648"));
		System.err.println(myAtoi("-2147483649"));
	}

	public static int myAtoi(String str) {
		if (str == null || str.isEmpty())
			return 0;

		boolean isMunus = false;
		double d = 0;
		boolean started = false;
	
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				started = true;
				d = d * 10 + c - '0';
				if (!isMunus && d >= Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				if (isMunus && d >= -(double) Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			} else if (c == '+' || c == '-') {
				if(started) return 0;
				started = true;
				isMunus = c == '-';
			} else if (c == ' ' && !started){
				continue;
			} else break;
		}
		return isMunus ? -(int) d : (int) d;
	}
}
