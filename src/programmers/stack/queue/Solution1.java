package programmers.stack.queue;

import java.util.ArrayList;
import java.util.List;

// ť 1.������
public class Solution1 {
	
	// Class�� ���� ����(������ �ֳ�..)
	public int solution(int[] priorities, int location) {
		
		// 1. ť����� 
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
			
			// 2. 0���� ������ max �� �ƴϸ� �ٽ� ����
			PrintJob job = printor.remove(0);
			if(printor.stream().anyMatch(otherJob -> job.priority < otherJob.priority)) {
				printor.add(job);
			}else {
				// 3. max �̸� ���� ã�� Job �� �´��� Ȯ���Ѵ�.
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
		
		// 1. ť����� 		
		List<Integer> printor = new ArrayList<Integer>();
		for (int priority : priorities) {
			printor.add(priority);
		}
		int answer = 0;			
		// 2. 0���� ������ max �� �ƴϸ� �ٽ� ����
		while(!printor.isEmpty()) {
			Integer priority = printor.remove(0);
			if(printor.stream().anyMatch(other_priority -> priority < other_priority)) {
				printor.add(priority);
			}else {
				// 3. max �̸� ���� ã�� Job �� �´��� Ȯ���Ѵ�.
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
