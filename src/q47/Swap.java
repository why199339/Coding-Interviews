package q47;

import java.util.Arrays;

public class Swap {

	public static void main(String[] args) {
		int[] num = {2,3};
		int[] result = swap_1(num);
		System.out.println(Arrays.toString(result));
		result = swap_2(num);
		System.out.println(Arrays.toString(result));
	}

	public static int[] swap_1(int[] num) {
		int a = num[0];
		int b = num[1];
		a = a + b;
		b = a - b;
		a = a - b;
		return new int[]{a,b};
	}
	
	public static int[] swap_2(int[] num) {
		int a = num[0];
		int b = num[1];
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		return new int[]{a,b};
	}
}
