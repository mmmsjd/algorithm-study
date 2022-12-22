package level3;

// 등굣길 (DP)

/*
 * 가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1, 1)로 나타내고 가장 오른쪽 아래, 즉 학교가 있는 곳의 좌표는 (m, n)으로 나타냅니다.

격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다. 

오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.
 */

/*
 * 아이디어 
 * DP 방법중 bottom-up for + tablezation ? 
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
      
        int[][] load  = new int[n][m];// 행3, 열4
        
        //웅덩이 표시 
        for (int[] puddle : puddles)
        	load[puddle[1] - 1][puddle[0] - 1] = -1;
        
        // 시작지점 1;
        load[0][0] = 1;
        
        for (int i = 0; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				if (load[i][j] == -1) { // 웅덩이면 0으로 세팅
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
