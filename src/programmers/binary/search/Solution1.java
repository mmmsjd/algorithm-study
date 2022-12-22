package programmers.binary.search;

import java.util.Arrays;

// 이분탐색(이진탐색) 1.입국심사
/**
 * 
 * 이진탐색을 이용해 푸는 문제입니다. 
 * 탐색할 대상은 총 소요 시간이며, 
 * 총 소요시간을 times배열로 나누었을 때 
 * 값이 n보다 크면 시간이 덜 필요하므로 right = mid -1이 되고, 
 * n보다 작으면 시간이 더 필요하므로 left = mid+1이 됩니다.
 */
public class Solution1 {
	 
	public long solution(int n, int[] times) {
		Arrays.sort(times);	// 필수!! 정렬        
	    return binarySearch(times, n, times[times.length-1]);
    }
	
	long binarySearch(int[] times, int n, long max){
        //이진탐색을 수행하는 데 필요한 left, right, mid 변수 선언(초기화)
		long left = 0;
		long right = n * max; //최대값(10) * n(6) = 60
		long mid = 0;
        long answer = Long.MAX_VALUE;

        while(left <= right){
        	/**
        	  min(중간값)
        	  1)(0+60)/2=30
        	  2)(0+29)/2=14
        	  3)(15+29)/2=22
        	  4)(23+29)/2=26
        	  5)(27+29)/2=28
        	  6)(27==27) break;
        	 */        	
        	mid = (left + right)/2; 
            if(moreCalc(times, mid, n)){    	//시간이 덜 필요 1,5
            	answer = answer > mid ? mid : answer;
            	//1)30
            	//5)28
                right = mid - 1; //1)29 5)27
            } else{                             //시간이 더 필요 2,3,4
            	//2)14
            	//3)22
            	//4)26
                left = mid + 1;	//2)15 3)23 4)27
            }
        }
        
        return answer;
    }
        
    //시간이 더 필요한지, 덜 필요한지 계산 함수
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
        
        if(passValue >= n)   return true;    //시간이 덜 필요함
        else                 return false;   //시간이 더 필요함
    }
    
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		
		int n = 6;
		int[] times = {7,10};
		
		System.out.println(sol.solution(n, times));

	}

}
