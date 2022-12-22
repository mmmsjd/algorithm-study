package nocode.programming;

import java.util.LinkedList;
import java.util.Queue;

// 236. Lowest Common Ancesot of a Binary Tree(LCA)
// 가장 낲은 레벨의 공통 조상노드 찾기

// case : tree traverse
// case : recursive post order

/*
  		1
  	  /   \	
	2   	3 
  /	  \
4		5
      /   \
	6   	7
	
*/
public class Tree4 {
	

	public static void main(String[] args) {
		
		int p = 4;
		int q = 7;

		Node root = new Node(1) ;
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		root.left = node2   ;
		root.right = node3  ;
		
		node2.left = node4  ;
		node2.right = node5 ;
		
		node5.left = node6 ;
		node5.right = node7 ;
		
//		traversal(root, p, q);
		
		recursiveLCA(root, node4, node7);
		
		
	}
	
	private static void traversal(Node node, int p, int q2) {
		
		if(node == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		
		while(0 < q.size()) {
			int level = q.size();
//			System.out.println(level);
			
			for (int i = 0; i < level; i++) {
				Node curr = q.poll();
				System.out.print(curr.val);
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
	static int answer = 0;
	private static void recursiveLCA(Node node, Node p, Node q) {
	
		recurFind(node, p, q) ;
		
		System.out.println(answer);
	}

	private static int recurFind(Node node, Node p, Node q) {
		
		int found = 0;
	    int left_found = 0;
	    int right_found = 0;

		if (node.equals(p)) {
			found = 1;
		}
		if (node.equals(q)) {
			found = 1;
		}
		
		if(node.left != null) {
			left_found = recurFind(node.left, p, q) ;
		}
		if(node.right != null) {
			right_found = recurFind(node.right, p, q) ;
		}
		
		int found_cnt = found + left_found + right_found;
//		System.out.println(found_cnt+" "+node.val);
		if(found_cnt == 2) {
			answer = node.val;
			return 1;
		}
		
		if(0 < found_cnt) {
			return 1;
		}else {
			return 0;
		}
	}

	static class Node {
		int val;
		Node left;
		Node right;
		
		public Node(int val) {
			this.val = val;
		}
	}
}
