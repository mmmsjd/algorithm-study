package programmers.stack.queue;

import java.util.ArrayList;
import java.util.List;

// 큐 1.프린터
public class Solution1 {
	
	// Class를 통한 구현(오류가 있네..)
	public int solution(int[] priorities, int location) {
		
		// 1. 큐만들기 
		List<PrintJob> printor = new ArrayList<PrintJob>();
		for (int i = 0; i < priorities.length; i++) {
			printor.add(new PrintJob(priorities[i], i));
		}
		int answer = 0;
		while(!printor.isEmpty()) {
			
			// debug
			for (PrintJob printJob : printor) {
				System.out.print(printJob.loc+"|");
			}
			System.out.println();
			
			// 2. 0번을 꺼내서 max 가 아니면 다시 넣음
			PrintJob job = printor.remove(0);
			if(printor.stream().anyMatch(otherJob -> job.priority < otherJob.priority)) {
				printor.add(job);
			}else {
				// 3. max 이면 내가 찾는 Job 이 맞는지 확인한다.
				answer++;
				if(location == job.loc) 
					break;
			}
		}
		
        return answer;
    }
	
	class PrintJob{
		int priority;
		int loc;
		
		public PrintJob(int priority, int loc) {
			this.priority = priority;
			this.loc = loc;
		}
		
	}
	public int solution2(int[] priorities, int location) {
		
		// 1. 큐만들기 		
		List<Integer> printor = new ArrayList<Integer>();
		for (int priority : priorities) {
			printor.add(priority);
		}
		int answer = 0;			
		// 2. 0번을 꺼내서 max 가 아니면 다시 넣음
		while(!printor.isEmpty()) {
			Integer priority = printor.remove(0);
			if(printor.stream().anyMatch(other_priority -> priority < other_priority)) {
				printor.add(priority);
			}else {
				// 3. max 이면 내가 찾는 Job 이 맞는지 확인한다.
				answer++;
				if(location == 0)
					break;
			}
			location--;
			if(location < 0) {
				location = printor.size() -1;
			}
		}
        return answer;
    }

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		
		
		System.out.println(sol.solution2(priorities, location));

	}

}
