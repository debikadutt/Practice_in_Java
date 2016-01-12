package linkedList;

public class KthToLast {
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
		printList(solution(4, linked));
	}

	public static Node solution(int k, Node head) {
		Node n1 = head;
		Node n2 = head;

		for (int i = 0; i < k; i++) {
			if (n1 == null)
				return null;
			n1 = n1.next;
		}

		while (n1 != null) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n2;
	}

	private static void printList(Node head) {
		Node n = head;
		while (n.next != null) {
			System.out.printf("%d -> ", n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}
}
