package programmers.dfs.bfs;

import java.util.Scanner;

// ���(recursion)
/*
 * �ڱ� �ڽ��� ȣ���ϴ� �Լ� 
 * -.base case(������ ����� ��ȯ�ϴ� �κ�)
 * -.recursive case(�ڱ��ڽ��� ȣ���ϴ� �κ�)
 */
public class Ex5 {
	// Factorial (������ �ͳ���)
	int factorial(int n) {
		//---------------------------------------base case
		if(n == 0)
			return 1;
		//---------------------------------------
		//---------------------------------------recursive case
		return n * factorial(n -1);
		//---------------------------------------
	}
		

	static final int max_n = 10;
	static int n = 5; // 5*5
	static int[][] board = new int[max_n][max_n];
	
	public static void main(String[] args) {
		

// ũ�� n = 5 * 5
/* �Է�
0 0 0 0 0
0 0 0 1 1
0 0 0 1 0
1 1 1 1 0
0 0 0 0 0
*/
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		int row = 1, col = 1;
		
		fill(row, col);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j]+"");
			}
			System.out.println();
		}
		
	}

	static void fill(int row, int col) {
		if(row < 0 || row > n-1 || col < 0 || col > n-1) return;
		if(board[row][col] != 0) return;		
		board[row][col] = 1;
		
		fill(row -1, col);
		fill(row +1, col);
		fill(row, col -1);
		fill(row, col +1);
		
	}
	
	
}
