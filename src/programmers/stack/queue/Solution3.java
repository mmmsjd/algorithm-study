package programmers.stack.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// ����ť 3.�ùٸ���ȣ
public class Solution3 {
	
	// ����
	boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        // �̹� Ʋ������
        if(s.startsWith(")")) return false;
        
        for (char c : s.toCharArray()) {
			if(c == '(') {
				stack.push(c);
			}else if(c ==')') {
				try {
					stack.pop();
				}catch(Exception e) {//���ܰ� �߻��ϸ� ( �� ������ ���̹Ƿ� ���� �ȸ���.
					return false;
				}
			}
		}
        // �ٵ��Ҵµ��� stack �� �����ִٸ� ���� �� �´� ����
        if(!stack.isEmpty())
        	return false;
        
        return answer;
    }
	
	// ť
	boolean solution2(String s) {
        boolean answer = false;
        Queue<String> q = new LinkedList<>();
        // �̹� Ʋ����
        if(s.startsWith(")")) return false;
        for (char c : s.toCharArray()) {
        	if(c == '(') {
        		q.offer("(");
        	}else{
        		q.offer(")");
        	}
		}
        int cnt = 0;
        for (String sss : q) {
        	if(sss =="(") {
        		cnt++;
        	}else if(sss ==")") {
        		cnt--;
        	}
			if(cnt < 0) {
				break;
			}
		}        
        if(cnt == 0) answer = true;
        
        return answer;
    }

	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		
//		String s = "(())";	//true
//		String s = "(())()";//true
//		String s = ")()(";	//false
//		String s = "(()(";	//false
		String s = "()))))((((()()";	//false
		
		System.out.println(sol.solution2(s));

	}

}
