package nocode.programming;

import java.util.HashSet;

// 206. Reverse Linked List
// 13579 -> 97531

// case : iterative O(n), O(1)
// case : recurcive O(n), O(n):stack frame

public class LinkedList6 {
	
	
	public static void main(String[] args) {
				
		ListNode head = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node5 = new ListNode(5);
		ListNode node7 = new ListNode(7);
		ListNode node9 = new ListNode(9);
		
		head.next = node3;
		node3.next = node5;
		node5.next = node7;
		node7.next = node9;
		
		
		printNode(head);		
		
//		ListNode resultNode = iterativeWay(head);
		ListNode resultNode = recursiveWay(head);
		
		printNode(resultNode);

	}
	
	private static ListNode recursiveWay(ListNode head) {
		//exit condition
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode back_head = recursiveWay(head.next);
		head.next.next = head;
		head.next = null;
		
		return back_head;
	}

	// 반복적인 방법은 3개 노드가 필요..	
	private static ListNode iterativeWay(ListNode head) {
		ListNode currNode = head.next;	//현재
		ListNode prevNode = head;		//앞
		head.next = null; 				//edge case
		
		while(currNode != null) {
			ListNode tmp 	= currNode.next;//뒤
			currNode.next 	= prevNode;
			prevNode 		= currNode;
			currNode 		= tmp;
		}
		
		return prevNode;
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
