package q13;

public class DeletNode {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		ListNode node1 = new ListNode(2);
//		ListNode node2 = new ListNode(3);
//		head.next = node1;
//		head.next.next = node2;
		ListNode node = head;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		node = deleteNode(head, head);
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
		if (head == null || toBeDeleted == null) {
			return null;
		}
		if (toBeDeleted.next != null) {
			toBeDeleted.val = toBeDeleted.next.val;
			toBeDeleted.next = toBeDeleted.next.next;
		} else if (toBeDeleted == head) {
			head = null;
			toBeDeleted = null;
		} else {
			ListNode node = head;
			while(node.next != toBeDeleted) {
				node = node.next;
			}
			node.next = null;
		}
		return head;
	}
}
