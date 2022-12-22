package nocode.programming;

// 91. Decode ways
// encoding rule a=1, b=2... z=26
// 숫자열을 디코딩 하는 방법의 갯수를 계산하여라

// case : recursive bottomup

 

public class DP4 {
	
	public static void main(String[] args) {
		String nums = "212325";
		
//		System.out.println(solutions(nums));
		System.out.println(solutions2(nums));
		
	}

	private static int solutions(String nums) {
		int len = nums.length();
		int[] dp = new int[len+1];
		
		dp[0] = 1;
		dp[1] = nums.charAt(0) == '0' ? 0:1; 
		
		for (int i = 2; i < dp.length; i++) {
			char single_num = nums.charAt(i-1);
			
			if(single_num != '0') {
				dp[i] += dp[i-1];
			}
			String double_num = nums.substring(i-2, i);
			
			int twoDigit = Integer.parseInt(double_num);
			
			if(10 <= twoDigit && twoDigit <=26) {
				dp[i] += dp[i-2];
			}
		}
		
		
		return dp[len];
	}
	
	//topdown 하 ㅆㅂ
	private static int solutions2(String nums) {
		int len = nums.length();
		int[] dp = new int[len+1];
		
		dp[len] = 1;
		dp[len-1] = nums.charAt(len-1) == '0' ? 0:1;
		
		for (int i = len-2; i > -1; --i) {//for idx in range(str_length-2,-1,-1):
			int single_num = Integer.parseInt(String.valueOf(nums.charAt(i)));
			int single_count = 0;
			if(0 < single_num) {
				single_count = dp[i+1];
			}
			int double_num = Integer.parseInt(nums.substring(i, i+2));
			int double_count = 0;
			if(10 <= double_num && double_num <=26) {
				double_count = dp[i+2];
			}
			int count = single_count + double_count;
			dp[i] = count;
		}
		
		
		return dp[0];
	}
}
