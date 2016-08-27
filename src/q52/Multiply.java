package q52;
import java.util.Arrays;

public class Multiply {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4};
		int[] arr2 = new int[arr1.length];
		multiply(arr1,arr2);
		System.out.println(Arrays.toString(arr2));
	}

	public static void multiply(int[] arr1, int[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		if (len1 == len2 && len2 > 1) {
			arr2[0] = 1;
			for (int i = 1; i < len1; i++) {
				arr2[i] = arr2[i - 1] * arr1[i - 1];
			}
			int temp = 1;
			for (int i = len1 - 2; i >= 0; i--) {
				temp = temp * arr1[i + 1];
				arr2[i] = arr2[i] * temp;
			}
		}
	}
}
