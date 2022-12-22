package nocode.programming;

import java.util.LinkedList;
import java.util.Queue;

// Binary Search Tree(BST)
// 98. Validate Binary Search Tree


public class Tree7 {
	

	public static void main(String[] args) {
		
		Node root = new Node(8);
		Node node3 = new Node(3);
		Node node10 = new Node(10);
		Node node1 = new Node(1);
		Node node6 = new Node(6);
		Node node14 = new Node(14);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node13 = new Node(13);

		root.left = node3;
		root.right = node10;

		node3.left = node1;
		node3.right = node6;

		node10.right = node14;

		node6.left = node4;
		node6.right = node7;

		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		

		boolean result = recurIsBST(root, -min, max);
		
		System.out.println(result);
		printNode(root);
		
		
		
	}
	

	private static boolean recurIsBST(Node node, int min, int max) {
		if(node == null) return true;
		int value = node.val;
		
		if(value <= min) return false;
		if(max <= value) return true;
		
		boolean left = recurIsBST(node.left, min, value);
		boolean right = recurIsBST(node.right, value, max);
		
		
		return (left && right);
	}



	static void printNode(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		
		while(0 < q.size()) {
			int level = q.size();
			
			for (int i = 0; i < level; i++) {
				Node curr = q.poll();
				System.out.print(curr.val);
				System.out.print(" ");
				if(curr.next != null) {
					System.out.print("("+curr.next.val+")");
				}
				
				if(curr.left != null) {
					q.add(curr.left);
				}
				if(curr.right != null) {
					q.add(curr.right);
				}
			}
			System.out.println();
		}
	}
	static class Node {
		int val;
		Node left;
		Node right;
		Node next;
		
		public Node(int val) {
			this.val = val;
		}
	}
}
