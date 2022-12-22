package nocode.programming;

import java.util.ArrayList;
import java.util.List;

// 86. Partition List
// 143. Reorder List

// x=5 기준점을 기준으로 파티션해라.
// 175363 => 133 156

public class LinkedList8 {
	
	
	public static void main(String[] args) {
				
		ListNode head = new ListNode(1);
		ListNode node7 = new ListNode(7);
		ListNode node5 = new ListNode(5);
		ListNode node3 = new ListNode(3);
		ListNode node6 = new ListNode(6);
		ListNode node33 = new ListNode(3);
		
		head.next = node7;
		node7.next = node5;
		node5.next = node3;
		node3.next = node6;
		node6.next = node33;
		
		printNode(head);		
		
		int x = 5;
		
		
		// 1.나누기
//		List<ListNode> resultNode = partitions(head, x);
//		
//		for(ListNode l:resultNode) {
//			printNode(l);
//		}

		// 1.middle
		// 2.split
		// 3.reverse
		// 4.re-order
		ListNode resultNode = reorder(head);
		

	}
	
	private static ListNode reorder(ListNode head) {
		// TODO Auto-generated method stub
		return null;
	}

	private static List<ListNode> partitions(ListNode head, int x) {
		List<ListNode> list = new ArrayList<>();
		
		ListNode dummyA = new ListNode(-1);
		ListNode dummyB = new ListNode(-1);
		
		ListNode nodeA = dummyA;
		ListNode nodeB = dummyB;
		
		ListNode currNode = head;
				
		
		while(currNode != null) {
			if(currNode.val < x) {
				nodeA.next = currNode;
				nodeA = nodeA.next;
				currNode = currNode.next;
			}else {
				nodeB.next = currNode;
				nodeB = nodeB.next;
				currNode = currNode.next;
			}
		}
		nodeB.next = null;
		
		list.add(dummyB.next);
		list.add(dummyA.next);
		
		
		return list;
	}




	private static void printNode(ListNode node) {
		ListNode curr = node;
		while(curr != null) {
			System.out.print(curr.val);
			curr = curr.next;
		}
		System.out.println();
	}
	
	/*
	 * Definition for singly-linked list.
	 */
	static public class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}

	}
	
	
}
