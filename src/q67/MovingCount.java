package q67;

public class MovingCount {

	public static void main(String[] args) {

	}

	public static int movingCount(int threshold, int rows, int cols) {
		boolean[] visited = new boolean[rows * cols];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
		return count;
	}

	private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		int count = 0;
		if (check(threshold, rows, cols, row, col, visited)) {
			visited[row * cols + col] = true;
			count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
					+ movingCountCore(threshold, rows, cols, row, col + 1, visited)
					+ movingCountCore(threshold, rows, cols, row - 1, col, visited)
					+ movingCountCore(threshold, rows, cols, row, col - 1, visited);
		}
		return count;
	}

	private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
		if(row > 0 && col > 0 && row < rows && col < cols && !visited[row * cols + col] && getDigitSum(row) + getDigitSum(col) <= threshold) {
			return true;
		}
		return false;
	}

	private static int getDigitSum(int num) {
		int sum = 0;
		while(num >= 0) {
			sum += num % 10;
			num = num / 10;
		}
		return sum;
	}
}
