package nocode.programming;

// 876. Middle of the Linked List

// case : iterative 				-> O(n)/O(n)
// case : array 를 이용하는 방법	-> O(n)/O(n)
// case : one pass iteration		-> O(n)/O(1)
// └ Fast & Slow Pointer 방법

public class LinkedList1 {
	
	
	public static void main(String[] args) {
		
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		
		ListNode result = slow(list1);
		
		while(result.next != null) {
			System.out.print(result.val+" ");
			result = result.next;
		}
		
	}

	private static ListNode slow(ListNode list1) {
		ListNode slowNode = list1;
		ListNode fastNode = list1;
		
		while(fastNode != null) {
	
			if(fastNode.next != null) {
				slowNode = slowNode.next;
				fastNode = fastNode.next.next;
			}else {
				break;
			}

		}
		
		return slowNode;
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
