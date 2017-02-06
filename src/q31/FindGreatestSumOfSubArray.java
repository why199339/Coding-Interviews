package q31;

public class FindGreatestSumOfSubArray {

	private static boolean isValidInput = true;

	public static void main(String[] args) {
		int[] data = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(findGreatestSumOfSubArra(data));
	}

	public static int findGreatestSumOfSubArra(int[] data) {
		if (data == null || data.length == 0) {
			isValidInput = false;
			return 0;
		}
		int maxSum = Integer.MIN_VALUE;
		int curSum = 0;
		for (int i = 0; i < data.length; i++) {
			if (curSum <= 0) {
				curSum = data[i];
			} else {
				curSum = curSum + data[i];
			}
			if (curSum > maxSum) {
				maxSum = curSum;
			}
		}
		return maxSum;
	}
}
