package practice.in.java;

//Iterative Queue based Java program to do level order traversal of Binary Tree

import java.util.Queue;
import java.util.LinkedList;

/* Class to represent Tree node */
class BFSNode {
	int data;
	BFSNode left, right;

	public BFSNode(int item) {
		data = item;
		left = null;
		right = null;
	}
}

/*Class to print Level Order Traversal */
class BinaryTree {

	BFSNode root;

	/*
	 * Given a binary tree. Print its nodes in level order using array for
	 * implementing queue
	 */
	void printLevelOrder() {
		Queue<BFSNode> queue = new LinkedList<BFSNode>();
		queue.add(root);
		while (!queue.isEmpty()) {

			// poll() removes the present head.
			BFSNode tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			/* Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			/* Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	public static void main(String args[]) {
		// creating a binary tree and entering the nodes
		BinaryTree tree_level = new BinaryTree();
		tree_level.root = new BFSNode(1);
		tree_level.root.left = new BFSNode(2);
		tree_level.root.right = new BFSNode(3);
		tree_level.root.left.left = new BFSNode(4);
		tree_level.root.left.right = new BFSNode(5);

		System.out.println("Level order traversal of binary tree is - ");
		tree_level.printLevelOrder();
	}
}
