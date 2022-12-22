package kakao2022;

import java.util.LinkedList;
import java.util.Queue;

// 두 큐 합 같게 만들기
/*
길이가 같은 두 개의 큐가 주어집니다. 하나의 큐를 골라 원소를 추출(pop)하고, 추출된 원소를 다른 큐에 집어넣는(insert) 
작업을 통해 각 큐의 원소 합이 같도록 만들려고 합니다. 이때 필요한 작업의 최소 횟수를 구하고자 합니다. 
한 번의 pop과 한 번의 insert를 합쳐서 작업을 1회 수행한 것으로 간주합니다.

큐는 먼저 집어넣은 원소가 먼저 나오는 구조입니다. 이 문제에서는 큐를 배열로 표현하며, 
원소가 배열 앞쪽에 있을수록 먼저 집어넣은 원소임을 의미합니다. 즉, pop을 하면 배열의 첫 번째 원소가 추출되며, 
insert를 하면 배열의 끝에 원소가 추가됩니다. 예를 들어 큐 [1, 2, 3, 4]가 주어졌을 때, 
pop을 하면 맨 앞에 있는 원소 1이 추출되어 [2, 3, 4]가 되며, 이어서 5를 insert하면 [2, 3, 4, 5]가 됩니다.

다음은 두 큐를 나타내는 예시입니다.

queue1 = [3, 2, 7, 2]
queue2 = [4, 6, 5, 1]
두 큐에 담긴 모든 원소의 합은 30입니다. 따라서, 각 큐의 합을 15로 만들어야 합니다. 예를 들어, 다음과 같이 2가지 방법이 있습니다.

queue2의 4, 6, 5를 순서대로 추출하여 queue1에 추가한 뒤, queue1의 3, 2, 7, 2를 순서대로 추출하여 queue2에 추가합니다. 
그 결과 queue1은 [4, 6, 5], queue2는 [1, 3, 2, 7, 2]가 되며, 각 큐의 원소 합은 15로 같습니다. 이 방법은 작업을 7번 수행합니다.

queue1에서 3을 추출하여 queue2에 추가합니다. 그리고 queue2에서 4를 추출하여 queue1에 추가합니다. 
그 결과 queue1은 [2, 7, 2, 4], queue2는 [6, 5, 1, 3]가 되며, 각 큐의 원소 합은 15로 같습니다. 이 방법은 작업을 2번만 수행하며, 이보다 적은 횟수로 목표를 달성할 수 없습니다.
따라서 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수는 2입니다.

 */
public class Solution2 {
	
	public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i : queue1) {
        	sum1 += i;
        	q1.add(i);
		}
        for (int i : queue2) {		
        	sum2 += i;
        	q2.add(i);
		}
        
        int idx1 = 0, idx2 = 0;
        int maxIdx = q1.size() + q2.size();        
        int answer = 0;        
        
        if( sum1 + sum2 % 2 == 0)
        	return -1;
                  
        while (idx1 < maxIdx && idx2 < maxIdx){
                  
        	if( sum1 == sum2 ) return answer;        
        	answer++;        
        	
            if (sum1 < sum2){
            	
                int current = q2.poll();                        
                q1.add(current);        
                
                sum1 += current;          
                sum2 -= current;        
                idx2++;        
            }else{
            	
                int current = q1.poll();        
                q2.add(current);     
                
                sum2 += current;       
                sum1 -= current;  
                idx1++;      
            }
        }
                  
        return -1;
    }

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		
		int[] queue1 = {3, 2, 7, 2};
		int[] queue2 = {4, 6, 5, 1};
		
		System.out.println(sol.solution(queue1, queue2));
	}

}
