package q12;

public class Print1ToMaxOfNDigits {

	public static void main(String[] args) {
		print1ToMaxOfNDigits_1(2);
		System.out.println();
		print1ToMaxOfNDigits_2(2);
		System.out.println();
		print1ToMaxOfNDigits_3(2);
	}

	public static void print1ToMaxOfNDigits_1(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum * 10 + 9;
		}
		for (int i = 1; i <= sum; i++) {
			System.out.print(i + " ");
		}
	}

	public static void print1ToMaxOfNDigits_2(int n) {
		if (n <= 0) {
			return;
		}
		char[] number = new char[n];
		for(int i=0; i<n; i++) {
			number[i] = '0';
		}
		while (!increment(number)) {
			printNumber(number);
		}
	}

	private static boolean increment(char[] number) {
		boolean isOverflow = false;
		int nTakeOver = 0;
		int nLength = number.length;
		for (int i = nLength - 1; i >= 0; i--) {
			int nSum = number[i] - '0' + nTakeOver;
			if (i == nLength - 1) {
				nSum++;
			}
			if (nSum >= 10) {
				if (i == 0) {
					isOverflow = true;
				} else {
					nSum -= 10;
					nTakeOver = 1;
					number[i] = (char) ('0' + nSum);
				}
			} else {
				number[i] = (char) ('0' + nSum);
				break;
			}
		}
		return isOverflow;
	}

	private static void printNumber(char[] number) {
		boolean isBeginning0 = true;
		int nLength = number.length;
		for (int i = 0; i < nLength; i++) {
			if (isBeginning0 && number[i] != '0') {
				isBeginning0 = false;
			}
			if (!isBeginning0) {
				System.out.print(number[i]);
			}
		}
		System.out.print(" ");
	}

	public static void print1ToMaxOfNDigits_3(int n) {
		if (n <= 0) {
			return;
		}
		char[] number = new char[n];
		for(int i=0; i<n; i++) {
			number[i] = '0';
		}
		for (int i = 0; i < 10; i++) {
			number[0] = (char) (i + '0');
			print1ToMaxOfNDigitsRecursively(number, n, 0);
		}
	}

	private static void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
		if (index == length - 1) {
			printNumber(number);
			return;
		}
		for (int i = 0; i < 10; i++) {
			number[index + 1] = (char)('0' + i);
			print1ToMaxOfNDigitsRecursively(number, length, index + 1);
		}
	}
}
