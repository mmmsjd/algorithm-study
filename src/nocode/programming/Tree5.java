package nocode.programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// 105. Construct Tree from Pre/In Order

/*
  		1
  	  /   \	
	3   	5
   /  	   /   \
  7	     2   	4
pre : 137524 
in :  731254
*/

//위와 같이 pre order array 와 in order array 두개의 list 가 주어졌을때 
// tree 를 재구성해라.

//case : recursive 한 방법
//case : hash 를 이용한 방법

public class Tree5 {
	

	public static void main(String[] args) {
		
		int[] pre = {1,3,7,5,2,4};
		int[] in = {7,3,1,2,5,4};
		
		buildTree(pre, in);
		
		buildTreeHash(pre, in);
		
		
		
		
	}
	static int[] preOrder;
	static int[] inOrder;
	static int preOrderIdx;
	
	static HashMap<Integer, Integer> inOrderMap = new HashMap<>();
	
	private static Node buildTreeHash(int[] pre, int[] in) {
		if(pre.length == 0 || in.length == 0) return null;
		
		preOrder = pre;
		inOrder = in;
		
		for (int i = 0; i < in.length; i++) {
			int val = in[i];
			inOrderMap.put(val, i);
			
		}
		preOrderIdx = 0;
		
		Node result = recurTreeHash(0, pre.length-1);
		printNode(result);
		return result;
	}

	private static Node recurTreeHash(int leftIdx, int rightIdx) {
		
		if(leftIdx > rightIdx) {
			return null;
		}
		int val = preOrder[preOrderIdx];
		preOrderIdx++;
		int center = inOrderMap.get(val);
		
		Node currNode = new Node(val);
		
		Node leftNode = recurTreeHash(leftIdx, center-1);
		Node rightNode = recurTreeHash(center+1, rightIdx);
		
		currNode.left = leftNode;
		currNode.right = rightNode;
		
		
		return currNode;
	}

	private static Node buildTree(int[] pre, int[] in) {
		if(pre.length == 0 || in.length == 0) return null;
		
		Node result = recurTree(pre, in);
		printNode(result);
		return result;
		
		
	}

	private static Node recurTree(int[] pre, int[] in) {
		if(pre.length == 0 || in.length == 0) return null;
		
		int val = pre[0];
		int center = 0;
		for (int i = 0; i < in.length; i++) {
			if(val == in[i]) {
				center = i;
			}
		}
		
		int[] left_inorder = Arrays.copyOfRange(in, 0, center);
		int left_count = left_inorder.length;
		int[] left_preorder = Arrays.copyOfRange(pre, 1, left_count+1);
		
		int[] right_inorder = Arrays.copyOfRange(in, center+1, in.length);
		int[] right_preorder = Arrays.copyOfRange(pre, left_count+1, pre.length);
		
		Node currNode = new Node(val);
		
		Node leftNode = recurTree(left_preorder, left_inorder);
		Node rightNode = recurTree(right_preorder, right_inorder);
		
		currNode.left = leftNode;
		currNode.right = rightNode;
		
		return currNode;
	}

	static void printNode(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		while(0 < q.size()) {
			int level = q.size();
			
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
	static class Node {
		int val;
		Node left;
		Node right;
		
		public Node(int val) {
			this.val = val;
		}
	}
}
