package q43;

public class PrintProbability {

	public static void main(String[] args) {
		printProbability_1(3);
		System.out.println();
		printProbability_2(3);
	}

	public static void printProbability_2(int number) {
		if (number < 1) {
			return;
		}
		int[][] prop = new int[2][6 * number + 1];
		for (int i = 0; i < 6 * number + 1; i++) {
			prop[0][i] = 0;
			prop[1][i] = 0;
		}
		int flag = 0;
		for (int i = 1; i <= 6; i++) {
			prop[flag][i] = 1;
		}
		for (int k = 2; k <= number; k++) {
			for (int i = 0; i < k; i++) {
				prop[1 - flag][i] = 0;
			}
			for (int i = k; i <= 6 * k; i++) {
				prop[1 - flag][i] = 0;
				for (int j = 1; j <= i && j <= 6; j++) {
					prop[1 - flag][i] += prop[flag][i - j];
				}
			}
			flag = 1 - flag;
		}
		double total = Math.pow(6, number);
		for (int i = number; i <= 6 * number; i++) {
			double ratio = (double) prop[flag][i] / total;
			System.out.println(ratio);
		}
	}

	public static void printProbability_1(int number) {
		if (number < 1) {
			return;
		}
		int maxSum = 6 * number;
		int[] prop = new int[maxSum - number + 1];
		for (int i = number; i < maxSum; i++) {
			prop[i - number] = 0;
		}
		probability(number, prop);
		int total = (int) Math.pow(6, number);
		for (int i = number; i <= maxSum; i++) {
			double ratio = (double) prop[i - number] / total;
			System.out.println(ratio);
		}
	}

	private static void probability(int number, int[] prop) {
		for (int i = 1; i <= 6; i++) {
			probability(number, number, i, prop);
		}
	}

	private static void probability(int original, int current, int sum, int[] prop) {
		if (current == 1) {
			prop[sum - original]++;
		} else {
			for (int i = 1; i <= 6; i++) {
				probability(original, current - 1, i + sum, prop);
			}
		}
	}

}
