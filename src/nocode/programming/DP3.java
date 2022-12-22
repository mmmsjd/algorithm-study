package nocode.programming;

import java.util.Arrays;

// 322. Min Coin Change
/*
 *				F(11)
 	F(9)-2		F(8)-3		F(6)-5
 	
 	F(11) = min(F(9), F(8), F(6)) +1
 	
 	F(n)  = min(F(n-2), F(n-3), F(n-5))+1
 	
 	F(n)  = min(F(n - cost[i]), F(n - cost[i + 1]), F(n - cost[i + 2])) + 1
 	
 	top-down 보다 bttom-up 이 좋다.
 	
 */
 

public class DP3 {
	
	public static void main(String[] args) {
		
		int[] nums = {2,3,5};
		int sum = 11;
		
		
//		System.out.println(topdown(nums, sum));
		
		System.out.println(bottomup(nums, sum));
		
	}

	private static int bottomup(int[] nums, int sum) {
		int[] dp = new int[sum+1];
		Arrays.fill(dp, sum+1);
		dp[0] = 0;
		
		for (int i = 1; i < dp.length; i++) {
			for(int num: nums) {// 동전의 갯수
				if(i - num < 0) continue;
				dp[i] = Math.min(dp[i], dp[i - num] + 1);
				
			}
		}
	
		return dp[sum] == sum +1 ? -1 : dp[sum];
	}

	
	private static int topdown(int[] nums, int sum) {
		
		
		return 0;

	}

}
