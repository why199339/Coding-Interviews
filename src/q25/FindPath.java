package q25;

import java.util.ArrayList;

public class FindPath {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(5);
		root.left = new BinaryTreeNode(4);
		root.right = new BinaryTreeNode(8);
		root.left.left = new BinaryTreeNode(11);
		root.left.left.left = new BinaryTreeNode(7);
		root.left.left.right = new BinaryTreeNode(2);
		root.right.left = new BinaryTreeNode(13);
		root.right.right = new BinaryTreeNode(4);
		root.right.right.right = new BinaryTreeNode(5);
		findPath(root, 22);
	}

	public static void findPath(BinaryTreeNode root, int sum) {
		if (root == null) {
			return;
		}
		ArrayList<Integer> list = new ArrayList<>();
		int currentSum = 0;
		findPath(root, sum, list, currentSum);
	}

	private static void findPath(BinaryTreeNode root, int sum, ArrayList<Integer> list, int currentSum) {
		currentSum += root.value;
		list.add(root.value);
		boolean isLeaf = root.left == null && root.right == null;
		if (isLeaf && currentSum == sum) {
			System.out.print("The Path is : ");
			for (Integer num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		if (root.left != null) {
			findPath(root.left, sum, list, currentSum);
		}
		if (root.right != null) {
			findPath(root.right, sum, list, currentSum);
		}
		list.remove(list.size() - 1);
	}
}
