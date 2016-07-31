package q9;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibonacci_Recursive(10));
		System.out.println(fibonacci_nice(10));
	}

	public static int fibonacci_Recursive(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci_Recursive(n - 1) + fibonacci_Recursive(n - 2);
	}

	public static int fibonacci_nice(int n) {
		int[] fab = { 0, 1 };
		if (n < 2) {
			return fab[n];
		}
		int fibMinusOne = 1;
		int fibMinusTwo = 0;
		int fibN = 0;
		for (int i = 2; i <= n; i++) {
			fibN = fibMinusOne + fibMinusTwo;
			fibMinusTwo = fibMinusOne;
			fibMinusOne = fibN;
		}
		return fibN;
	}
	
	
}
