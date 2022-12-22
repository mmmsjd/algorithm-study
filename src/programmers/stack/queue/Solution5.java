package programmers.stack.queue;

import java.util.LinkedList;
import java.util.Queue;

// 스택/큐 5.다리를 지나는 트럭(... 하 어렵다..)
public class Solution5 {
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx = 0;
        int sum = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        while(idx != truck_weights.length) {
        	if(queue.size() == bridge_length) {
        		sum -= queue.poll();
        	}else if(sum + truck_weights[idx] > weight) { //초과한 경우 
        		queue.offer(0);
        		answer++;
        	}else { 
        		queue.offer(truck_weights[idx]);
        		sum += truck_weights[idx++];
                answer++;
        	}
        }
        // 틀린답이네 ...
//        for (Integer truck : truck_weights) {
//            // 초진행
//            while (true) {
//            	if(queue.isEmpty()) {
//            		queue.offer(truck);
//            		answer++;
//            		sum += truck;//7, 11
//            	}else if(queue.size() == bridge_length) {
//            		sum -= queue.poll();
//            	}else {
//            		// 다음 트럭 sum 했는데 무게초과이면 0넣고 초진행
//            		if(truck + sum > weight) {
//            			queue.offer(0);
//            			answer++;
//            		}else{
//            			sum += truck;
//            			queue.offer(truck);
//            			answer++;
//            			break;
//            		}
//            	}
//            }
//		}
        System.out.println(queue.toString());
        return answer + bridge_length; //1+100
    }
	
	
	public static void main(String[] args) {
		Solution5 sol = new Solution5();
		
		int bridge_length = 2;
		int weight = 10;
		int[] truck = {7,4,5,6};
		
		System.out.println(sol.solution(bridge_length, weight, truck));

	}

}
