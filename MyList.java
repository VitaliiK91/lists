
public class MyList<T> {
	
	/* This is a Singly Linked List*/
	
	private class MyLink {
		private T value;
		private MyLink nextLink;
		
		public MyLink(T value) {
			this.value = value;
			this.nextLink = null;
		}
		
	};
	
	private MyLink firstLink;
	private MyLink lastLink;
	
	public MyList() {
		firstLink = null;
		lastLink = null;
	}
	
	public T front() {
		return firstLink.value;
	}
	
	public T back() {
		return lastLink.value;
	}
	
	public void pushFront(T value) {
		MyLink newLink = new MyLink(value);
		if(empty()) firstLink = lastLink = newLink;
		else {
			newLink.nextLink = firstLink;
			firstLink = newLink;
		}
	}
	
	public void pushBack(T value) {
		MyLink newLink = new MyLink(value);
		if(empty()) firstLink = lastLink = newLink;
		else {
		    lastLink.nextLink = newLink;
		    lastLink = newLink;
		}
	}
	
	public void popFront() {
		if (firstLink == null) {
			return;
		}
		firstLink = firstLink.nextLink;
	}
	
	public void popBack() {
		if(firstLink == lastLink) {
			firstLink = lastLink = null;
			return;
		}
		else {
			MyLink firstLinkItr = firstLink;
			MyLink secondLinkItr = firstLink.nextLink;
			while (secondLinkItr.nextLink != null) {
				if (secondLinkItr.nextLink == lastLink) {
					lastLink = secondLinkItr;
					lastLink.nextLink = null;
					return;
				}
				firstLinkItr = secondLinkItr.nextLink;
				secondLinkItr = firstLinkItr.nextLink;
			}
			lastLink = firstLinkItr;
			lastLink.nextLink = null;
		}
	}
	
	 
	 // Reverses List. This method swaps the first and last link, then starts linking 3 values in reverse order.
	 
	
	public void reverse() {
		if (firstLink == lastLink || firstLink == null) return;
		MyLink firstLinkItr = firstLink;
		firstLink = lastLink;
		lastLink = firstLinkItr;
		MyLink secondLinkItr = firstLinkItr.nextLink;
		//This variable is used to swap iterator positions.
		MyLink swap;
		//Remember that original first and last links are switched when using comparisons.
		while (secondLinkItr != null && secondLinkItr.nextLink != null ) {
			swap = secondLinkItr.nextLink;
			secondLinkItr.nextLink = firstLinkItr;
			firstLinkItr = swap;
			swap = firstLinkItr.nextLink;
			firstLinkItr.nextLink = secondLinkItr;
			secondLinkItr = swap;
		}
		if (secondLinkItr == firstLink) {
			firstLink.nextLink = firstLinkItr;
		}
		lastLink.nextLink = null;
	}
	
	// Return if list is empty.
	
	public boolean empty() {
		return firstLink == null;
	}
	
	//Prints the list.
	
	public void printList() {
		System.out.print("{ ");
		for(MyLink linkItr = firstLink; linkItr != null; linkItr = linkItr.nextLink ) {
			System.out.print(linkItr.value);
			if (linkItr.nextLink != null) { System.out.print(" , "); }
		}
		System.out.println(" }");
	}
	
	
	public static void main(String[] args) {
		MyList<String> x = new MyList<String>();
		String[] g  = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n"};
		x.printList();
		for (int i = 0; i <= 13; i++) {
			x.pushBack(g[i]);
		}
		x.printList();
		x.reverse();
		x.printList();
	}

}
