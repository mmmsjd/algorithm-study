package level2;

import java.util.Stack;

// 짝지어 제거하기
public class Ex8 {
	
	public int solution(String s) {
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.add(String.valueOf(s.charAt(i)));
			} else {
				String after_value = stack.peek(); // 확인만 하기 위해 peek
				String before_value = String.valueOf(s.charAt(i));
				if (!after_value.equals(before_value)) { // 다르다면 다음 문자 add 
					stack.add(before_value);
				} else {
					stack.pop(); // 같다면 제거
				}
			}
		}

		return stack.size() == 0 ? 1 : 0;
	}

	public static void main(String[] args) {
		Ex8 sol = new Ex8();
		
		String s = "cdcd";
		System.out.println(sol.solution(s));

	}

}
