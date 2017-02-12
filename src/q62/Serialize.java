package q62;

import java.util.ArrayList;

public class Serialize {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode node1 = new BinaryTreeNode(2);
		BinaryTreeNode node2= new BinaryTreeNode(3);
		BinaryTreeNode node3 = new BinaryTreeNode(4);
		BinaryTreeNode node4 = new BinaryTreeNode(5);
		BinaryTreeNode node5 = new BinaryTreeNode(6);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		ArrayList<String> list  = new ArrayList<>();
		serizliaze(root, list);
		System.out.println(list);
		root = new BinaryTreeNode();
		node1 = new BinaryTreeNode();
		node2= new BinaryTreeNode();
		node3 = new BinaryTreeNode();
		node4 = new BinaryTreeNode();
		node5 = new BinaryTreeNode();
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		deserialize(root, list);
		System.out.println(root.value);
	}

	public static void serizliaze(BinaryTreeNode root, ArrayList<String> list) {
		if (root == null) {
			list.add("$");
			return ;
		}
		list.add(String.valueOf(root.value));
		serizliaze(root.left, list);
		serizliaze(root.right, list);
	}
	
	public static void deserialize(BinaryTreeNode root, ArrayList<String> list) {
		if(list.isEmpty() || root == null) {
			return;
		}
		String number = list.remove(0);
		if (number == "$") {
			root = null;
		} else {
			root.value = Integer.valueOf(number);
			root.left = null;
			root.right = null;
		}
		deserialize(root.left, list);
		deserialize(root.right, list);
	}
}
