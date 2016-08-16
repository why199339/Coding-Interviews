package q42;

import javax.naming.spi.DirStateFactory.Result;

public class LeftRotateString {

	public static void main(String[] args) {
		char[] str = "abcdefg".toCharArray();
		char[] result = leftRotateString(str, 2);
		System.out.println(String.valueOf(result));
	}

	public static char[] leftRotateString(char[] str, int n) {
		if (str != null) {
			if (str.length > 0 && n > 0 && n < str.length) {
				int firstStart = 0;
				int firstEnd = n - 1;
				int secondStart = n;
				int secondEnd = str.length - 1;
				ReverseSentence.reverse(str, firstStart, firstEnd);
				ReverseSentence.reverse(str, secondStart, secondEnd);
				ReverseSentence.reverse(str, firstStart, secondEnd);
			}
		}
		return str;
	}

}
