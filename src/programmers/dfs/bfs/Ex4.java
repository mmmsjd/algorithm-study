package programmers.dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BFS (Breadth Frist Search)
/*
 그래프 순회 방법문 하나 (넓이 우선 탐색)
 -.시작노드에서 인접노드를 모두 방문하고, 방문한 노드에서 
 인접노드를 모두 방문하는 것을 반복하는 알고리즘
 */
public class Ex4 {
	static final int max_n = 10;
	static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
	static int n = 5; // 5*5
	static int[][] board = new int[max_n][max_n];
	static class Point{
		Point(int r, int c, int d) {row = r; col = c; distance = d;}
		int row, col, distance;
	}
	// shorttest 
	public static void main(String[] args) {
// 크기 n = 5 * 5
/* 입력
  s
0 0 0 0 0
0 1 1 1 1
0 0 0 0 0
1 1 1 1 0
0 0 0 0 0
	e
*/
		
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		int[] start = {0, 1};
		int[] end 	= {4, 2};
		
		System.out.println(bfs(start[0], start[1], end[0], end[1]));
		
	}
	
	// queue
	private static int bfs(int s_row, int s_col, int e_row, int e_col) {
		
		boolean[][] visited = new boolean[max_n][max_n];		//기본 false
		
		Queue<Point> queue = new LinkedList<>();
		visited[s_row][s_col] = true;		
		queue.add(new Point(s_row, s_col, 0));
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			if(current.row == e_row && current.col == e_col) {
				return current.distance;
			}				
			
			for (int i = 0; i < d.length; i++) {
				int nr = current.row + d[i][0];
				int nc = current.col + d[i][1];
				if(nr < 0 || nr > n-1 || nc < 0 || nc > n-1) continue;
				if(visited[nr][nc]) continue;
				if(board[nr][nc] == 1) continue;
				visited[nr][nc] = true;		
				queue.add(new Point(nr, nc, current.distance +1));
			}
		}
		return -1;
	}	
	
}
