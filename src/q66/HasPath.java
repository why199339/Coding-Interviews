package q66;

public class HasPath {

	public static void main(String[] args) {
		char[] matrix = "abcesfcsadee".toCharArray();
		char[] str = "abcb".toCharArray();
		int rows = 3;
		int cols = 4;
		System.out.println(hasPath(matrix, rows, cols, str));
		str = "bcced".toCharArray();
		System.out.println(hasPath(matrix, rows, cols, str));
	}

	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || rows < 1 || cols < 1 || str == null) {
			return false;
		}
		boolean[] visited = new boolean[rows * cols];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		int pathLength = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (hasPathCore(matrix, rows, cols, i, j, str, pathLength, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength,
			boolean[] visited) {
		if (pathLength == str.length) {
			return true;
		}
		boolean hasPath = false;
		if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col]
				&& matrix[row * cols + col] == str[pathLength]) {
			pathLength++;
			visited[row * cols + col] = true;
			hasPath = hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
					|| hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited);
			if (!hasPath) {
				pathLength--;
				visited[row * cols + col] = false;
			}
		}
		return hasPath;
	}
}
