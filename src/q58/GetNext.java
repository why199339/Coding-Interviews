package q58;

public class GetNext {

	public static void main(String[] args) {

	}

	public static TreeNode getNext(TreeNode node) {
		if(node == null) {
			return null;
		}
		TreeNode node1 = node;
		if (node1.right != null) {
			node1 = node1.right;
			while(node1.left != null) {
				node1 = node1.left;
			}
			return node1;
		}
		else if (node.parent != null) {
			if(node.parent.left == node) {
				return node.parent;
			} else {
				TreeNode current = node;
				TreeNode parrent = node.parent;
				while(parrent != null && parrent.right == current) {
					node = parrent;
					parrent = node.parent;
				}
				return parrent;
			}
		}
		return null;
	}
}
