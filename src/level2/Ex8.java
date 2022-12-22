package level2;

import java.util.Stack;

// ¦���� �����ϱ�
public class Ex8 {
	
	public int solution(String s) {
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.add(String.valueOf(s.charAt(i)));
			} else {
				String after_value = stack.peek(); // Ȯ�θ� �ϱ� ���� peek
				String before_value = String.valueOf(s.charAt(i));
				if (!after_value.equals(before_value)) { // �ٸ��ٸ� ���� ���� add 
					stack.add(before_value);
				} else {
					stack.pop(); // ���ٸ� ����
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
