package programmers.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 힙 2.디스크 컨트롤러 ...하 어렵구만
// 이문제는 우선순위 큐에 클래스 타입 사용을 위한 문제처럼 보임

public class Solution2 {
	
	public int solution(int[][] jobs) {	
        int answer = 0;
        
    	// 1. 운선순위 큐
    	PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>();
    	
        return answer;
    }
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		
		int[][] array = {{0, 3}, {1, 9}, {2, 6}};		
		System.out.println(sol.solution2(array));

	}
	
	public int solution2(int[][] jobs) {	
   

		// 1차원 배열만 고려하여 정렬
//		Arrays.sort(jobs, Comparator.comparingInt(o1 -> o1[0]));
		
		// 2차원 배열도 고려하여 정렬
		Arrays.sort(jobs, (o1, o2) -> {
				if (o1[0] == o2[0])
					return Integer.compare(o1[1], o2[1]);
				else
					return Integer.compare(o1[0], o2[0]);
		});
		
		int jobIdx = 0;				
		int time = 0;				// 현재까지 지난 시간
		int totalRuntime = 0;		// 총 runtime
		int endJob = 0;				
		
		// 소요 시간에 대해 정렬하는 PriorityQueue
		PriorityQueue<Job> queue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);//0..6..9..
		
		while (endJob < jobs.length) {
			// queue에 들어갈 job이 있으면 queue에 삽입
			for (int i = jobIdx; i < jobs.length; i++) {
				if (jobs[i][0] <= time) {
					queue.add(new Job(jobs[jobIdx][0], jobs[jobIdx][1]));
					jobIdx++;
				}
				else
					break;
			}
			
			// 대기열이 비어있으면 가장 먼저 도착하는 작업 우선 할당
			if (queue.isEmpty()) {
				queue.add(new Job(jobs[jobIdx][0], jobs[jobIdx][1]));
				time = jobs[jobIdx++][0];
			}
			
			// 실행시간이 제일 짧은 작업 실행
			Job shortTimeJob = queue.poll();
			
			// 총 런타임 시간 합산
			totalRuntime += shortTimeJob.getTotalRuntime(time);
			time += shortTimeJob.time;
			
			
			endJob++;
		}
		
	    return totalRuntime/jobs.length;
	}
	
	class Job {		
		int start;	//현재작업 시작시간
		int time;	//현재작업 소요시간
		
		Job(int start, int time) {
			this.start = start;
			this.time = time;
		}
		int getTotalRuntime(int curr) {
			return (curr + time) - start; //(누적시간 - 현재작업 소요시간)-현재작업 시작시간
		}
	}

}
