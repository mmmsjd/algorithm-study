package nocode.programming;

// 64. Minimum Path Sum
// a1 ~ an 까지 가는데 최소 비용을 구하라 

public class DP2 {

	public static void main(String[] args) {
		
		int[][] matrix = {
							{1,3,1,2}, 
							{2,4,5,2},
							{3,4,5,6},
							{1,5,6,2}
						};
		
		System.out.println(pathSnum2(matrix));
		
	}
	
	//O(1) space complexity
	private static int pathSnum2(int[][] matrix) {	
		
		//cost(x,y) = min(F(x-1,y), F(x,y-1))
		int n = matrix.length;
		int m = matrix[0].length;
		
		System.out.println("n:"+n);
		System.out.println("m:"+m);
		
		for (int i = 0; i < n; i++) {	
			for (int j = 0; j < m; j++) {	
				
				if(i==0 && j==0) {
					matrix[i][j] = matrix[i][j];
				}				
				else if(i > 0 && j==0 ) {
					matrix[i][j] = matrix[i-1][j] + matrix[i][j];
				}
				else if(i==0 && j > 0) {
					matrix[i][j] = matrix[i][j-1] + matrix[i][j];	
				}
				else {
					matrix[i][j] = Math.min(matrix[i-1][j] + matrix[i][j], matrix[i][j-1] + matrix[i][j]);
				}				
			}			
		}
		for(int[] i: matrix) {
			for(int j: i) {
				System.out.print(j+" ");				
			}
			System.out.println();
		}
		
		
		return matrix[n-1][m-1];
	}
	
	// O(nm) space complexity
	private static int pathSnum(int[][] matrix) {
		
		//cost(x,y) = min(F(x-1,y), F(x,y-1))
		int n = matrix.length;
		int m = matrix[0].length;
		
		System.out.println("n:"+n);
		System.out.println("m:"+m);
		
		
		int[][] dp = new int[n][m];
		
		for (int i = 0; i < n; i++) {	
			for (int j = 0; j < m; j++) {	
				
				if(i==0 && j==0) {
					dp[i][j] = matrix[i][j];
				}				
				else if(i > 0 && j==0 ) {
					dp[i][j] = dp[i-1][j] + matrix[i][j];
				}
				else if(i==0 && j > 0) {
					dp[i][j] = dp[i][j-1] + matrix[i][j];	
				}
				else {
					dp[i][j] = Math.min(dp[i-1][j] + matrix[i][j], dp[i][j-1] + matrix[i][j]);
				}				
			}			
		}
//		for(int[] i: dp) {
//			for(int j: i) {
//				System.out.print(j+" ");				
//			}
//			System.out.println();
//		}
		
		
		return dp[n-1][m-1];
	}

}
