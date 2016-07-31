package q8;

public class QuickSort {

	public static void main(String[] args) {
		int[] data = { 2, 5, 1, 8, 2, 0 };
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
		int length = data.length;
		quickSort(data, length, 0, length - 1);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

	public static int partition(int[] data, int length, int start, int end) {
		if (data == null || length <= 0 || start < 0 || end >= length) {
			System.out.println("Exception");
		}
		int index = (int) (start + Math.random() * (end - start + 1));
		int temp = data[index];
		data[index] = data[end];
		data[end] = temp;
		int small = start - 1;
		for (index = start; index < end; index++) {
			if (data[index] < data[end]) {
				small++;
				if (small != index) {
					temp = data[index];
					data[index] = data[small];
					data[small] = temp;
				}
			}
		}
		small++;
		temp = data[small];
		data[small] = data[end];
		data[end] = temp;
		return small;
	}

	public static void quickSort(int[] data, int length, int start, int end) {
		if (start == end) {
			return;
		}
		int index = partition(data, length, start, end);
		if (index > start) {
			quickSort(data, length, start, index - 1);
		}
		if (index < end) {
			quickSort(data, length, index + 1, end);
		}
	}
}
