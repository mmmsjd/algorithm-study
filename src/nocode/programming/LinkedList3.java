package nocode.programming;

import java.util.HashMap;
import java.util.Map;

// 146. LRU Cache
// Least Recently used(가장 과거 사용된 내용을 캐시에서 삭제)
// Least Frequently Used(가장 사용이 덜된 내용을 캐시에서 삭제)

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
	 * HashMap으로 필요한 값 가져옴, 해당 node를 LinkedList 끝에 위치시킴
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
	 * 갱신 : 키가 존재하면 값을 변경우 맨뒤로 옴김.
	 * 삽입 : 캐시 크기를 체크하여 캐시크기가 같으면 맨앞 노드삭제 후 새로 생성하여 추가해주고 
	 * 		새로 만든 노드를 LinkedList 끝으로 위치시킴
	 * @param key
	 * @param value
	 */
	public static void put(int key, int value) {
		// 갱신
		if(linkedList.containsKey(key)) {
			linkedList.get(key).value = value;
			moveToTail(linkedList.get(key));
		// 삽입
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
			// 기존위치에서 삭제
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		// tail에 위치 
		node.prev = tail.prev;
		node.next = tail;
		// tail 갱신
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
