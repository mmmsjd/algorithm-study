package nocode.programming;

// 416. Partition Equal subset sum (positive integer) 
// 가능한지 판별하라

// sub probem(knapsack 문제와 비슷) 
/*
 * ------------------------------------
 * dp(n, s) = 	dp(n-1, s-input[n])
 * 				dp(n-1, s])
 * 
 * dp[n][s]의 의미는 n째 index까지 s를 생성할 수 있는지 여부이다.
 * 때문에 
 * 이전 index인 dp[n-1][s]가 true이거나, 
 * 이전이 지금 값인 nums[n]을 사용하고 dp[n-1][s-nums[n]] 가 true인 case를 찾으면 된다.
 * 
 * 
 * [2,1,2,3,4] = sum은 12
 * ------------------------------------
 * 		[2,1,2,3,4]6
 *      /         \
 * [2,1,2,3]2    [2,1,2,3]6
 * ------------------------------------
 *      0 1 2 3 4 5 6
 *    Φ t f f f f f f
 *    2 t f t f f f f
 *   21 t t t t f f f
 *  212 t t t t t t f
 * 2123 t t t t t t t
 *21234 t t t t t t t
 */




public class DP10 {
	 
	public static void main(String[] args) {
		
		// 2,1,2,3,4 //true
		int[] values = {2,1,2,3,4};//true
//		int[] values = {1,2,3,5};//false
//		int[] values = {1,5,11,5};//true
		
		System.out.println(subset검색(values));
		
	}
	
	// 와 ㅆㅂ 개깔끔
	private static boolean subset검색(int[] nums) {
		if (nums.length < 2)
			return false;
		
		int sum = 0;
		for (int v : nums) {
			sum += v;
		}
		
		if (sum % 2 == 1)
			return false;
		
		sum /= 2;

		boolean[] dp = new boolean[sum + 1];	// 7
		dp[0] = true;

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i - 1];				// 2,1,2,3,4

			for (int j = sum; j >= num; j--) {
				boolean dp0 = dp[j];
				boolean dp1 = dp[j - num];
				dp[j] =  dp0 || dp1;
			}
		}
		return dp[sum];
	}
}
