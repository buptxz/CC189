import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Answer {
	public static void deleteMiddle(LinkedListNode n) {
		// while (n.next.next != null) {
		// 	n.data = n.next.data;
		// 	n = n.next;
		// }
		// n.data = n.next.data;
		// n.next = null;
		n.data = n.next.data;
		n.next = n.next.next;
	}

	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteMiddle(head.next.next.next); // delete node 4
		System.out.println(head.printForward());
	}

}