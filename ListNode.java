
public class ListNode {
    int value;
    ListNode next = null;
    
    public ListNode(int value) {
		 this.value = value;
	}
    
    public ListNode insert (ListNode head, ListNode nodeToInsert) {
    	nodeToInsert.next = head;
    	return nodeToInsert;
    }
    
    public void printList() {
    	ListNode itr = this;
    	while (itr != null) {
    		System.out.print(itr.value + " ");
    		itr = itr.next;
    	}
    }
    
    public String toString() {
    	StringBuilder b = new StringBuilder();
    	b.append(this.value);
    	return b.toString();
    }
    
    public ListNode oddEvenSort() {
    	ListNode current = this;
    	ListNode odd = this.next;
    	ListNode firstOdd = odd;
    	ListNode even = odd.next;
    	ListNode firstEven = current;
    	odd.next = current;
    	current.next = even;
    	current = even;
    	while (current.next != null) {
    		odd.next = current.next;
    		odd = odd.next;
    		even = odd.next;
    		odd.next = firstEven;
    		current.next = even;
    		current = even;
    	}
    	return firstOdd;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head = head.insert(head, new ListNode(2));
    	head = head.insert(head, new ListNode(3));
    	head = head.insert(head, new ListNode(4));
    	head = head.insert(head, new ListNode(5));
    	head.printList();
    	System.out.println("\n");
    	head = head.oddEvenSort();
    	head.printList();
    }
}
