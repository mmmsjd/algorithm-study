package programmers.dp;

// DP 1. �����ﰢ��
public class Solution1 {
	
	//top-down, sub-problems �ذ�
	public int solution(int[][] triangle) {
        int answer = 0;
        
        /*
         * 7'
         * 3' 8 
         * 8' 1 0 
         * 2 7' 4 4 
         * 4 5' 2 6 5
         */
        for(int i = 1; i < triangle.length ; i++) {
        	for(int j = 0; j < triangle[i].length ; j++) {

        		if(j == 0) {//���� �� (�׻�0)        			
        			triangle[i][j] += triangle[i-1][j];
        		}
        		else if(j == i) {//������ ��(�׻� i==j)
        			triangle[i][j] += triangle[i-1][j-1];
        			
        		}
        		else {
        			triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
        		}

        		answer = Math.max(answer, triangle[i][j]);
        	}
        }
        return answer;
    }
    

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		
		int[][] num= {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		
		System.out.println(sol.solution(num));

	}

}
