package nocode.programming;

// 416. Partition Equal subset sum (positive integer) 
// �������� �Ǻ��϶�

// sub probem(knapsack ������ ���) 
/*
 * ------------------------------------
 * dp(n, s) = 	dp(n-1, s-input[n])
 * 				dp(n-1, s])
 * 
 * dp[n][s]�� �ǹ̴� n° index���� s�� ������ �� �ִ��� �����̴�.
 * ������ 
 * ���� index�� dp[n-1][s]�� true�̰ų�, 
 * ������ ���� ���� nums[n]�� ����ϰ� dp[n-1][s-nums[n]] �� true�� case�� ã���� �ȴ�.
 * 
 * 
 * [2,1,2,3,4] = sum�� 12
 * ------------------------------------
 * 		[2,1,2,3,4]6
 *      /         \
 * [2,1,2,3]2    [2,1,2,3]6
 * ------------------------------------
 *      0 1 2 3 4 5 6
 *    �� t f f f f f f
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
		
		System.out.println(subset�˻�(values));
		
	}
	
	// �� ���� �����
	private static boolean subset�˻�(int[] nums) {
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
