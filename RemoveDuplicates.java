package linkedList;

import java.util.HashSet;

public class RemoveDuplicates {
	private static class Node {
		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}

		public void add(int d) {
			Node end = new Node(d);
			Node n = this;
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
	}

	public static void main(String[] args) {
		Node linked = new Node(5);
		linked.add(2);
		linked.add(3);
		linked.add(2);
		linked.add(7);
		printList(linked);
		removeDuplicates(linked);
		printList(linked);
	}

	public static void removeDuplicates(Node head) {
		// assuming linked list of integers
		HashSet<Integer> seen = new HashSet<Integer>();
		Node curr = head;
		while (curr.next != null) {
			seen.add(curr.data);
			if (seen.contains(curr.next.data)) {
				curr.next = deleteNode(curr.next);
			}
			curr = curr.next;
		}
	}

	private static void printList(Node head) {
		Node n = head;
		while (n.next != null) {
			System.out.printf("%d -> ", n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}

	private static Node deleteNode(Node head) {
		return head.next;
	}
}
