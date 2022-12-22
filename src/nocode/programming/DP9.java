package nocode.programming;

//�������� ���� 
// 0-1 knapsack problme

// case : brute-force
// �� True, False : ����ִ� ���̽�, �ȵ�� �ִ� ���̽� �� ����� ���� ���鼭 ���� ��� 
// �� 2^4 == 2^n 


// case : dp 
// �� �������� ���ѵ� ���, �����Ե� ���� ���
/*------------------------------------
 * ns(n, w) = ns(n-1, w - w[n] )+ input[n]
 *			  ns(n-1, w) + 0;
 *------------------------------------
 * 				NS(ABCD,5)
 *     	NS(ABC,1) 				NS(ABC,5)
 * NS(AB,-2)	NS(AB,1)	NS(AB,2)	NS(AB,5)
 * 
 * ------------------------------------
 *      0 1 2 3 4 5 
 *    ��  
 *    A  
 *   AB  
 *  ABC  
 * ABCD
 */

public class DP9 {
	 
	public static void main(String[] args) {
		
		// 				A	B	C	D
		int[] values = {30, 20, 40, 10};
		int[] weight = {1,2,3,4};
		int limit = 5;
		
		System.out.println(knapsack(values, weight, limit));
		
		
	}

	private static int knapsack(int[] values, int[] weight, int limit) {
		int len = values.length;
		int[][] dp = new int[len+1][limit+1];		
		
		for (int n = 1; n <= len; n++) {
			for (int w = 1; w <= limit; w++) {
				
				if(weight[n-1] <= w) {
					dp[n][w] = Math.max(dp[n-1][w], dp[n-1][w - weight[n-1]] + values[n-1]);//������ - ����
							
					
				}else {
					dp[n][w] = dp[n-1][w];// ������ case
				}
			}
		}
		
		return  dp[len][limit];
	}

}
