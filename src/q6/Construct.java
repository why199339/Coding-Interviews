package q6;

public class Construct {

	public static void main(String[] args) {
		int[] preorder = {1,2,4,7,3,5,6,8};
		int[] inorder = {4,7,2,1,5,3,8,6};
		int length = 8;
		BinaryTreeNode node = contruct(preorder, inorder, length);
		traverse(node);
	}

	public static BinaryTreeNode contruct(int[] preorder, int[] inorder, int length) {
		if (preorder == null || inorder == null || length <= 0) {
			return null;
		}
		return constructCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private static BinaryTreeNode constructCore(int[] preorder, int startPreorder, int endPreorder, int[] inorder,
			int startInorder, int endInorder) {
		int rootValue = preorder[startPreorder];
		BinaryTreeNode root = new BinaryTreeNode();
		root.value = rootValue;
		root.left = root.right = null;
//		System.out.println("root = " + root.value);
		if (startPreorder == endPreorder) {
			if (startInorder == endInorder && preorder[startPreorder] == inorder[startInorder]) {
				return root;
			} else {
				System.out.println("Invalid input1");
			}
		}
		int rootInorder = startInorder;
		while (rootInorder <= endInorder && inorder[rootInorder] != rootValue) {
			rootInorder++;
		}
		if (rootInorder == endInorder && inorder[rootInorder] != rootValue) {
			System.out.println("Invalid input2");
		}
		int leftLength = rootInorder - startInorder;
		int leftPreorderEnd = startPreorder + leftLength;
		if (leftLength > 0) {
			root.left = constructCore(preorder, startPreorder + 1, leftPreorderEnd, inorder, startInorder, rootInorder - 1);
		}
		if(leftLength < endPreorder - startPreorder) {
			root.right = constructCore(preorder, leftPreorderEnd + 1, endPreorder, inorder, rootInorder + 1, endInorder);
		}
		return root;
	}
	
	private static void traverse(BinaryTreeNode node) {
		if(node == null) {
			return ;
		}
		traverse(node.left);
		traverse(node.right);
		System.out.print(node.value + " ");
	}
}
