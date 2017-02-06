package q17;

public class Merge {

	public static void main(String[] args) {
		//l1: 1->2->4
		//l2: 2->3
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l1.next = new ListNode(2);
		l2.next = new ListNode(3);
		l1.next.next = new ListNode(4);
		ListNode p = merge(l1, l2);
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
	}

	public static ListNode merge(ListNode head1, ListNode head2) {
		if(head1 == null) {
			return head2;
		}
		if(head2 == null) {
			return head1;
		}
		ListNode mergeHead = null;
		if(head1.val < head2.val) {
			mergeHead = head1;
			mergeHead.next = merge(head1.next, head2);
		} else {
			mergeHead = head2;
			mergeHead.next = merge(head1, head2.next);
		}
		return mergeHead;
	}
}
