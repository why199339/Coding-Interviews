package q41;

public class FindNumbersWithSum {

	public static void main(String[] args) {
		int[] data = {1, 2, 4, 7, 11, 15};
		System.out.println(findNumbersWithSum(data, 15));
	}

	public static boolean findNumbersWithSum(int[] data, int sum) { 
		boolean found = false;
		if(data == null || data.length == 0) {
			return found;
		}
		int start = 0;
		int end = data.length - 1;
		while(start < end) {
			if((data[start] + data[end]) == sum) {
				System.out.println(data[start] + " " + data[end]);
				found = true;
				return found;
			}
			if((data[start] + data[end]) < sum) {
				start = start + 1;
			} else {
				end = end - 1;
			}
		}
		return found;
	}
}
