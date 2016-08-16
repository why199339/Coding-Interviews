package q40;

import java.util.ArrayList;

import q37.FindFirstCommonNode;

public class FindNumsAppearOnce {

	public static void main(String[] args) {
		int[] data = { 2, 4, 3, 6, 3, 2, 5, 5 };
		findNumsAppearOnce(data);
	}

	public static void findNumsAppearOnce(int[] data) {
		if (data == null || data.length == 0) {
			return;
		}
		int result = 0;
		for (int i = 0; i < data.length; i++) {
			result = result ^ data[i];
		}
		int indexOf1 = findFirstBitIs1(result);
		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < data.length; i++) {
			if (isBit1(data[i], indexOf1)) {
				num1 = data[i] ^ num1;
			} else {
				num2 = data[i] ^ num2;
			}
		}
		System.out.println(num1 + "," + num2);
	}

	private static boolean isBit1(int num, int indexBit) {
		num = num >> indexBit;
		return (num & 1) == 1;
	}

	private static int findFirstBitIs1(int num) {
		int indexBit = 0;
		while ((num & 1) == 0) {
			num = num >> 1;
			indexBit++;
		}
		return indexBit;
	}
}
