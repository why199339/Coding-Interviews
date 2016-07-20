package q3;

public class Find_In_Partially_Sorted_Matrix {

	public static void main(String[] args) {

		int[][] matrix = {{1,2,8,9},{2,4,9,2},{4,7,10,13},{6,8,11,15}};
		int number = 3;
		int rows = 4;
		int columns = 4;
		System.out.println(find(matrix, rows, columns, number));
	}

	public static boolean find(int[][] matrix, int rows, int columns, int number) {
		boolean found = false;
		if(matrix.length != 0 && rows >0 && columns > 0) {
			int row = 0;
			int column = columns - 1;
			while(row < rows && column >= 0) {
				if(matrix[row][column] == number) {
					found = true;
					break;
				}
				else if(matrix[row][column] > number) {
					column--;
				} else {
					row++;
				}
			}
		}
		return found;
	}
}
