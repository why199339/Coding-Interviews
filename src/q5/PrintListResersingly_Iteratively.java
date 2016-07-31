package q5;

import java.util.Stack;

public class PrintListResersingly_Iteratively {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		printListResersingly_Iteratively(head);
	}

	public static void printListResersingly_Iteratively(ListNode head) {
		Stack<ListNode> st = new Stack<>();
		ListNode node = head;
		while(node != null) {
			st.push(node);
			node = node.next;
		}
		while(!st.isEmpty()) {
			System.out.print(st.pop().val + " ");
		}
	}
}
