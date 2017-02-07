import CtCILibrary.LinkedListNode;

public class Answer {
	public static LinkedListNode partition(LinkedListNode n, int p) {
		LinkedListNode headA = null;
		LinkedListNode headB = null;
		LinkedListNode tailA = null;
		LinkedListNode tailB = null;

		while (n != null) {
			LinkedListNode newNode = new LinkedListNode(n.data);
			if (n.data < p) {
				if (headA == null){
					headA = newNode;
					tailA = headA;
				} else {
					tailA.next = newNode;
					tailA = tailA.next;
				}
				
			} else {
				if (headB == null){
					headB = newNode;
					tailB = headB;
				} else {
					tailB.next = newNode;
					tailB = tailB.next;
				}
			}
			n = n.next;
		}
		if (headA == null) {
			return headB;
		}
		tailA.next = headB;
		return headA;
	}

	public static LinkedListNode partition2(LinkedListNode node, int p) {
		LinkedListNode head = null;
		LinkedListNode tail = null;
		while (node != null) {
			LinkedListNode newNode = new LinkedListNode(node.data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			}
			if (node.data < p) {
				newNode.next = head;
				head = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			node = node.next;
		}
		return head;
	}

	public static LinkedListNode createLinkedList() {
		/* Create linked list */
		int[] vals = {3, 5, 8, 5, 10, 2, 1};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		return head;
	}

	public static void main(String[] args) {
		System.out.println(createLinkedList().printForward());
		
		/* Partition */
		LinkedListNode hA = partition(createLinkedList(), 5);
		
		/* Print Result */
		System.out.println(hA.printForward());

	}
}