package q50;

import java.util.List;
import java.util.Stack;

public class GetLastCommonParent {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		root.children = new TreeNode[] { node2, node3 };
		node2.children = new TreeNode[] { node4, node5 };
		node4.children = new TreeNode[] { node6, node7 };
		node5.children = new TreeNode[] { node8, node9, node10 };
		TreeNode commonNode = getLastCommonParent(root, node2, node7);
		System.out.println(commonNode.val);
	}

	public static TreeNode getLastCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null || node1 == null || node2 == null) {
			return null;
		}
		Stack<TreeNode> path1 = new Stack<>();
		getNodePath(root, node1, path1);
		Stack<TreeNode> path2 = new Stack<>();
		getNodePath(root, node2, path2);
		return getLastCommonNode(path1, path2);
	}

	private static boolean getNodePath(TreeNode root, TreeNode node, Stack<TreeNode> path) {
		if (root == node) {
			path.push(root);
			return true;
		}
		path.push(root);
		boolean found = false;
		int i = 0;
		while (!found && root.children != null && i < root.children.length) {
			found = getNodePath(root.children[i], node, path);
			i++;
		}
		if (!found) {
			path.pop();
		}
		return found;
	}

	private static TreeNode getLastCommonNode(Stack<TreeNode> path1, Stack<TreeNode> path2) {
		TreeNode t1 = path1.pop();
		TreeNode t2 = path2.pop();
		while (!path1.isEmpty() && !path2.isEmpty()) {
			if (t1.val == t2.val) {
				return t1;
			}
			t1 = path1.pop();
			t2 = path2.pop();
		}
		return t1;
	}
}
