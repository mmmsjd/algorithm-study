package programmers.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// �� 2.��ũ ��Ʈ�ѷ� ...�� ��Ʊ���
// �̹����� �켱���� ť�� Ŭ���� Ÿ�� ����� ���� ����ó�� ����

public class Solution2 {
	
	public int solution(int[][] jobs) {	
        int answer = 0;
        
    	// 1. ����� ť
    	PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>();
    	
        return answer;
    }
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		
		int[][] array = {{0, 3}, {1, 9}, {2, 6}};		
		System.out.println(sol.solution2(array));

	}
	
	public int solution2(int[][] jobs) {	
   

		// 1���� �迭�� ����Ͽ� ����
//		Arrays.sort(jobs, Comparator.comparingInt(o1 -> o1[0]));
		
		// 2���� �迭�� ����Ͽ� ����
		Arrays.sort(jobs, (o1, o2) -> {
				if (o1[0] == o2[0])
					return Integer.compare(o1[1], o2[1]);
				else
					return Integer.compare(o1[0], o2[0]);
		});
		
		int jobIdx = 0;				
		int time = 0;				// ������� ���� �ð�
		int totalRuntime = 0;		// �� runtime
		int endJob = 0;				
		
		// �ҿ� �ð��� ���� �����ϴ� PriorityQueue
		PriorityQueue<Job> queue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);//0..6..9..
		
		while (endJob < jobs.length) {
			// queue�� �� job�� ������ queue�� ����
			for (int i = jobIdx; i < jobs.length; i++) {
				if (jobs[i][0] <= time) {
					queue.add(new Job(jobs[jobIdx][0], jobs[jobIdx][1]));
					jobIdx++;
				}
				else
					break;
			}
			
			// ��⿭�� ��������� ���� ���� �����ϴ� �۾� �켱 �Ҵ�
			if (queue.isEmpty()) {
				queue.add(new Job(jobs[jobIdx][0], jobs[jobIdx][1]));
				time = jobs[jobIdx++][0];
			}
			
			// ����ð��� ���� ª�� �۾� ����
			Job shortTimeJob = queue.poll();
			
			// �� ��Ÿ�� �ð� �ջ�
			totalRuntime += shortTimeJob.getTotalRuntime(time);
			time += shortTimeJob.time;
			
			
			endJob++;
		}
		
	    return totalRuntime/jobs.length;
	}
	
	class Job {		
		int start;	//�����۾� ���۽ð�
		int time;	//�����۾� �ҿ�ð�
		
		Job(int start, int time) {
			this.start = start;
			this.time = time;
		}
		int getTotalRuntime(int curr) {
			return (curr + time) - start; //(�����ð� - �����۾� �ҿ�ð�)-�����۾� ���۽ð�
		}
	}

}
