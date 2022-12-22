package nocode.programming;

import java.util.Stack;

// 1047. Remove adjacent duplicates
// abbcbbcdef -> �ߺ������� ���� adef
// stack ���� ���� ���ڸ� pop �Ѵ�.. ������.. -> O(n)

// advance ���� 
// 1209. Remove All adjacent duplicates in string 
// abbccbbbdef, k=2 -> �ߺ������� ���� abdef
// abbccbbbdef, k=3-> �ߺ������� ���� abbccdef

// �⺻������ O(nk) -> �ε� ���� �ΰ��� �̿��Ͽ� ���ؼ� ����ϸ� -> O(n)
// �� ������ �����̸� count �� �߰��ϴ� stack 1�� �߰� (k-1)  �� �����ϸ� pop ���� 



public class Stack2 {

	public static void main(String[] args) {

//		int[] ints = {1,3,3,2,2,5,1};
		String strs = "abbcddde";
		int k = 3;
		
		// Ȯ��� ������ Ǯ���.
		System.out.println(maxStack(strs, k));

	}

	private static String maxStack(String strs, int k) {
		String answer = "";
		// abbcddde, k=3;
		Stack<String> sstack = new Stack<>();
		Stack<Integer> istack = new Stack<>();
		
		int idx = 0;
		while(idx <= strs.length()-1) {
						
			if(idx == 0) {
				sstack.push(String.valueOf(strs.charAt(idx)));
				istack.push(1);
				idx++;
				continue;
			}
			
			if(sstack.peek().equals(String.valueOf(strs.charAt(idx)))) {
				sstack.push(String.valueOf(strs.charAt(idx)));
				istack.push(istack.pop() + 1);
			}else {
				sstack.push(String.valueOf(strs.charAt(idx)));
				istack.push(1);
			}

			int remove = istack.peek();
			if(remove > k-1) {
				for (int i = 0; i < remove; i++) {
					sstack.pop();
				}
			}
			idx++;
			
		}
//		System.out.println(sstack.toString());
//		System.out.println(istack.toString());
		
		StringBuilder sb = new StringBuilder();
		
		for(String result : sstack){
			sb.append(result);
		}
		
		return answer = sb.toString();
		
	}
	

}
