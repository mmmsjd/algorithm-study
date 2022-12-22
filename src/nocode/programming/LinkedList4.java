package nocode.programming;

import java.util.HashSet;

import nocode.programming.LinkedList5.ListNode;

// 141. Linked List Cycle 
// 주어진 LinkedList에 cycle이 있는지 확인하여라.
// fast and slow node : 공간복잡도를 O(1) 으로 풀어달라면 방법적으로 좋네..

public class LinkedList4 {
	
	
	public static void main(String[] args) {
		
		//1,2,3,4,5,6,2		//true		
		//1,2,3,4,5,6		//false
				
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node2;
		
		
		System.out.println(CycleCheckLoop(node1));		
		System.out.println(CycleCheckFastSlow(node1));
	}
	
	private static boolean CycleCheckFastSlow(ListNode list) {

		ListNode slow = list;
		ListNode fast = list;
		
		while(fast != null) {
			slow = slow.next;
			fast = fast.next.next;
//			System.out.println(fast.val +" "+ slow.val);
			if(fast == slow) {
				return true;
			}
		}
		
		return false;
	}

	private static boolean CycleCheckLoop(ListNode list) {
		HashSet<Integer> nodeSet = new HashSet<>();
		
		ListNode current = list;
		
		while(current != null) {
			if(nodeSet.contains(current.val)) {
				return true;
			}
			nodeSet.add(current.val);
			current = current.next;
			
		}
		return false;		
		
	}


	/**
	 * Definition for singly-linked list.
	 */
	static public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	
	
}
