package q61;

import java.util.Stack;

public class Print {

	public static void main(String[] args) {
		BinaryTreeNode node1 = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		print(node1);
	}

	public static void print(BinaryTreeNode root) {
		Stack<BinaryTreeNode> current = new Stack<>();
		Stack<BinaryTreeNode> next = new Stack<>();
		current.push(root);
		boolean isOdd = true;
		while (!current.isEmpty() || !next.isEmpty()) {
			BinaryTreeNode node = current.pop();
			if(node != null)
				System.out.print(node.value + " ");
			else
				System.out.println("null");
			if (isOdd) {
				if(node.left != null) {
					next.push(node.left);
				}
				if(node.right != null) {
					next.push(node.right);
				}
			}
			if(!isOdd) {
				if(node.right != null) {
					next.push(node.right);
				}
				if(node.left != null) {
					next.push(node.left);
				}
			}
			if(current.isEmpty()) {
				System.out.println();
				Stack<BinaryTreeNode> temp = current;
				current = next;
				next = temp;
				isOdd = !isOdd;
			}
		}
	}
}
