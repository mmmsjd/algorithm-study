package nocode.programming;

import java.util.HashSet;

// // 160. Intersection of Two Linked Lists

public class LinkedList5 {
	
	
	public static void main(String[] args) {
				
		ListNode node1 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node5 = new ListNode(5);
		ListNode node7 = new ListNode(7);
		ListNode node9 = new ListNode(9);
		
		node1.next = node3;
		node3.next = node5;
		node5.next = node7;
		node7.next = node9;
		
		ListNode node2 = new ListNode(2);
		node2.next = node7;
		node7.next = node9;
		
		
//		System.out.println(answer1(node1, node2).val);

//		System.out.println(answer2(node1, node2).val);
		
		System.out.println(answer3(node1, node2).val);
	}
	
	//O(n), O(n)
	private static ListNode answer3(ListNode node1, ListNode node2) {
		
		HashSet<ListNode> nodeSet = new HashSet<>();//O(n)
		
		ListNode nodeA = node1;
		ListNode nodeB = node2;
		
		while (nodeA != null) {
			nodeSet.add(nodeA);
			nodeA = nodeA.next;
		}
		
		while (nodeB != null) {
			if(nodeSet.contains((nodeB))){
				return nodeB;
			}
			nodeB = nodeB.next;
		}		
		return null;
	}

	//O(n), O(1)
	private static ListNode answer2(ListNode node1, ListNode node2) {
		ListNode nodeA = node1;
		ListNode nodeB = node2;

		while (nodeA != nodeB) {
			nodeA = nodeA != null ? nodeA.next : node1;
			nodeB = nodeB != null ? nodeB.next : node2;
		}

		return nodeA;
	}

	//O(n), O(1)
	private static ListNode answer1(ListNode headA, ListNode headB) {

		ListNode nodeA = headA;
		ListNode nodeB = headB;
		
		int lenA = getCount(nodeA);
		int lenB = getCount(nodeB);
		
		int diff = Math.abs(lenA-lenB);
		
		
		if(lenA>lenB) nodeA = resetHead(nodeA, diff);
		else if(lenA<lenB) nodeB = resetHead(nodeB, diff);
		
		while(nodeA != null) {
			if(nodeA == nodeB) {
				return nodeA;
			}
			nodeA = nodeA.next;
			nodeB = nodeB.next;
		}
		
		return null;
	}

	static int getCount(ListNode head) {
		ListNode node = head;
		int count = 0;
		while (node != null) {
			++count;
			node = node.next;
		}
		return count;
	}


	static ListNode resetHead(ListNode head, int diff){
		for (int i = 0; i < diff; i++) {
			head = head.next;
		}
        return head;
    }





	/**
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
