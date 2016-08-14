package q39;

public class IsBalanced {

	public static void main(String[] args) {
		BinaryTreeNode node1 = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node7;
		node3.right = node6;
		System.out.println(isBalanced_bad(node1));
		System.out.println(isBalanced_good(node1));
	}

	public static boolean isBalanced_good(BinaryTreeNode root) {
		return dfsHeight(root) != -1;
	}

	private static int dfsHeight(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = dfsHeight(root.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = dfsHeight(root.right);
		if (rightHeight == -1)
			return -1;
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static boolean isBalanced_bad(BinaryTreeNode root) {
		if (root == null) {
			return true;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		if (left - right > 1 || right - left > 1) {
			return false;
		}
		return isBalanced_bad(root.left) && isBalanced_bad(root.right);
	}

	private static int depth(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(depth(root.left), depth(root.right));
	}
}
