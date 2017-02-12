package q63;

import q63.BinaryTreeNode;

public class KthNode {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(5);
		BinaryTreeNode node1 = new BinaryTreeNode(3);
		BinaryTreeNode node2= new BinaryTreeNode(7);
		BinaryTreeNode node3 = new BinaryTreeNode(2);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(6);
		BinaryTreeNode node6 = new BinaryTreeNode(8);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		BinaryTreeNode node = kthNode(root, 3);
		System.out.println(node.value);
	}

	public static BinaryTreeNode kthNode(BinaryTreeNode root, int k) {
		if (root == null || k == 0) {
			return null;
		}
		int[] temp = {k};
		return kthNodeCore(root, temp);
	}

	private static BinaryTreeNode kthNodeCore(BinaryTreeNode root, int[] k) {
		BinaryTreeNode target = null;
		if(root.left != null) {
			target = kthNodeCore(root.left, k);
		}
		if(target == null) {
			if (k[0] == 1) {
				target = root;
			}
			k[0]--;
		}
		if(target == null && root.right != null) {
			target = kthNodeCore(root.right, k);
		}
		return target;
	}
}
