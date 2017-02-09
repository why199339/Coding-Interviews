package q51;

public class Duplicate {

	public static void main(String[] args) {
		int[] numbers = { 2, 3, 1, 0, 2, 5, 3 };
		System.out.println(duplicate_1(numbers));
		System.out.println(duplicate_2(numbers));
	}

	public static int duplicate_1(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return -1;
		}
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0 || numbers[i] >= numbers.length) {
				return -1;
			}
		}
		int i = 0;
		while (i < numbers.length) {
			if (numbers[i] == i) {
				i++;
				continue;
			}
			if (numbers[i] != i && numbers[numbers[i]] == numbers[i]) {
				return numbers[i];
			} else {
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}
		return -1;
	}

	public static boolean duplicate_2(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return false;
		}
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0 || numbers[i] >= numbers.length) {
				return false;
			}
		}
		for (int i=0; i<numbers.length; i++) {
			while(numbers[i] != i) {
				if(numbers[numbers[i]] == numbers[i]) {
					return true;
				}
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}
		return false;
	}
}
