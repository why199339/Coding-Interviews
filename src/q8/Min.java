package q8;

public class Min {

	public static void main(String[] args) throws Exception {
		int[] numbers = {1,1,1,0,1};
		System.out.println(min(numbers));
	}

	public static int min(int[] numbers) throws Exception {
		if(numbers == null || numbers.length == 0) {
			throw new Exception();
		}
		int low = 0;
		int high = numbers.length - 1;
		int mid = low;
		while(numbers[low] >= numbers[high]) {
			if(high - low == 1) {
				mid = high;
				break;
			}
			mid = (high + low) / 2;
			if(numbers[high] == numbers[low] && numbers[high] == numbers[mid]) {
				return minInOrder(numbers, low, high);
			}
			if(numbers[mid] > numbers[low]) {
				low = mid;
			} else if(numbers[mid] < numbers[high]) {
				high = mid;
			}
		}
		return numbers[mid];
	}
	
	private static int minInOrder(int[] numbers, int low, int high) {
		int result = numbers[low];
		for(int i=low+1; i<=high; i++) {
			if(numbers[i] < result) {
				result = numbers[i];
			}
		}
		return result;
	}
}
