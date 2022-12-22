package nocode.programming;

import java.util.Stack;

// 394. Decode String
// 괄호는 Stack 이다..
// 숫자, 과

// case : stack 두개를 이용 
// └ 반복 처리할 문자열을 모아두고 이전문자 뒤에 append 하는 게 중요!!


public class Stack4 {

	public static void main(String[] args) {

//		String strs = "a2[b2[ak]]";
//		String strs = "3[a]2[bc]";
//		String strs = "3[a2[c]]";
		String strs = "23[a100[def]42[b]]";
		

		System.out.println(Decode(strs));

	}

	private static String Decode(String strs) {
		StringBuilder result = new StringBuilder();
		StringBuilder nums = new StringBuilder();
		
		Stack<String> string = new Stack<>();
		Stack<Integer> count = new Stack<>();
		
		
		int point = 0;
		while(point < strs.length()) {
			char ch = strs.charAt(point);
						
			if(Character.isDigit(ch)) {
				nums.append(ch);
				point++;
				
			}else if('['== ch) {
				count.add(Integer.parseInt(nums.toString()));
				string.add(result.toString());
				nums.setLength(0);
				result.setLength(0);
				point++;
				
			}else if(']' == ch) {
				int loop = count.pop();
				StringBuilder tmp = new StringBuilder(string.pop());
				for (int i = 0; i < loop; i++) {
					tmp.append(result);
				}	
				result = new StringBuilder(tmp.toString());
				point++;
			}else {
				result.append(ch);
				point++;
			}
			
		}
		
		return result.toString();
		
	}
	

}
