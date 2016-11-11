import CtCILibrary.LinkedListNode;
import java.util.HashSet;

public class Answer {
	public static LinkedListNode loopDetection(LinkedListNode head) {
		HashSet<LinkedListNode> hs = new HashSet<LinkedListNode>();
		while (head != null) {
			if (hs.contains(head)) {
				return head;
			}
			hs.add(head);
			head = head.next;
		}
		return null;
	}
	
	public static LinkedListNode loopDetection2(LinkedListNode head) {
		// only using two pointers, no extra space
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		int list_length = 100;
		int k = 10;
		
		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
		nodes[list_length - 1].next = nodes[list_length - k];
		
		LinkedListNode loop = loopDetection2(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}
	}
}