package q5;

public class RemoveNode {

	public static void main(String[] args) {
//		ListNode head = null;
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		ListNode node = head;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		node = removeNode(head, 1);
		System.out.println();
		System.out.println("------------------");
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode removeNode(ListNode head, int value) {
		if(head == null) {
			return null;
		}
		ListNode node = head;
		if(head.val == value) {
			node = head.next;
			return node;
		} else {
			while(node.next != null && node.next.val != value) {
				node = node.next;
			}
			if(node.next != null && node.next.val == value) {
				node.next = node.next.next;
			}
			return head;
		}
	}
}
