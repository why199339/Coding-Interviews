package q26;

public class ComplexListClone {

	public static void main(String[] args) {
		
	}

	public static ComplexListNode clone(ComplexListNode head) {
		cloneNodes(head);
		connectSiblingNodes(head);
		return reconnextNodes(head);
	}
	
	private static void cloneNodes(ComplexListNode head) {
		ComplexListNode node = head;
		while (node != null) {
			ComplexListNode copy = new ComplexListNode();
			copy.value = node.value;
			copy.next = node.next;
			copy.sibling = null;
			node.next = copy;
			node = copy.next;
		}
	}

	private static void connectSiblingNodes(ComplexListNode head) {
		ComplexListNode node = head;
		while (node != null) {
			ComplexListNode copy = node.next;
			if(node.sibling != null) {
				copy.sibling = node.sibling.next;
			}
			node = copy.next;
		}
	}
	
	private static ComplexListNode reconnextNodes(ComplexListNode head) {
		ComplexListNode node = head;
		ComplexListNode cloneHead = null;
		ComplexListNode cloneNode = null;
		if(node != null) {
			cloneHead = cloneNode = node.next;
			node.next = cloneNode.next;
			node = node.next;
		}
		while(node != null) {
			cloneNode.next = node.next;
			cloneNode= cloneNode.next;
			node.next = cloneNode.next;
			node = node.next;
		}
		return cloneHead;
	}

}
