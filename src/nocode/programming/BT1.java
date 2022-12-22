package nocode.programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 17. letter combinations of a phone number 

// case : decision space, recursion 한 방법으로 풀이 가능
// └ 어떤 문제는 가능성이 없기 때문에 탐색에서 되돌아가 배제하고 탐색한다.

// case : dfs 를 이용한 방법 (백트래킹과 동일하네..)
// case : iterative 한 방법

public class BT1 {
	
	
	public static void main(String[] args) {
		String num = "23";//[ad, ae, af, bd, be, bf, cd, ce, cf]
						  //["ad","ae","af","bd","be","bf","cd","ce","cf"]
		
				
		System.out.println(dfs(num));
		
//		System.out.println(phonekeypad(num));
		
	}

	private static String[] iter(String num) {
		
		
		return null;
	}

	private static String[] dfs(String num) {
		// phnoe number
		hash.put(2, "abc");
		hash.put(3, "def");
		hash.put(4, "ghi");
		hash.put(5, "jkl");
		hash.put(6, "mno");
		hash.put(7, "pqrs");
		hash.put(8, "tuv");
		hash.put(9, "wxyz");
		
		len = num.length();
		int[] input = new int[len];
				
		int add = 0;
		for (char s : num.toCharArray()) {
			input[add++] = Integer.parseInt(String.valueOf(s));
		}
		
		dfs(input, "", 0);		

		System.out.println(outputArray.toString());
		String[] answer = outputArray.stream().toArray(String[]::new);
		
		return answer;
	}

	private static void dfs(int[] input, String str, int idx) {
		if(idx == input.length) {
			outputArray.add(str);
		}else {
			for (char c : hash.get(input[idx]).toCharArray()) {
				dfs(input, str+c, idx+1);
			}
		}
	}

	static HashMap<Integer, String> hash = new HashMap<Integer, String>();
	static List<String> outputArray = new ArrayList<>();
	static int len;
	
	private static String[] phonekeypad(String num) {		
		// phnoe number
		hash.put(2, "abc");
		hash.put(3, "def");
		hash.put(4, "ghi");
		hash.put(5, "jkl");
		hash.put(6, "mno");
		hash.put(7, "pqrs");
		hash.put(8, "tuv");
		hash.put(9, "wxyz");
		
		
		len = num.length();
		int[] input = new int[len];
				
		int add = 0;
		for (char s : num.toCharArray()) {
			input[add++] = Integer.parseInt(String.valueOf(s));
		}
		
		bt(input, 0, "");
		
		System.out.println(outputArray.toString());
		String[] answer = outputArray.stream().toArray(String[]::new);
		
		return answer;
	}

	private static void bt(int[] input, int idx, String letter) {
		if (idx >= len) {
			outputArray.add(letter);
			return;
		}
		
		int num = input[idx];
		String chars = hash.get(num);
		for(char ch : chars.toCharArray()) {
			bt(input, idx+1, letter + ch);
		}
		
		
	}

}
