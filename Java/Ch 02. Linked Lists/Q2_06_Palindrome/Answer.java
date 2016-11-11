import CtCILibrary.LinkedListNode;
import java.util.Stack;

public class Answer {

	public static boolean isPalindrome(LinkedListNode node) {
		LinkedListNode head = reverse(node);
		while (head != null) {
			if (head.data != node.data) {
				return false;
			}
			head = head.next;
			node = node.next;
		}
		return true;
	}

	public static LinkedListNode reverse(LinkedListNode node) {
		LinkedListNode head = null;
		while (node != null) {
			LinkedListNode newNode = new LinkedListNode(node.data);
			if (head == null) {
				head = newNode;
			} else {
				newNode.next = head;
				head = newNode;
			}
			node = node.next;
		}
		return head;
	}

	public static boolean isPalindrome2(LinkedListNode node) {
		// Checking palindrome by iterating
		LinkedListNode fast = node;
		LinkedListNode slow = node;

		Stack<Integer> stack = new Stack<Integer>();
		while (fast != null) {
			if (fast.next == null) {
				slow = slow.next;
				break;
			}
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		while (slow != null) {
			if (stack.pop() != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	public static void main(String[] args) {
		int max = 11;
		for (int length = 1; length < max; length++) {
			LinkedListNode[] nodes = new LinkedListNode[length];
			for (int i = 0; i < length; i++) {
				nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
			}
			
			for (int i = 0; i < length; i++) {
				if (i < length - 1) {
					nodes[i].setNext(nodes[i + 1]);
				}
				if (i > 0) {
					nodes[i].setPrevious(nodes[i - 1]);
				}
			}
			for (int i = -1; i < length; i++) {
				if (i >= 0) {
					nodes[i].data++; // Ruin palindrome
				}
				
				LinkedListNode head = nodes[0];
				System.out.println(head.printForward());
				boolean resultA = QuestionA.isPalindrome(head);
				boolean resultB = QuestionB.isPalindrome(head);
				boolean resultC = QuestionC.isPalindrome(head);
				boolean resultD = Answer.isPalindrome2(head);

				System.out.println("A: " + resultA);
				System.out.println("B: " + resultB);
				System.out.println("C: " + resultC);
				System.out.println("D: " + resultD);

				if (resultA != resultB || resultB != resultC || resultC != resultD) {
					System.out.println("ERROR");
					length = max;
					break;
				}
				if (i >= 0) {
					nodes[i].data--;
				}
			}
		}
	}
}