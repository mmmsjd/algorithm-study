package nocode.programming;

import java.util.LinkedList;
import java.util.Queue;

// Full binary Tree ������ Ʈ��
// Complete binary Tree ���� ���� Ʈ�� 
// Perfect Binary Tree ��ȭ ���� Ʈ�� (������尡 ����)

// pre order 	NLR 1245367
// in order		LNR 4251637
// post order 	LRN 4526371
// level order ������ ���� ��������� ��� 

// FIFO ť�� �ֱ�

//	 1
// 2   3
//4 5 6 7

// recursive �� ������ �Ѵٸ� call stack �� �̿��Ѵٴ� �� 
// �������� üũ-> ����üũ �ؼ� �ִٸ� �ְ� ��� 


public class Tree1 {
	

	public static void main(String[] args) {
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		
		treePrint(node1);
		
		
	}
	static void treePrint(Node node){
		if(node == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		
		while(0 < q.size()) {
			Node curr = q.poll();
			System.out.println(curr.val);
			
			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
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
