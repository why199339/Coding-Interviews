package q23;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintFromTopToBottom {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.left = new BinaryTreeNode(6);
		root.right = new BinaryTreeNode(10);
		root.left.left = new BinaryTreeNode(5);
		root.left.right = new BinaryTreeNode(7);
		root.right.left = new BinaryTreeNode(9);
		root.right.right = new BinaryTreeNode(11);
		printFromTopToBottom(root);
	}

	public static void printFromTopToBottom(BinaryTreeNode root) {
		if(root== null) {
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode node = queue.poll();
			System.out.print(node.value + " ");
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
		}
	}
}
