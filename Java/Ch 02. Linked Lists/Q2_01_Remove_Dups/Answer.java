import java.util.HashSet;

public class Answer {
	public static void removeDup(LinkedListNode n) {
		HashSet<Integer> hs = new HashSet<Integer>();
		if (n != null) {
			hs.add(n.data);
			while (n.next != null) {		
				if (hs.contains(n.next.data)) {
					n.next = n.next.next;
				} else {
					hs.add(n.next.data);
					n = n.next;	
				}				
			}
		}
	}

	public static void removeDup2(LinkedListNode n) {
		if (n != null) {
			LinkedListNode nLeft = n;
			LinkedListNode nRight = n;
			while (nLeft != null){
				nRight = nLeft;
				while (nRight.next != null){
					if (nLeft.data == nRight.next.data){
						nRight.next = nRight.next.next;
					} else {
						nRight = nRight.next;
					}
				}
				nLeft = nLeft.next;
			}
		}
		

	}

	public static void main(String[] args) {
		System.out.println("hello");
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 16; i++) {
			second = new LinkedListNode(i % 3, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());

		LinkedListNode cloneA = head.clone();
		LinkedListNode cloneB = head.clone();

		Answer.removeDup(cloneA);
		Answer.removeDup2(cloneB);
	
		System.out.println(cloneA.printForward());
		System.out.println(cloneB.printForward());

	}
}