import CtCILibrary.LinkedListNode;
import CtCILibrary.AssortedMethods;

public class Answer {
	public static LinkedListNode findIntersection(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode node1 = head1;
		LinkedListNode node2 = head2;
		while (node1 != null && node2 != null) {
			node1 = node1.next;
			node2 = node2.next;
		}
		if (node1 == null) {
			while (node2 != null) {
				node2 = node2.next;
				head2 = head2.next;
			}
		} else {
			while (node1 != null) {
				node1 = node1.next;
				head1 = head1.next;
			}
		}
		while (head1 != null && head2 != null) {
			if (head1 == head2) {
				return head1;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return null;
	}

	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		LinkedListNode list1 = AssortedMethods.createLinkedListFromArray(vals);
		
		int[] vals2 = {12, 14, 15};
		LinkedListNode list2 = AssortedMethods.createLinkedListFromArray(vals2);
		
		list2.next.next = list1.next.next.next.next;
		
		System.out.println(list1.printForward());
		System.out.println(list2.printForward());
		
		
		LinkedListNode intersection = findIntersection(list1, list2);
		
		System.out.println(intersection.printForward());
	}

}