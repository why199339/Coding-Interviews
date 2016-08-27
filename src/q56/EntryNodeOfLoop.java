package q56;

public class EntryNodeOfLoop {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(-4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		ListNode node = entryNodeOfLoop(node1);
		if (node != null) {
			System.out.println(node.val);
		}
	}

	public static ListNode entryNodeOfLoop(ListNode head) {
		ListNode meetNode = meet(head);
		if (meetNode == null) {
			return null;
		}
		int nodesInLoop = 1;
		ListNode node1 = meetNode;
		while (node1.next != meetNode) {
			nodesInLoop++;
			node1 = node1.next;
		}
		node1 = head;
		for (int i = 0; i < nodesInLoop; i++) {
			node1 = node1.next;
		}
		ListNode node2 = head;
		while (node1 != node2) {
			node1 = node1.next;
			node2 = node2.next;
		}
		return node1;
	}

	private static ListNode meet(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head.next;
		if (slow == null) {
			return null;
		}
		ListNode fast = slow.next;
		while (slow != null && fast != null) {
			if(slow == fast) {
				return slow;
			}
			slow = slow.next;
			fast = fast.next;
			if(fast != null) {
				fast = fast.next;
			}
		}
		return null;
	}
}
