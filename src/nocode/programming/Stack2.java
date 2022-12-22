package nocode.programming;

import java.util.Stack;

// 1047. Remove adjacent duplicates
// abbcbbcdef -> 중복제거후 리턴 adef
// stack 으로 같은 문자면 pop 한다.. 개간단.. -> O(n)

// advance 문제 
// 1209. Remove All adjacent duplicates in string 
// abbccbbbdef, k=2 -> 중복제거후 리턴 abdef
// abbccbbbdef, k=3-> 중복제거후 리턴 abbccdef

// 기본적으로 O(nk) -> 인데 스택 두개를 이용하여 비교해서 사용하면 -> O(n)
// └ 동일한 문자이면 count 를 추가하는 stack 1개 추가 (k-1)  를 만족하면 pop 수행 



public class Stack2 {

	public static void main(String[] args) {

//		int[] ints = {1,3,3,2,2,5,1};
		String strs = "abbcddde";
		int k = 3;
		
		// 확장된 문제만 풀어본다.
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
