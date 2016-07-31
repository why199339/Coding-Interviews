package q5;

public class AddToTail {

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
		node = addToTail(head, 3);
		System.out.println();
		System.out.println("-----------------------------------");
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode addToTail(ListNode head, int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = null;
		if(head == null) {
			head = newNode;
		} else {
			ListNode pNode = head;
			while(pNode.next != null) {
				pNode = pNode.next;
			}
			pNode.next = newNode;
		}
		return head;
	}
}
