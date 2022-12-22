package nocode.programming;

import java.util.HashMap;
import java.util.Map;

// 146. LRU Cache
// Least Recently used(���� ���� ���� ������ ĳ�ÿ��� ����)
// Least Frequently Used(���� ����� ���� ������ ĳ�ÿ��� ����)

// case : LinkedList + HashMap

//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]

// Implement 
// 1.create LRUCache
// 2.int get(int key), put(int key, int value)

public class LinkedList3 {
	static int capacity;
	static Map<Integer, Node> linkedList;
	static Node tail, head;
	
	
	public static void main(String[] args) {
		
		LinkedList3(2);
		
		String[] actions = {"put", "put", "get", "put", "get", "put", "get", "get", "get"};
		int[][] values = {{1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};
		
		LRU(actions, values);
	}

	static class Node {
		int key;
		int value;
		Node next;
		Node prev;
		
		public Node (int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
					
		}
	}
	
	public static void LinkedList3(int capacity) {
		LinkedList3.capacity = capacity;
		linkedList = new HashMap<>();
		tail = new Node(0,0);
		head = new Node(0,0);
		head.next = tail;
		tail.prev = head;
		
	}
	
	public static int del() {
		Node delete = head.next;
		
		head.next = delete.next;
		delete.next.prev = head;
		
		return delete.key;
	}
	/**
	 * HashMap���� �ʿ��� �� ������, �ش� node�� LinkedList ���� ��ġ��Ŵ
	 * @param key
	 * @return
	 */
	public static int get(int key) {
		if(linkedList.containsKey(key)) {
			moveToTail(linkedList.get(key));
			return linkedList.get(key).value;
		}else return -1;
	}
	
	/**
	 * ���� : Ű�� �����ϸ� ���� ����� �ǵڷ� �ȱ�.
	 * ���� : ĳ�� ũ�⸦ üũ�Ͽ� ĳ��ũ�Ⱑ ������ �Ǿ� ������ �� ���� �����Ͽ� �߰����ְ� 
	 * 		���� ���� ��带 LinkedList ������ ��ġ��Ŵ
	 * @param key
	 * @param value
	 */
	public static void put(int key, int value) {
		// ����
		if(linkedList.containsKey(key)) {
			linkedList.get(key).value = value;
			moveToTail(linkedList.get(key));
		// ����
		}else {
			if(linkedList.size() == capacity) {
				linkedList.remove(del());
			}
			Node node = new Node(key, value);
			linkedList.put(key, node);
			moveToTail(node);
		}
	}

	private static void moveToTail(Node node) {
		if(node.prev != null) {
			// ������ġ���� ����
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		// tail�� ��ġ 
		node.prev = tail.prev;
		node.next = tail;
		// tail ����
		tail.prev.next = node;
		tail.prev = node;
	}
	
	
	private static void LRU(String[] str, int[][] nums) {
		for (int i = 0; i < str.length; i++) {
			if(str[i].equals("put")) {
				put(nums[i][0], nums[i][1]);
				System.out.println(linkedList.toString());
			}else if(str[i].equals("get")) {
				get(nums[i][0]);
				System.out.println(linkedList.toString());
			}
			
		}
	}
	
}
