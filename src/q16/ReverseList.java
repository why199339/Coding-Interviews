package q16;

public class ReverseList {

	public static void main(String[] args) {
		ListNode node1 = null;
//		ListNode node1 = new ListNode(1);
//		ListNode node2 = new ListNode(2);
//		ListNode node3 = new ListNode(3);
//		ListNode node4 = new ListNode(4);
//		ListNode node5 = new ListNode(5);
//
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = null;
		
		ListNode node = reverseList_2(node1);
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode reverseList_1(ListNode head) {
		ListNode reversedHead = null;
		ListNode node = head;
		ListNode prev = null;
		while(node != null) {
			ListNode next = node.next;
			if(next == null) {
				reversedHead = node;
			}
			node.next = prev;
			prev = node;
			node = next;
		}
		return reversedHead;
	}
	
	public static ListNode reverseList_2(ListNode head) {
	    if (head == null || head.next == null) return head;
	    ListNode p = reverseList_2(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
	}
}
