package programmers.binary.search;

import java.util.Arrays;

// �̺�Ž��(����Ž��) 2.¡�˴ٸ�(..�� ��Ƴ� )
public class Solution2todo {
	
	public int solution(int distance, int[] rocks, int n) {
//		�������� ���� �ٸ� �ٸ��� ������ �� �־���ϴ� �� ����. 
//		���������� ���� n�� ��ŭ ������ �� ������, ����, �� ���̿� �Ÿ� �� �ּڰ� �߿� �ִ��� ���϶�� �Ѵ�. 
//		���� �ٸ� �ݴ�� �����Ͽ� n���� ���� ���ּ� �� ���� �Ÿ��� �ּڰ��� x�� ���� �� �ִ°�? �� �ٲ۴ٸ� �̺�Ž���� �����Ϻ� �� �ִ�.
		
		//�ʱⰪ�� left = 1, right = distance �̴�.
		//mid�� �ּڰ� x��.
		
		Arrays.sort(rocks);
		int answer = binarySearch(distance, rocks, n);
        return answer;
    }
	
	int binarySearch(int distance, int[] rocks, int n){
        long answer = 0;
        //left 1
        //right 25
        long left = 1, right = distance, mid = 0;
    
        while(left <= right){
            int cnt = 0;
            int prev = 0;
            mid = (left + right) / 2;
            
            for(int i = 0 ; i < rocks.length ; ++i){
                if(rocks[i] - prev < mid){
                	// mid���� ���� ���� �����Ѵٴ� ������
                    // �ش� ���� �����Ѵ�.
                    cnt++;
                } else {
           			// mid���� ũ�ų� ���� ���� �����ϹǷ�
                    // prev�� ���� ���� �ʱ�ȭ�Ѵ�.
                    prev = rocks[i];
                }
            }
            
            // ������ ���� ������ ������ �Ÿ��� Ȯ���Ѵ�.
            if(distance - prev < mid) cnt++;
            
            if(cnt <= n){
            	// �־��� n ���� �۰ų� ���� ��ŭ ���� ���ּ�
                // �ּڰ� x�� ���� �� �ִ�.
            	answer = mid > answer ? mid : answer;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) answer;
	}
        
    //�ð��� �� �ʿ�����, �� �ʿ����� ��� �Լ�
    boolean moreCalc(int[] times, long mid, int n){
        long passValue = 0;
        
        for(int i=0; i<times.length; i++){
        	passValue = passValue + mid/times[i];
        }
        
        if(passValue >= n)   return true;    //�ð��� �� �ʿ���
        else                 return false;   //�ð��� �� �ʿ���
    }
    
	public static void main(String[] args) {
		Solution2todo sol = new Solution2todo();

		int dis = 25;
		int[] rocks = {2, 14, 11, 21, 17};
		int n = 2;
		
		System.out.println(sol.solution(dis, rocks, n));

	}

}
