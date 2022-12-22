package nocode.programming;

import java.util.Stack;

// 227. Basic Calculator 

// ���ڿ��� �־��� ��Ž��� ����Ͽ� �����϶�
// case : �ڿ����� Stack �� ���ö�� �Ѵ�.
// �� /* �ΰ�츦 �ľ��ؾ��Ѵ�.

// �Ͼ� ����¯����..


public class Stack5 {

	public static void main(String[] args) {

//		String strs = "3-4*2"; 		//-5
//		String strs = "3+3*2/5"; 	//4
//		String strs = "7-6/3+3*2+4";//15		
		String strs = "7-65/25+34*2+100";//172

		System.out.println(Calc(strs));

	}

	private static int Calc(String strs) {
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		
		
		int idx = 0;
		char oper = 0;
		
		while (idx < strs.length()) {
			
			if(Character.isDigit(strs.charAt(idx))) {
				int sub = idx;				
				while (Character.isDigit(strs.charAt(sub))) {
					result.append(strs.charAt(sub));
					sub++;
					//idx++;
				}
				stack.add(Integer.parseInt(result.toString()));
				result.setLength(0);
		        
			}else {				
				if('/'== strs.charAt(idx)) {
					oper = strs.charAt(idx);
				}else if('*'== strs.charAt(idx)) {
					oper = strs.charAt(idx);
				}else if('-'== strs.charAt(idx)) {
					oper = strs.charAt(idx);
				}else {
					oper = strs.charAt(idx);
				}
				idx++;
				continue;
				
			}
			// ��� �ϰ�� ++ �����ش�? 
			if(oper == '-') {
				int prev = stack.pop();
				int n = -prev;				
				stack.add(n);
				oper = 0;
				
			}else if(oper == '/') {
				int next = stack.pop();
				int prev = stack.pop();
				stack.add(prev / next);
				oper = 0;
				
			}else if(oper == '*') {
				int next = stack.pop();
				int prev = stack.pop();
				stack.add(prev * next);
				oper = 0;
			}
			idx++;
		}
		
		int sum = 0;
		for(Integer i : stack) {
			sum +=i;
		}
		
		return sum;
		
	}
	

}
