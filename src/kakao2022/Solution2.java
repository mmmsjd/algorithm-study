package kakao2022;

import java.util.LinkedList;
import java.util.Queue;

// �� ť �� ���� �����
/*
���̰� ���� �� ���� ť�� �־����ϴ�. �ϳ��� ť�� ��� ���Ҹ� ����(pop)�ϰ�, ����� ���Ҹ� �ٸ� ť�� ����ִ�(insert) 
�۾��� ���� �� ť�� ���� ���� ������ ������� �մϴ�. �̶� �ʿ��� �۾��� �ּ� Ƚ���� ���ϰ��� �մϴ�. 
�� ���� pop�� �� ���� insert�� ���ļ� �۾��� 1ȸ ������ ������ �����մϴ�.

ť�� ���� ������� ���Ұ� ���� ������ �����Դϴ�. �� ���������� ť�� �迭�� ǥ���ϸ�, 
���Ұ� �迭 ���ʿ� �������� ���� ������� �������� �ǹ��մϴ�. ��, pop�� �ϸ� �迭�� ù ��° ���Ұ� ����Ǹ�, 
insert�� �ϸ� �迭�� ���� ���Ұ� �߰��˴ϴ�. ���� ��� ť [1, 2, 3, 4]�� �־����� ��, 
pop�� �ϸ� �� �տ� �ִ� ���� 1�� ����Ǿ� [2, 3, 4]�� �Ǹ�, �̾ 5�� insert�ϸ� [2, 3, 4, 5]�� �˴ϴ�.

������ �� ť�� ��Ÿ���� �����Դϴ�.

queue1 = [3, 2, 7, 2]
queue2 = [4, 6, 5, 1]
�� ť�� ��� ��� ������ ���� 30�Դϴ�. ����, �� ť�� ���� 15�� ������ �մϴ�. ���� ���, ������ ���� 2���� ����� �ֽ��ϴ�.

queue2�� 4, 6, 5�� ������� �����Ͽ� queue1�� �߰��� ��, queue1�� 3, 2, 7, 2�� ������� �����Ͽ� queue2�� �߰��մϴ�. 
�� ��� queue1�� [4, 6, 5], queue2�� [1, 3, 2, 7, 2]�� �Ǹ�, �� ť�� ���� ���� 15�� �����ϴ�. �� ����� �۾��� 7�� �����մϴ�.

queue1���� 3�� �����Ͽ� queue2�� �߰��մϴ�. �׸��� queue2���� 4�� �����Ͽ� queue1�� �߰��մϴ�. 
�� ��� queue1�� [2, 7, 2, 4], queue2�� [6, 5, 1, 3]�� �Ǹ�, �� ť�� ���� ���� 15�� �����ϴ�. �� ����� �۾��� 2���� �����ϸ�, �̺��� ���� Ƚ���� ��ǥ�� �޼��� �� �����ϴ�.
���� �� ť�� ���� ���� ���� ����� ���� �ʿ��� �۾��� �ּ� Ƚ���� 2�Դϴ�.

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
