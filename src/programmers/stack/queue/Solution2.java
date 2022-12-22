package programmers.stack.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 큐 2.기능개발
public class Solution2 {
	
	 public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<Integer>();
        
        for (int i = 0; i < progresses.length; i++) {
//        1.한기능을 개발하는데 필요한 날짜계산
			double days = (100 - progresses[i]) / (double) speeds[i];
			
			int dayUp = (int) Math.ceil(days);
			System.out.println(dayUp);
//        2.함께 배포할 기능계산
			int j = i +1;
			for (; j < progresses.length; j++) {
				if(progresses[j] + dayUp * speeds[j] < 100) {
					break;
				}
			}
//        3.배포할 개수 개산하고 반복
			answer.add(j-i);
			i=j-1;
			
		}      
        return answer.stream().mapToInt(mapper -> mapper.intValue()).toArray();
	 }
	
	 
	 public int[] solution2(int[] progresses, int[] speeds) {
	        int[] answer = {};
	        int[] dayArr = new int[progresses.length];
	        ArrayList<Integer> answerList = new ArrayList<>();

	        // 1.개발에 필요한 날짜를 계산 해서 큐에 저장 
	        for(int i=0; i<progresses.length; i++) {
	            int pgs = 100 - progresses[i];
	            int day = pgs/speeds[i] + (pgs%speeds[i] > 0 ? 1: 0);
	            dayArr[i] = day;
	        }
	        Queue<Integer> queue = new LinkedList<>();
	        queue.add(dayArr[0]);

	        for(int i=1; i<dayArr.length; i++) {
	            int target = dayArr[i];
	            if(target <= queue.peek()) {
	                queue.add(target);
	            }else {
	                int cnt = 0;
	                while(!queue.isEmpty()) {
	                    queue.poll();
	                    cnt++;
	                }
	                answerList.add(cnt);

	                queue.add(target);
	            }
	        }

	        if(!queue.isEmpty()) {
	            int cnt = 0;
	            while(!queue.isEmpty()) {
	                queue.poll();
	                cnt++;
	            }
	            answerList.add(cnt);
	        }

	        answer = new int[answerList.size()];
	        for(int i=0; i<answer.length; i++) {
	            answer[i] = answerList.get(i);
	        }

	        return answer;
    }
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		
		int[] prog = {93, 30, 55};
		int[] speed= {1, 30, 5};
		
		
		System.out.println(sol.solution2(prog, speed));

	}

}
