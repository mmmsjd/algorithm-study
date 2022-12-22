package nocode.programming;

import java.util.LinkedList;
import java.util.Queue;

import nocode.programming.Tree4.Node;

// 117. Populating Next Right Pointers in Each Node 1,2

// case : Tree Traversals ·Î ¹®Á¦1 


public class Tree6 {
	

	public static void main(String[] args) {
		
		Node node1 = new Node(1) ;
		Node node3 = new Node(3);
		Node node5 = new Node(5);
		Node node7 = new Node(7);
		Node node9 = new Node(9);
		Node node11 = new Node(1);
		
		node1.left = node3;
		node1.right = node5;
		
		node3.left = node7;
		node3.right = node9;
		
		node5.right = node11;
		
		// 1
//		treversal(node1);
		
		// 2
		Node result = treversal2(node1);
		printNode(result);
		
		
		
	}
	
	private static Node treversal2(Node root) {
		Node level_node = root;
		
		while(level_node != null) {
		  Node curr_node = level_node;
		  Node next_level = null;
		  Node prev_child = null;
		  
		  while(curr_node != null) {
			  if(curr_node.left != null) {
				  _connect(prev_child, curr_node.left);
				  prev_child = curr_node.left;
				  if(next_level == null) {
					  next_level = curr_node.left;
				  }
			  }
			  if(curr_node.right != null) {
				  _connect(prev_child, curr_node.right);
				  prev_child = curr_node.right;
				  if(next_level == null) {
					  next_level = curr_node.right;
				  }
			  }
			  curr_node = curr_node.next;
		  }
		  level_node = next_level;
			
		}
		return root;
	}
	
	static void _connect(Node prev_node, Node next_node) {
		if(prev_node != null) {
			prev_node.next = next_node;
		}
	}

	private static void treversal(Node node1) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(node1);
		
		while(0 < q.size()) {
			int level = q.size();
			Node prev = null;
			
			for (int i = 0; i < level; i++) {
				Node curr = q.poll();
				
				if(curr != null) {
					if(prev != null) {
						prev.next = curr;
					}
					prev = curr;
				}

				if(curr.left != null) {
					q.add(curr.left);
				}
				if(curr.right != null) {
					q.add(curr.right);
				}
			}
			
		}

		printNode(node1);
		
	}

	static void printNode(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		while(0 < q.size()) {
			int level = q.size();
			
			for (int i = 0; i < level; i++) {
				Node curr = q.poll();
				System.out.print(curr.val);
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
