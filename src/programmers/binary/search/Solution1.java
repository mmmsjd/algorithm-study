package programmers.binary.search;

import java.util.Arrays;

// �̺�Ž��(����Ž��) 1.�Ա��ɻ�
/**
 * 
 * ����Ž���� �̿��� Ǫ�� �����Դϴ�. 
 * Ž���� ����� �� �ҿ� �ð��̸�, 
 * �� �ҿ�ð��� times�迭�� �������� �� 
 * ���� n���� ũ�� �ð��� �� �ʿ��ϹǷ� right = mid -1�� �ǰ�, 
 * n���� ������ �ð��� �� �ʿ��ϹǷ� left = mid+1�� �˴ϴ�.
 */
public class Solution1 {
	 
	public long solution(int n, int[] times) {
		Arrays.sort(times);	// �ʼ�!! ����        
	    return binarySearch(times, n, times[times.length-1]);
    }
	
	long binarySearch(int[] times, int n, long max){
        //����Ž���� �����ϴ� �� �ʿ��� left, right, mid ���� ����(�ʱ�ȭ)
		long left = 0;
		long right = n * max; //�ִ밪(10) * n(6) = 60
		long mid = 0;
        long answer = Long.MAX_VALUE;

        while(left <= right){
        	/**
        	  min(�߰���)
        	  1)(0+60)/2=30
        	  2)(0+29)/2=14
        	  3)(15+29)/2=22
        	  4)(23+29)/2=26
        	  5)(27+29)/2=28
        	  6)(27==27) break;
        	 */        	
        	mid = (left + right)/2; 
            if(moreCalc(times, mid, n)){    	//�ð��� �� �ʿ� 1,5
            	answer = answer > mid ? mid : answer;
            	//1)30
            	//5)28
                right = mid - 1; //1)29 5)27
            } else{                             //�ð��� �� �ʿ� 2,3,4
            	//2)14
            	//3)22
            	//4)26
                left = mid + 1;	//2)15 3)23 4)27
            }
        }
        
        return answer;
    }
        
    //�ð��� �� �ʿ�����, �� �ʿ����� ��� �Լ�
    boolean moreCalc(int[] times, long mid, int n){
        long passValue = 0;
        
        for(int i=0; i<times.length; i++){
        	passValue = passValue + mid/times[i];
        	// 1)
        	// 30/7  =4(7*4=28)
        	// 30/10 =3
        	// 2)
        	// 14/7  =2
        	// 14/10 =1
        	// 3)
        	// 22/7  =3
        	// 22/10 =2
        	// 4)
        	// 26/7  =3
        	// 26/10 =2
        	// 5)
        	// 28/7  =4
        	// 28/10 =2
        }
        
        if(passValue >= n)   return true;    //�ð��� �� �ʿ���
        else                 return false;   //�ð��� �� �ʿ���
    }
    
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		
		int n = 6;
		int[] times = {7,10};
		
		System.out.println(sol.solution(n, times));

	}

}
