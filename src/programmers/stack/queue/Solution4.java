package programmers.stack.queue;

import java.util.LinkedList;
import java.util.Queue;

// 스택/큐 4.같은 숫자는 싫어
public class Solution4 {
	
	public int[] solution(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
                
        int value = -1;
        for (int i = 0; i < arr.length; i++) {
        	if(value != arr[i]) {
        		queue.add(arr[i]);
        		value = arr[i];
        	}
		}
       
        return queue.stream().mapToInt(i->i).toArray();
        
    }
	
	
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		
		int[] arr = {4,4,4,3,3};
		
		System.out.println(sol.solution(arr));

	}

}
