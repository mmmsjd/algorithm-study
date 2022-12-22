package level2;

import java.util.Stack;

// ��ȣ ȸ���ϱ�
/*
 * s�� �������� x (0 �� x < (s�� ����)) ĭ��ŭ ȸ�������� �� s�� �ùٸ� ��ȣ ���ڿ��� �ǰ� �ϴ� x�� ������ return
 * �̰Ź� ����� ����..
 * 
 */
class Ex19 {
	// �� ����
    public int solution(String s) {
    	int answer = 0;
    	// queue �� �ְ�?? <-- ������ص� �ɵ�
    	// �չ��� �߶� �ڷ� ����.. ���̸�ŭ �ݺ�
    	// ���� ��������� Ȯ��
    	// replace (){}[] []{}() �� �����غ��� ���� ���ڸ� Ȯ���Ҽ� �ֳ�..
//    	System.out.println(s);
    	
    	StringBuilder sb = new StringBuilder();
    	String[] pair = {"()", "{}", "[]",
    					"()", "[]", "{}", 
    					"{}", "()", "[]",
    					"{}", "[]", "()",
    					"[]", "{}", "()", 
    					"[]", "()", "{}"    			
    					};
    	
    	for (int i = 0; i < s.length(); i++) {
    		char tmp = s.charAt(0);
    		s = s.substring(1) + tmp;
    		String merge = s;
    		// �� �ڵ� ����
//    		if(i == 0) {
//    			sb.append(s.toCharArray());
//    		}else {
//    			sb.append(s.copyValueOf(s.toCharArray(), i, s.length()-i));        	
//    			sb.append(s.copyValueOf(s.toCharArray(), 0, i));
//    		}
    		
//    		String merge = sb.toString();
//    		sb.setLength(0);
//    		for (String compare : pair) {
//    			merge = merge.replace(compare, "");
//			}
//    		
//    		if(merge.length() == 0) answer++;
    		
    		if (pairCheck(s)) {
                answer++;
            }
    		
		}
        return answer;
    }
    
    public int solution2(String s) {
        int answer = 0;
        int size = s.length();

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(0);
            // s�� ���̸�ŭ ȸ�� 					<-- ������
            s = s.substring(1) + tmp;

            // �ùٸ� ��ȣ�̸� answer ����
            if (pairCheck(s)) {
                answer++;
            }
        }

        return answer;
    }
    
    public boolean pairCheck(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // ���� ��ȣ���̸� ���ÿ� ��´�
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // �ݴ� ��ȣ�̸� ¦�� ���� ��ȣ�� ������. ������ ���ٸ� �ùٸ��� ���� ��ȣ
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                else {
                    if (ch == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                    }
                    else if (ch == '}') {
                        if (stack.peek() == '{') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                    }
                    else {
                        if (stack.peek() == '[') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                    }
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
    
    public static void main(String[] args) {
    	Ex19 sol = new Ex19();
		
		String s = "[](){}";
		
		System.out.println(sol.solution(s));
	}
    
}