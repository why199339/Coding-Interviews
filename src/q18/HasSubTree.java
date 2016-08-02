package q18;

public class HasSubTree {

	public static void main(String[] args) {
		BinaryTreeNode root1 = new BinaryTreeNode(8);
		BinaryTreeNode root2 = new BinaryTreeNode(8);
		root1.left = new BinaryTreeNode(8);
		root1.right = new BinaryTreeNode(7);
		root1.left.left = new BinaryTreeNode(9);
		root1.left.right = new BinaryTreeNode(2);
		root1.left.right.left = new BinaryTreeNode(4);
		root1.left.right.right = new BinaryTreeNode(7);
		root2.left = new BinaryTreeNode(9);
		root2.right = new BinaryTreeNode(2);
		System.out.println(hasSubTree(root1, root2));
	}

	public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
		boolean result = false;
		if(root1 != null && root2 != null) {
			if(root1.value == root2.value) {
				result = doesTree1HasTree2(root1,root2);
			}
			if(!result) {
				result = hasSubTree(root1.left, root2);
			}
			if(!result) {
				result = hasSubTree(root1.right, root2);
			}
		}
		return result;
	}

	private static boolean doesTree1HasTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
		if(root2 == null) {
			return true;
		}
		if(root1 == null) {
			return false;
		}
		if(root1.value != root2.value) {
			return false;
		}
		return doesTree1HasTree2(root1.left, root2.left) &&doesTree1HasTree2(root1.right, root2.right);
	}
}
