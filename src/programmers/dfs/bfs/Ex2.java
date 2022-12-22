package programmers.dfs.bfs;

import java.util.Scanner;
import java.util.Stack;

// DFS (Depth Frist Search)
/*
 그래프 순회 방법문 하나 (깊이우선 탐색)
 -.시작노드에서 깊이가 커지는 방향으로 탐색을 진행하여 
 더이상 방문알 인접 노드가 없는 경우 이전노드로 돌아가서
 다시 깊이 우선 탐색을 반복하는 알고리즘
 */
public class Ex2 {
	static final int max_n = 10;
	static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
	static int n = 5; // 5*5
	static int[][] board = new int[max_n][max_n];
	static class Point{
		Point(int r, int c) {row = r; col = c;}
		int row, col;
	}
	
	// flood fill
	public static void main(String[] args) {

// 크기 n = 5 * 5
		
/* 입력
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
		int color = 9;
		
		dfs(row, col, color);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j]+"");
			}
			System.out.println();
		}
	}
	
	//stack
	private static void dfs(int row, int col, int color) {
		boolean[][] visited = new boolean[max_n][max_n];
		
		Stack<Point> stack = new Stack<>();
		stack.push(new Point(row, col));
		
		while(!stack.isEmpty()) {
			Point current = stack.pop();
			
			if(visited[current.row][current.col]) continue;
			visited[current.row][current.col] = true;
			
			board[current.row][current.col] = color;
			
			for (int i = 0; i < d.length; i++) {
				int nr = current.row + d[i][0];
				int nc = current.col + d[i][1];
				if(nr < 0 || nr > n-1 || nc < 0 || nc > n-1) continue;
				if(visited[nr][nc]) continue;
				if(board[nr][nc] == 1) continue;
				stack.push(new Point(nr, nc));
			}
		}
	}

	
}
