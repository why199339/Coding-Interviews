package q24;

public class VerifySequenceOfBST {

	public static void main(String[] args) {
		int[] array1 = {5,7,6,9,11,10,8};
		int[] array2 = {7,4,6,5};
		System.out.println(verifySequenceOfBST(array1, 0, array1.length-1));
		System.out.println(verifySequenceOfBST(array2, 0, array2.length-1));
	}

	public static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
		if (sequence == null) {
			return false;
		}
		int root = sequence[end];
		int i = start;
		while (i < end) {
			if (sequence[i] > root) {
				break;
			}
			i++;
		}
		int j = i;
		while (j < end) {
			if (sequence[j] < root) {
				return false;
			}
			j++;
		}
		boolean left = true;
		if (i > start) {
			left = verifySequenceOfBST(sequence, start, i - 1);
		}
		boolean right = true;
		if (i < end) {
			right = verifySequenceOfBST(sequence, start + i, end - 1);
		}
		return left && right;
	}
}
