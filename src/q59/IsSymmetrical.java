package q59;

public class IsSymmetrical {

	public static void main(String[] args) {
		
	}

	public static boolean isSymmetrical(BinaryTreeNode root) {
		return isSymmetrical(root, root);
	}
	
	private static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
		if(root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		} else if (root1.value != root2.value) {
			return false;
		}
		return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
	}
}
