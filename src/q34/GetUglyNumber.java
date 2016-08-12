package q34;

public class GetUglyNumber {

	public static void main(String[] args) {
		System.out.println(getUglyNumber_bad(1500));
		System.out.println(getUglyNumber_good(1500));
	}

	public static int getUglyNumber_good(int index) {
		if (index <= 0) {
			return 0;
		}
		int[] uglyNumbers = new int[index];
		uglyNumbers[0] = 1;
		int nextUglyIndex = 1;
		int[] m2 = uglyNumbers;
		int[] m3 = uglyNumbers;
		int[] m5 = uglyNumbers;
		int i = 0;
		int j = 0;
		int k = 0;
		while (nextUglyIndex < index) {
			int min = nextMin(m2[i] * 2, m3[j] * 3, m5[k] * 5);
			uglyNumbers[nextUglyIndex] = min;
			while(m2[i] * 2 <= uglyNumbers[nextUglyIndex]) {
				i ++;
			}
			while(m3[j] * 3 <= uglyNumbers[nextUglyIndex]) {
				j ++;
			}
			while(m5[k] * 5 <= uglyNumbers[nextUglyIndex]) {
				k ++;
			}
			nextUglyIndex ++;
		}
		return uglyNumbers[nextUglyIndex - 1];
	}

	private static int nextMin(int num1, int num2, int num3) {
		int temp = Math.min(num1, num2);
		int min = Math.min(temp, num3);
		return min;
	}

	public static int getUglyNumber_bad(int index) {
		if (index < 0) {
			return 0;
		}
		int count = 0;
		int number = 0;
		while (count != index) {
			number++;
			if (isUgly(number)) {
				count++;
			}
		}
		return number;
	}

	private static boolean isUgly(int number) {
		while (number % 2 == 0) {
			number = number / 2;
		}
		while (number % 3 == 0) {
			number = number / 3;
		}
		while (number % 5 == 0) {
			number = number / 5;
		}
		return number == 1;
	}
}
