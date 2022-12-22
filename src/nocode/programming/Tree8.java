package nocode.programming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 108. Convert Sorted Array to Binary Search Tree
// height Balanced BST 를 만들어 달라는 문제
// height Balanced 란 depth 가 <= 1 인 경우를 말한다.

// 235. Lowest Common Ancestor of a Binary Search Tree




public class Tree8 {
	

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		
		// 문제1
		Node node = sortedArrayToBST(nums);
		printNode(node);
/*
		   6 
		 3    9 
	   2  5  8  10 
	 1  4   7 
*/
		
		// 문제2 
		int p = 7, q = 10;
		Node result = LCA_BST(node, p, q);		
		System.out.println(result.val);
		
		
		
	}
	
	private static Node LCA_BST(Node node, int p, int q) {
		int value = node.val;
		
		if(value < p && value < q) {
			Node retNode = LCA_BST(node.right, p, q);	
			return retNode;
		}
		if(p < value && q < value) {
			Node retNode = LCA_BST(node.left, p, q);	
			return retNode;
		}
		
		return node;
	}

	private static Node sortedArrayToBST(int[] nums) {
		int len = nums.length;
		if(len == 0) return null;
		
		int centerIdx = len/2;
		
		int[] leftNums = Arrays.copyOfRange(nums, 0, centerIdx);
		int[] rightNums = Arrays.copyOfRange(nums, centerIdx+1, len);
		
		int value = nums[centerIdx];
		Node node = new Node(value);
		
		Node left = sortedArrayToBST(leftNums);
		Node right = sortedArrayToBST(rightNums);
		
		node.left = left;
		node.right = right;
		
		return node;
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
