package q33;

import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {

	private static int maxNumberLength = 10;
	private char[] strCombine1 = new char[maxNumberLength * 2];
	private char[] strCombine2 = new char[maxNumberLength * 2];

	public static void main(String[] args) {
		int[] number = { 3, 32, 321 };
		printMinNumber(number);
	}

	public static void printMinNumber(int[] number) {
		if (number == null || number.length <= 0) {
			return;
		}
		String[] strNumbers = new String[number.length];
		for (int i = 0; i < number.length; i++) {
			strNumbers[i] = String.valueOf(number[i]);
		}
		Arrays.sort(strNumbers, 0, strNumbers.length, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String combine1 = s1 + s2;
				String combine2 = s2 + s1;
				return combine1.compareTo(combine2);
			}
		});
		for (int i = 0; i < number.length; i++) {
			System.out.print(strNumbers[i]);
		}
	}
}
