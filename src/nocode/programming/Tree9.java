package nocode.programming;

import java.util.HashMap;
import java.util.Map;

// 208. implement Trie(Prefix Tree)
// 211. Design Add and Search Words Data Structrue(응용문제)


// Trie(동적 집합)
// 공통된 알파벳을 묶은 방식의 문자열 트리 
// ex) ["baby", "ball", "tree", "trie"]
/*
	  r
	b   t
	a   r
   b l e i
   y l e e
 */

// case : array 
// case : hashmap 




public class Tree9 {
	
	// Array
	static int BUFFER_LENGTH = 26;
	static Node root;
	
	// HashMap
	static Trie rrr;
	
	
	
	public Tree9() {
		root = new Node();
		rrr = new Trie();
		
	}

	public static void main(String[] args) {
		Tree9 tree = new Tree9();
		
		//["baby", "ball", "tree", "trie"]
		
//		tree.add("baby");
//		tree.add("ball");
//		tree.add("tree");
//		tree.add("trie");
//		
//		System.out.println(tree.search("baby"));		//true
//		System.out.println(tree.search("ba"));			//false
//		System.out.println(tree.search("nocope"));		//false
//		
//		System.out.println(tree.startsWith("bab"));		//true
//		System.out.println(tree.startsWith("trr"));		//false
		
		Tree9 trie = new Tree9();
		
		trie.add2("baby");
		trie.add2("ball");
		trie.add2("tree");
		trie.add2("trie");
		
		System.out.println(trie.search2("baby"));		//true
		System.out.println(trie.search2("ba"));			//false
		System.out.println(trie.search2("nocope"));		//false
		
		System.out.println(trie.startsWith2("bab"));		//true
		System.out.println(trie.startsWith2("trr"));		//false
		
		
		
	}
	//============================================================
	//HashMap Start
	//============================================================	
	
	private boolean startsWith2(String prefix) {
		Trie node = rrr;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (!node.map.containsKey(c)) {
				return false;
			}
			node = node.map.get(c);
		}
		return true;
	}

	private boolean search2(String word) {
		Trie node = rrr;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!node.map.containsKey(c)) {
				return false;
			}
			node = node.map.get(c);
		}
		return node.isEnd;
	}

	private void add2(String word) {
		Trie node = rrr;
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!node.map.containsKey(c)) {
				node.map.put(c, new Trie());
			}
			node = node.map.get(c);
		}
		node.isEnd = true;
		
		
	}
	static class Trie {
		Map<Character, Trie> map;
		boolean isEnd;
		
		public Trie() {
			map = new HashMap<>();
		}
	}
	//============================================================
	//HashMap End
	//============================================================	
	
	//============================================================
	//Array Start
	//============================================================	
	private boolean startsWith(String prefix) {
		Node curr = root;
		int len = prefix.length();
		
		for (int i = 0; i < len; i++) {
			int currIdx = prefix.charAt(i) - 'a';
			if(curr.next[currIdx] == null) {
				return false;
			}
			curr = curr.next[currIdx];
		}
		
		return true;		
	}



	private boolean search(String word) {
		Node curr = root;
		int len = word.length();
		
		for (int i = 0; i < len; i++) {
			int currIdx = word.charAt(i) - 'a';
			if(curr.next[currIdx] == null) {
				return false;
			}
			curr = curr.next[currIdx];
		}
		
		return curr.isEnd ? true : false;
	}



	private void add(String word) {
		if(word.length() == 0){
			return;
		}
		recurAdd(root, word);
		
	}

	private void recurAdd(Node curr, String word) {
		int len = word.length();
		if(len == 0){
			curr.isEnd = true;
			return;
		}
		for (int i = 0; i < len; i++) {
			int currIdx = word.charAt(i) - 'a';
			if(curr.next[currIdx] == null) {
				curr.next[currIdx] = new Node();
			}
			curr = curr.next[currIdx];
		}
		curr.isEnd = true;
		
	}

	static class Node {
		Node[] next;
		boolean isEnd;
		
		public Node() {
			next = new Node[BUFFER_LENGTH];
		}
	}
	//============================================================
	//Array End
	//============================================================	
	
}
