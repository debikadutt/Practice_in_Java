package practice.in.java;

public class ReverseLinkedListIterative {

	public static void main(String[] args) {
		Node a = new Node(4);
		Node b = new Node(6);
		Node c = new Node(8);
		Node d = new Node(7);
		a.next = b;
		b.next = c;
		c.next = d;
		a.printLinkedList();
		Node head = reverseLinkedList(a);
		head.printLinkedList();
	}

	public static Node reverseLinkedList(Node head) {
		if (head == null)
			return null;
		Node prev = null;
		Node next = null;
		Node curr = head;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}

	static class Node {
		public Node next;
		public int value;

		public Node(int value) {
			this.value = value;
		}

		public void printLinkedList() {
			Node head = this;
			while (head != null) {
				System.out.print(head.value + "->");
				head = head.next;
			}
			System.out.println();
		}
	}
}
