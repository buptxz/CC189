import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Answer {
	public static LinkedListNode kthToLast(LinkedListNode n, int k){
		if (k == 0) {
			return null;
		}
		LinkedListNode nLeft = n;
		LinkedListNode nRight = n;
		for (int i = 0; i < k; i++) {
			if (nRight == null) {
				return null;
			} else {
				nRight = nRight.next;
			}
		}
		while (nRight != null) {
			nLeft = nLeft.next;
			nRight = nRight.next;
		}
		return nLeft;
	}

	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
		for (int i = 0; i <= array.length + 2; i++) {
			LinkedListNode node = kthToLast(head, i);
			String nodeValue = node == null ? "null" : "" + node.data;
			System.out.println(i + "th to last node is " + nodeValue);
		}
	}
}