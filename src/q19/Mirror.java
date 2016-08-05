package q19;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Mirror {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(4);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(7);
		root.left.left = new BinaryTreeNode(1);
		root.left.right = new BinaryTreeNode(3);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(9);
		System.out.println(root + "," + root.left + "," + root.right + "," + root.left.left + "," + root.left.right + "," + root.right.left
				 + "," + root.right.right);
		mirror_iterative(root);
		System.out.println(root + "," + root.left + "," + root.right + "," + root.left.left + "," + root.left.right + "," + root.right.left
				 + "," + root.right.right);
	}

	public static void mirror_recursively(BinaryTreeNode node) {
		if(node == null) {
			return;
		}
		if(node.left == null && node.right == null) {
			return;
		}
		BinaryTreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		if(node.left != null) {
			mirror_recursively(node.left);
		}
		if(node.right != null) {
			mirror_recursively(node.right);
		}
	}
	
	public static void mirror_iterative(BinaryTreeNode node) {
		if(node == null) {
			return ;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			BinaryTreeNode current = queue.poll();
			BinaryTreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;
			if(current.left != null) {
				queue.add(current.left);
			}
			if(current.right != null) {
				queue.add(current.right);
			}
		}
	}
}
