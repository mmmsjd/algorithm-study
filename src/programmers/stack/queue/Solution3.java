package programmers.stack.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 스택큐 3.올바른괄호
public class Solution3 {
	
	// 스택
	boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        // 이미 틀려먹음
        if(s.startsWith(")")) return false;
        
        for (char c : s.toCharArray()) {
			if(c == '(') {
				stack.push(c);
			}else if(c ==')') {
				try {
					stack.pop();
				}catch(Exception e) {//예외가 발생하면 ( 가 없었던 것이므로 쌍이 안맞음.
					return false;
				}
			}
		}
        // 다돌았는데도 stack 이 남아있다면 쌍이 안 맞는 거임
        if(!stack.isEmpty())
        	return false;
        
        return answer;
    }
	
	// 큐
	boolean solution2(String s) {
        boolean answer = false;
        Queue<String> q = new LinkedList<>();
        // 이미 틀렸음
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
