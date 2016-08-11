package q29;

public class MoreThanHalfNum {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		System.out.println(moreThanHalfNum_1(nums, nums.length));
		System.out.println(moreThanHalfNum_2(nums, nums.length));
	}

	public static int moreThanHalfNum_2(int[] nums, int length) {
		if (nums == null || length < 0) {
			return 0;
		}
		int middle = length >> 1;
		int start = 0;
		int end = length - 1;
		int index = Partition(nums, length, start, end);
		while (index != middle) {
			if (index > middle) {
				end = index - 1;
				index = Partition(nums, length, start, end);
			} else {
				start = index + 1;
				index = Partition(nums, length, start, end);
			}
		}
		int result = nums[middle];
		return result;
	}

	private static int Partition(int[] nums, int length, int start, int end) {
		if (nums == null || length <= 0 || start < 0 || end >= length) {
			System.out.println("Exception");
		}
		int index = (int) (start + Math.random() * (end - start + 1));
		int temp = nums[index];
		nums[index] = nums[end];
		nums[end] = temp;
		int small = start - 1;
		for (index = start; index < end; index++) {
			if (nums[index] < nums[end]) {
				small++;
				if (small != index) {
					temp = nums[index];
					nums[index] = nums[small];
					nums[small] = temp;
				}
			}
		}
		small++;
		temp = nums[small];
		nums[small] = nums[end];
		nums[end] = temp;
		return small;
	}

	public static int moreThanHalfNum_1(int[] nums, int length) {
		if (nums == null || length < 0) {
			return 0;
		}
		int result = nums[0];
		int times = 1;
		for (int i = 1; i < length; i++) {
			if (times == 0) {
				times = 1;
				result = nums[i];
			} else if (nums[i] == result) {
				times++;
			} else {
				times--;
			}
		}
		return result;
	}
}
