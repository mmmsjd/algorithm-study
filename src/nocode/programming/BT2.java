package nocode.programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 78. Subsets


public class BT2 {
	
	
	public static void main(String[] args) {
		String[] num = {"a", "b", "c"};		
				
//		System.out.println(subsets(num));
		
		System.out.println(stack(num));
		
	}

	static class SubSet {
		int level;
		String value;
		public SubSet(int level, String value) {
			this.level = level;
			this.value = value;
		}
	}
	
	private static String[] stack(String[] num) {
		
		List<String> list = new ArrayList<>();
		Stack<SubSet> stack = new Stack<>();
		stack.push(new SubSet(0, ""));
		
		while(!stack.isEmpty()) {
			SubSet subset = stack.pop();
			int 	level	= subset.level;
			String 	letter 	= subset.value;
			
			if(level == num.length) {
				list.add(letter);
				continue;
			}
			String str = num[level];
			stack.push(new SubSet(level+1, letter));
			stack.push(new SubSet(level+1, letter + str));
		}
		
		System.out.println(list.toString());
		return list.stream().toArray(String[]::new);
	}

	private static String[] subsets(String[] num) {
		List<String> list = new ArrayList<>();
		bt(num, 0, "", list);
		
		String[] answer = list.stream().toArray(String[]::new);
		
		System.out.println(list.toString());
		return answer;
	}

	private static void bt(String[] num, int idx, String letter, List<String> list) {
	
		System.out.println(idx + ": " +letter);
		if(idx == num.length) {
			list.add(letter);
			return;
		}
		
		String str = num[idx];
		bt(num, idx+1, letter + str, list);// 함수 스택!!!!
		bt(num, idx+1, letter, list);
		
	}

}
