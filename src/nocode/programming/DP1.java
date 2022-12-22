package nocode.programming;

// Climbing Stairs, Min cost Climbing Stairs

// F=DP
// F(n) = min ( F(n-2)+cost(n-2)
//				F(n-1)+cost(n-1)
// 시작위치 0으로 올라가는데 비용은 0이다.

public class DP1 {

	public static void main(String[] args) {
		int[] stairs = {1,2,4,6,2,4,6,1};
		//			   {1,2,5,8,7,11,13,12} 
		//최소비용 ->  {0,0,1,2,5,7,7,11,12};
		
		int n = stairs.length;
		int[] dp = new int[n];
		
		dp[0] = stairs[0];
		dp[1] = stairs[1];	
		
		for (int i = 2; i < n; i++) {			
			dp[i] = Math.min(dp[i-2] + stairs[i], dp[i-1] + stairs[i]);// min(이전전 cost+현재cost, 이전 cost+현재cost)
		}
		
		System.out.println(Math.min(dp[n-1], dp[n-2]));//최종 올라온 case 중 min 값을 반환 
		
	}

}
