package nocode.programming;

import java.util.LinkedList;

// 21. Merge Two Sorted List

// dummy node

public class LinkedList2 {
	
	
	public static void main(String[] args) {
		
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		
//		ListNode result = MergreSort(list1, list2);
		
		ListNode result = recursiveSort(list1, list2);
		
		while(result.next != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}

	private static ListNode recursiveSort(ListNode list1, ListNode list2) {
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		
		if(list1.val < list2.val) {
			list1.next = recursiveSort(list1.next, list2);
			return list1;
		}else {
			list2.next = recursiveSort(list2.next, list1);
			return list2;
		}
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
	 
	private static ListNode MergreSort(ListNode list1, ListNode list2) {
		
		ListNode merge = new ListNode();
		ListNode dummy = merge;
		
		while(list1 != null && list2 != null) {
			if(list1.val >= list2.val) {
				dummy.next = list2;
				list2 = list2.next;
			}else {
				dummy.next = list1;
				list1 = list1.next;
			}
			dummy = dummy.next;
		}
		
		if(list1 == null) dummy.next = list2;
		if(list2 == null) dummy.next = list1;
		
		
		return merge.next;
		
	}


}
