package q30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class GetLeastNumbers {
	public static void main(String[] args) {
		int[] nums1 = { 4, 5, 1, 6, 2, 7, 3, 8 };
		int[] result = new int[4];
		getLeastNumbers_1(nums1, nums1.length, result, 4);
		System.out.println(Arrays.toString(result));
		int[] nums2 = { 4, 5, 1, 6, 2, 7, 3, 8 };
		result = new int[4];
		getLeastNumbers_2(nums2, nums2.length, result, 4);
		System.out.println(Arrays.toString(result));
	}

	public static void getLeastNumbers_2(int[] nums, int n, int[] result, int k) {
		if (nums == null || result == null || k > n || n <= 0 || k <= 0) {
			return;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (list.size() != k) {
				list.add(nums[i]);
			} else {
				Collections.sort(list);
				if (list.get(k - 1) > nums[i]) {
					list.remove(k-1);
					list.add(nums[i]);
				}
			}
		}
		for(int i =0; i<k; i++) {
			result[i] = list.get(i);
		}
	}

	public static void getLeastNumbers_1(int[] nums, int n, int[] result, int k) {
		if (nums == null || result == null || k > n || n <= 0 || k <= 0) {
			return;
		}
		int start = 0;
		int end = n - 1;
		int index = Partition(nums, n, start, end);
		while (index != k - 1) {
			if (index > k - 1) {
				end = index - 1;
				index = Partition(nums, n, start, end);
			} else {
				start = index + 1;
				index = Partition(nums, n, start, end);
			}
		}
		for (int i = 0; i < k; i++) {
			result[i] = nums[i];
		}
	}

	private static int Partition(int[] nums, int n, int start, int end) {
		int index = (int) (start + Math.random() * (end - start + 1));
		int small = start - 1;
		int temp = nums[index];
		nums[index] = nums[end];
		nums[end] = temp;
		for (int i = start; i < end; i++) {
			if (nums[i] < nums[end]) {
				small++;
				if (small != i) {
					temp = nums[small];
					nums[small] = nums[i];
					nums[i] = temp;
				}
			}
		}
		small++;
		temp = nums[small];
		nums[small] = nums[end];
		nums[end] = temp;
		return small;
	}
}
