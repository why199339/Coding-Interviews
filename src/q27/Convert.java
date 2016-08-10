package q27;

public class Convert {

	public static void main(String[] args) {

	}

	public BinaryTreeNode convert(BinaryTreeNode root) {
		BinaryTreeNode lastNodeInList = null;
		convertNode(root, lastNodeInList);
		BinaryTreeNode headOfList = lastNodeInList;
		while(headOfList != null && headOfList.left != null) {
			headOfList = headOfList.left;
		}
		return headOfList;
	}

	private void convertNode(BinaryTreeNode node, BinaryTreeNode lastNodeInList) {
		if(node == null) {
			return;
		}
		BinaryTreeNode current = node;
		if(current.left != null) {
			convertNode(current.left, lastNodeInList);
		}
		current.left = lastNodeInList;
		if(lastNodeInList != null) {
			lastNodeInList.right = current;
		}
		lastNodeInList = current;
		if(current.right != null) {
			convertNode(current.right, lastNodeInList);
		}
	}
}
