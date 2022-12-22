package level2;

import java.util.Stack;

// 괄호 회전하기
/*
 * s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return
 * 이거뭐 쉬운게 없네..
 * 
 */
class Ex19 {
	// 하 ㅆㅂ
    public int solution(String s) {
    	int answer = 0;
    	// queue 에 넣고?? <-- 사용한해도 될듯
    	// 앞문자 잘라서 뒤로 붙임.. 길이만큼 반복
    	// 쌍이 제대로인지 확인
    	// replace (){}[] []{}() 를 실행해보면 남은 문자를 확인할수 있네..
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
    		// 내 코드 ㅆㅂ
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
            // s의 길이만큼 회전 					<-- 개간단
            s = s.substring(1) + tmp;

            // 올바른 괄호이면 answer 증가
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

            // 여는 괄호들이면 스택에 담는다
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // 닫는 괄호이면 짝인 여는 괄호를 빼낸다. 빼낼수 없다면 올바르지 않은 괄호
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