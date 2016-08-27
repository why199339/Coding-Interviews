package q60;

import java.util.LinkedList;
import java.util.Queue;

public class Print {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(8);
		BinaryTreeNode node2 = new BinaryTreeNode(6);
		BinaryTreeNode node3 = new BinaryTreeNode(10);
		BinaryTreeNode node4 = new BinaryTreeNode(5);
		BinaryTreeNode node5 = new BinaryTreeNode(7);
		BinaryTreeNode node6 = new BinaryTreeNode(9);
		BinaryTreeNode node7 = new BinaryTreeNode(11);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		print(root);
	}

	public static void print(BinaryTreeNode root) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		if(root == null) {
			return;
		}
		queue.offer(root);
		int current = 1;
		int next = 0;
		while(!queue.isEmpty()) {
			if(current == 0) {
				current = next;
				next = 0;
				System.out.println();
				continue;
			}
			BinaryTreeNode node = queue.poll();
			System.out.print(node.value + "\t");
			current--;
			if(node.left != null) {
				queue.offer(node.left);
				next ++;
			}
			if(node.right != null) {
				queue.offer(node.right);
				next ++;
			}
		}
	}
}
