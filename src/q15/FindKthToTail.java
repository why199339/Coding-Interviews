package q15;

public class FindKthToTail {

	public static void main(String[] args) {
//		ListNode head = null;
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ListNode l = findKthToTail(head, 6);
		if(l != null) {
			System.out.println(l.val);
		}
	}

	public static ListNode findKthToTail(ListNode head, int k) {
		if(head == null || k == 0) {
			return null;
		}
		ListNode first = head;
		ListNode second = head;
		for(int i = 0; i< k - 1; i++) {
			if(first.next != null) {
				first = first.next;
			} else {
				return null;
			}
		}
		while(first.next != null) {
			first = first.next;
			second = second.next;
		}
		return second;
	}
}
