package q44;

import java.util.Arrays;

public class IsContinuous {

	public static void main(String[] args) {
		int[] numbers = { 0, 1, 3, 4, 5 };
		System.out.println(isContinuous(numbers));
	}

	public static boolean isContinuous(int[] numbers) {
		if(numbers == null || numbers.length < 1) {
			return false;
		}
		Arrays.sort(numbers);
		int countZero = 0;
		int countBlank = 0;
		int start = 0;
		while (numbers[start] == 0) {
			countZero++;
			start++;
		}
		int small = start;
		int big = small + 1;
		while(big < numbers.length) {
			if(numbers[big] == numbers[small]) {
				return false;
			}
			countBlank += numbers[big] = numbers[small] - 1;
			small = big;
			big++;
		}
		return countZero >= countBlank;
	}
}
