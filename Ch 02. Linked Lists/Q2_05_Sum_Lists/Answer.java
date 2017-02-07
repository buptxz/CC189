import CtCILibrary.LinkedListNode;

public class Answer {
	public static LinkedListNode sumList(LinkedListNode node1, LinkedListNode node2) {
		// transfer linked list to int, do the summary, transfer to lined list back
		int num1 = listToInt(node1);
		int num2 = listToInt(node2);
		int sum = num1 + num2;
		return intToList(sum);
	}

	public static int listToInt(LinkedListNode node) {
		if (node == null) {
			return 0;
		}
		int times = 1;
		int num = 0;
		while (node != null) {
			num += node.data * times;
			node = node.next;
			times *= 10;
		}
		return num;
	}

	public static LinkedListNode intToList(int num) {
		int length = (int)(Math.log10(num)+1);
		LinkedListNode head = null;
		if (num == 0){
			head.data = 0;
			head.next = null;
			return head; 
		}
		for (int i = length - 1; i >= 0; i--) {
			LinkedListNode node = new LinkedListNode(num / (int) Math.pow(10, i));
			if (head == null) {
				head = node;
			} else {
				node.next = head;
				head = node;
			}
			num %= Math.pow(10, i);
		}
		return head;
	}

	public static LinkedListNode addList(LinkedListNode node1, LinkedListNode node2) {
		// on the fly summary for linked list
		int carry = 0;
		LinkedListNode head = null;
		LinkedListNode tail = null;
		while (node1 != null || node2 != null || carry != 0) {
			int sum = (node1 == null ? 0 : node1.data)  + (node2 == null ? 0 : node2.data) + carry;
			carry = sum / 10;
			LinkedListNode newNode = new LinkedListNode(sum % 10);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = tail.next;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		return head;
	}

	public static LinkedListNode addList2(LinkedListNode node1, LinkedListNode node2) {
		// summary for linked list, but with reverse stored digits

	}

	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(9, null, null);
		LinkedListNode lA2 = new LinkedListNode(9, null, lA1);
		LinkedListNode lA3 = new LinkedListNode(0, null, lA2);
		
		LinkedListNode lB1 = new LinkedListNode(0, null, null);
		LinkedListNode lB2 = new LinkedListNode(0, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(0, null, lB2);	
		
		LinkedListNode list3 = addList(lA1, lB1);
		
		System.out.println("  " + lA1.printForward());		
		System.out.println("+ " + lB1.printForward());			
		System.out.println("= " + list3.printForward());	
		
		int l1 = listToInt(lA1);
		int l2 = listToInt(lB1);
		int l3 = listToInt(list3);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));		
	}
}