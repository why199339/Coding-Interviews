package q37;

import java.util.Stack;

public class FindFirstCommonNode {

	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(3);
		ListNode head4 = new ListNode(6);
		ListNode head5 = new ListNode(7);
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		node1.next = node2;
		node2.next = head4;
		ListNode result1 = findFirstCommonNode_1(head1, node1);
		while(result1 != null) {
			System.out.print(result1.key + " ");
			result1 = result1.next;
		}
		System.out.println();
		ListNode result2 = findFirstCommonNode_1(head1, node1);
		while(result2 != null) {
			System.out.print(result2.key + " ");
			result2 = result2.next;
		}
	}

	public static ListNode findFirstCommonNode_2(ListNode head1, ListNode head2) {
		int length1 = 0;
		int length2 = 0;
		ListNode node1 = head1;
		ListNode node2 = head2;
		while(node1 != null) {
			length1++;
			node1 = node1.next;
		}
		while(node2 != null) {
			length2++;
			node2 = node2.next;
		}
		int lengthDiff = length1 - length2;
		ListNode longNode = head1;
		ListNode shortNode = head2;
		if(length2 > length1) {
			longNode = head2;
			shortNode = head1;
			lengthDiff = length2 - length1;
		}
		for (int i=0; i<lengthDiff; i++) {
			longNode = longNode.next;
		}
		while(longNode != null && shortNode != null && longNode.key != shortNode.key) {
			longNode = longNode.next;
			shortNode = shortNode.next;
		}
		ListNode commonNode = longNode;
		return commonNode;
	}
	
	public static ListNode findFirstCommonNode_1(ListNode head1, ListNode head2) {
		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();
		ListNode node1 = head1;
		ListNode node2 = head2;
		while(node1 != null) {
			stack1.push(node1);
			node1 = node1.next;
		}
		while(node2 != null) {
			stack2.push(node2);
			node2 = node2.next;
		}
		ListNode pre = null;
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			if(stack1.peek() != stack2.peek()) {
				return pre;
			}
			pre = stack1.pop();
			stack2.pop();
		}
		return null;
	}
}
