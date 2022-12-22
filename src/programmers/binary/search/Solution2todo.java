package programmers.binary.search;

import java.util.Arrays;

// 이분탐색(이진탐색) 2.징검다리(..하 어렵네 )
public class Solution2todo {
	
	public int solution(int distance, int[] rocks, int n) {
//		문제에서 묻는 바를 다르게 생각할 수 있어야하는 것 같다. 
//		문제에서는 돌을 n개 만큼 없앴을 때 시작점, 끝점, 돌 사이에 거리 중 최솟값 중에 최댓값을 구하라고 한다. 
//		묻는 바를 반대로 생각하여 n개의 돌을 없애서 돌 사이 거리의 최솟값이 x로 만들 수 있는가? 로 바꾼다면 이분탐색을 생각하볼 수 있다.
		
		//초기값은 left = 1, right = distance 이다.
		//mid는 최솟값 x다.
		
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
                	// mid보다 작은 값이 존재한다는 뜻으로
                    // 해당 돌을 제거한다.
                    cnt++;
                } else {
           			// mid보다 크거나 같은 값이 존재하므로
                    // prev를 현재 돌로 초기화한다.
                    prev = rocks[i];
                }
            }
            
            // 마지막 돌과 도착점 사이의 거리도 확인한다.
            if(distance - prev < mid) cnt++;
            
            if(cnt <= n){
            	// 주어진 n 보다 작거나 같은 만큼 돌을 없애서
                // 최솟값 x를 만들 수 있다.
            	answer = mid > answer ? mid : answer;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) answer;
	}
        
    //시간이 더 필요한지, 덜 필요한지 계산 함수
    boolean moreCalc(int[] times, long mid, int n){
        long passValue = 0;
        
        for(int i=0; i<times.length; i++){
        	passValue = passValue + mid/times[i];
        }
        
        if(passValue >= n)   return true;    //시간이 덜 필요함
        else                 return false;   //시간이 더 필요함
    }
    
	public static void main(String[] args) {
		Solution2todo sol = new Solution2todo();

		int dis = 25;
		int[] rocks = {2, 14, 11, 21, 17};
		int n = 2;
		
		System.out.println(sol.solution(dis, rocks, n));

	}

}
