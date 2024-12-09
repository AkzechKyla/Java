
public class LinkedList {
	
	// every linked list has node element
	class Node {
		int val;
		
		Node next;
		
		Node(int val) {
			this.val = val;
		}
	}
	
	// pointers
	private Node head;
	private Node tail;
	
	// inserting a new element at the beginning
	public void addFirst(int val) {
		if (isEmpty()) {
			head = new Node(val);
			tail = head;
			return;
		}
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
	}
	
	// inserting a new element at the end
	public void addLast(int val) {
		if (isEmpty()) {
			head = new Node(val);
			tail = head;
			return;
		}
		Node newNode = new Node(val);
		tail.next = newNode;
		tail = newNode;
	}
	
	// inserting a new element at the middle
	public void add(int pos, int val) {
		// validate pos using size
		if (pos == 1) {
			addFirst(val);
			return;
		}
		Node current = head;
		int count = 1;
						//pos = 4 - 1| 3 
		while (count < pos - 1) {
			count++;
			current = current.next;
		}
		Node newNode = new Node(val);
		newNode.next = current.next;
		current.next = newNode;
	}
	
	// delete a node at the beginning
	public int deleteFirst() {
		if(isEmpty()) {
			throw new RuntimeException("List is empty");
		}
		Node current = head;
		head = head.next;
		if(isEmpty()) {
			tail = null;
		}
		return current.val;
	}
	
	// delete a node at the end
	public int deleteLast() {
		if(isEmpty()) {
			throw new RuntimeException("List is empty");
		}
		if (head == tail) {
			int val = head.val;
			head = null;
			tail = null;
		}
		Node current = head;
		Node prev = null;
		
		while (current.nex != null) {
			prev = current;
			current = current.next;
		}
		prev.next = null;
		tail = prev;
		return current.val;
	}
	
	// deleting the element at given position
	public int delete(int pos) {
		if(isEmpty()) {
			throw new RuntimeException("List is empty");
		}
		if (pos == 1) {
			deleteFirst();
		}
		Node current = head; // 10
		Node prev = null;
		int count = 1;
		while (current.next < pos) {
			count++ 
			prev = current; 
			current = current.next; 
		}
		prev.next = current.next; 
		current.next = null;
		return current.val;
	}

	public boolean search(int val) {
		Node current = head;
		while (current != null) {
			if (val == current.val) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// to check if there's element present in the list
	public boolean isEmpty() {
		return head == null;
	}
	
	// display elements of the linked list
	public void print() {
		Node current = head; // start at the head always
		
		while (current != null) {
			System.out.print(current.val + " -> ");
			current = current.next; // moving to the next node
		}
		System.out.println();
	}
}
