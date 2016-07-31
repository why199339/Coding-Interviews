package q5;

public class PrintListResersingly_Recursively {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		printListResersingly_Recursively(head);
	}

	public static void printListResersingly_Recursively(ListNode head) {
		if(head != null) {
			if(head.next != null) {
				printListResersingly_Recursively(head.next);
			}
			System.out.print(head.val + " ");
		}
	}
}
