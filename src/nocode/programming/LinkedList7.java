package nocode.programming;

// 2. Add Two Numbers
// 445. Add Two Numbers(reverse)
// 반대방향으로 더해라
// 7->5->3 == 357
// 4->8->2 == 284+
//			  641
// 1->4->6

// case :  carry Node 가 필요.

public class LinkedList7 {
	
	
	public static void main(String[] args) {
				
		ListNode head1 = new ListNode(7);
		ListNode node5= new ListNode(5);
		ListNode node3 = new ListNode(3);
		
		head1.next = node5;
		node5.next = node3;
		
		ListNode head2 = new ListNode(4);
		ListNode node8 = new ListNode(8);
		ListNode node2 = new ListNode(2);
		
		head2.next = node8;
		node8.next = node2;
		
		printNode(head1);		
		printNode(head2);		
		
		// 역방향
//		ListNode resultNode = reverse(head1, head2);
		
		// 정방향
		ListNode resultNode = forward(head1, head2);
		
		printNode(resultNode);

	}
	
	private static ListNode forward(ListNode head1, ListNode head2) {
		ListNode reverse1 = reverseList(head1);
		ListNode reverse2 = reverseList(head2);
		
		ListNode reverseSum = reverse(reverse1, reverse2);
		
		return reverseList(reverseSum);
	}

	private static ListNode reverseList(ListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		ListNode currNode = head.next;	// 다음노드 -> 현재
		ListNode prevNode = head;		// 현재노드 -> 이전
		head.next = null;
		
		while(currNode != null) {
			ListNode tmp = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = tmp;
		}
		
		return prevNode;
	}

	// 7->5->3 == 357
	// 4->8->2 == 284+
	//			  641
	// 1->4->6
	private static ListNode reverse(ListNode head1, ListNode head2) {
		
		ListNode dummyNode = new ListNode(-1);
		ListNode currNode = dummyNode;
		int a = 0;
		int b = 0;
		int carry = 0;
		int val = 0;
		
		while(head1 != null && head2 != null) {
			a = head1.val;
			b = head2.val;			
			int sum_ab = a + b + carry;
			
			carry 	= sum_ab / 10;
			val 	= sum_ab % 10;
			
//			System.out.print(carry);
//			System.out.print(" ");
//			System.out.print(val);
//			System.out.println(" ");
			
			ListNode newNode = new ListNode(val);
			currNode.next = newNode;
			currNode = currNode.next;
			
			head1 = head1.next;
			head2 = head2.next;
			
		}
		if(carry == 1) {
			ListNode newNode = new ListNode(carry);
			currNode.next = newNode;
		}
		
		return dummyNode.next;
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
