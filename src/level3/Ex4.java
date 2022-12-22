package level3;

// ��� (DP)

/*
 * ���� ���� ��, �� ���� �ִ� ���� ��ǥ�� (1, 1)�� ��Ÿ���� ���� ������ �Ʒ�, �� �б��� �ִ� ���� ��ǥ�� (m, n)���� ��Ÿ���ϴ�.

������ ũ�� m, n�� ���� ��� ������ ��ǥ�� ���� 2���� �迭 puddles�� �Ű������� �־����ϴ�. 

�����ʰ� �Ʒ������θ� ������ ������ �б����� �� �� �ִ� �ִܰ���� ������ 1,000,000,007�� ���� �������� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 */

/*
 * ���̵�� 
 * DP ����� bottom-up for + tablezation ? 
 * 
 */
public class Ex4 {

	public int solution2(int m, int n, int[][] puddles) {

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i < puddles.length; i++) {
			dp[puddles[i][0]][puddles[i][1]] = -1;
		}

		dp[1][1] = 1;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (dp[i][j] == -1) {
					dp[i][j] = 0;
					continue;
				}
				if (i != 1)
					dp[i][j] += dp[i - 1][j];
				if (j != 1)
					dp[i][j] += dp[i][j - 1];
			}
		}
		return dp[m][n] % 1000000007;
	}
	
    public int solution(int m, int n, int[][] puddles) {
      
        int[][] load  = new int[n][m];// ��3, ��4
        
        //������ ǥ�� 
        for (int[] puddle : puddles)
        	load[puddle[1] - 1][puddle[0] - 1] = -1;
        
        // �������� 1;
        load[0][0] = 1;
        
        for (int i = 0; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				if (load[i][j] == -1) { // �����̸� 0���� ����
					load[i][j] = 0;
			    	continue;
				}
			
				if (i != 0) {
					load[i][j] += load[i - 1][j] % 1000000007; 
					System.out.print("I:"+i+","+j+" << "+(i - 1)+","+j);
					System.out.println(" >>>>"+load[i][j]);
				}
				if (j != 0) {
					load[i][j] += load[i][j - 1] % 1000000007;	
					System.out.print("J:"+i+","+j+" << "+i+","+(j - 1));
					System.out.println(" >>>>"+load[i][j]);
				}
			}
		}
        
//        [1, 1, 1, 1], 
//        [1, 0, 1, 2], 
//        [1, 1, 2, 4]
        		
        return load[n - 1][m - 1] % 1000000007;

    }
    
	public static void main(String[] args) {
		Ex4 sol = new Ex4();
		
		int m = 4;
		int n = 3;
		int[][] puddles = {{2, 2}}; //4
		
		System.out.println(sol.solution(m, n, puddles)); 

	}

}
