package nocode.programming;

// 543. Diameter of Binary Tree

// Diameter 연결된 최대 길이는 찾아라
// leaf 까지는 모두 도달해야한다.

// left max depth = fn(left)
// right max depth = fn(right)
// return max(ld, rd) + current depth;

//    1
//  2   3
//4   5
//  6   7
//8       9


public class Tree3 {
	

	public static void main(String[] args) {
		

		Node root = new Node(1) ;
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		
		root.left = node2   ;
		root.right = node3  ;
		node2.left = node4  ;
		node2.right = node5 ;
		node4.right = node6 ;
		node6.left = node8  ;
		node5.right = node7 ;
		node7.right = node9 ;
		
		
		diameterTree(root);
		System.out.println(diameter);
		
		
	}
	
	static int diameter = 0;
	
	private static int diameterTree(Node node) {
		int left_depth = 0;
		int right_depth = 0;
		
		if(node.left != null) {
			left_depth = diameterTree(node.left);
		}
		if(node.right != null) {
			right_depth = diameterTree(node.right);
		}
		
		int node_diameter = left_depth + right_depth;
		
		diameter = Math.max(diameter, node_diameter);
		int node_depth = Math.max(left_depth, right_depth);
		
		return node_depth+1;
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
