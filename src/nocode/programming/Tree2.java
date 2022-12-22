package nocode.programming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// 113. Path Sum
// target sum = 20, 
// 가중치 합이 20이 되는 모든 경우의 수의 경로를 print 해라.


//    7
// -2   5
//3 15 8 -1

// backtraking 모든 가능성 pre order 
// fn(node, targetSum, currentList){
// exit part 
// processing part
// recursive part
//}

public class Tree2 {
	

	public static void main(String[] args) {
		
		Node root = new Node(7);
		Node node2n = new Node(-2);
		Node node5 = new Node(5);
		Node node3 = new Node(3);
		Node node15 = new Node(15);
		Node node8 = new Node(8);
		Node node1n = new Node(-1);
		root.left = node2n;
		root.right = node5;
		
		node2n.left = node3;
		node2n.right = node15;
		
		node5.left = node8;
		node5.right = node1n;
				
		int targetSum = 20;
		Stack<Integer> stack = new Stack<>();
		treePrint(root, targetSum, stack);
		
		
	}
	static void treePrint(Node node, int targetSum, Stack<Integer> stack){
		if(node == null) {
			return; 
		}
		recurcivePathSum(node, targetSum, stack);
		System.out.println(result);
	}
	
	static List<String> result = new ArrayList<>();
	
	private static void recurcivePathSum(Node node, int targetSum, Stack<Integer> stack) {
								
			if(node.val == targetSum) {
				stack.add(node.val);			
				result.add(stack.clone().toString());
				stack.pop();
				return;
			}
			
			int newTargetSum = targetSum - node.val;
			if(node.left != null) {
				stack.add(node.val);
				recurcivePathSum(node.left, newTargetSum, stack);
				stack.pop();
			}
			
			if(node.right != null) {
				stack.add(node.val);
				recurcivePathSum(node.right, newTargetSum, stack);
				stack.pop();
			}
			return;
		
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
