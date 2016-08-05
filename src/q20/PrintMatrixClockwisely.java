package q20;

public class PrintMatrixClockwisely {

	public static void main(String[] args) {
		int[][] numbers = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrixClockwisely(numbers, 4, 4);
	}

	public static void printMatrixClockwisely(int[][] numbers, int columns, int rows) {
		if (numbers == null || columns <= 0 || rows <= 0) {
			return;
		}
		int start = 0;
		while (rows > start * 2 && columns > start * 2) {
			printMatrixInCircle(numbers, columns, rows, start);
			start++;
		}
	}

	private static void printMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
		int endX = columns - 1 -start;
		int endY = rows - 1 - start;
		for(int i=start; i<= endX; i++) {
			System.out.print(numbers[start][i] + " ");
		}
		if(endY > start) {
			for(int i=start+1; i<= endY; i++) {
				System.out.print(numbers[i][endX] + " ");
			}
		}
		if(endX > start && endY > start) {
			for(int i=endX -1; i >= start; i--) {
				System.out.print(numbers[endY][i] + " ");
			}
		}
		if(endX > start && endY-1 > start) {
			for(int i=endY-1; i>=start + 1; i--) {
				System.out.print(numbers[i][start] + " ");
			}
		}
	}
}
