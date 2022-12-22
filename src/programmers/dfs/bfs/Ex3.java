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
public class Ex3 {
	static final int max_n = 10;
	static int n, e;
	static int[][] graph = new int[max_n][max_n];
	
	static void main(String[] args) {
	/*	
		      0
		   ／   ＼ 
		  1       2
	   ／  ＼   ／ 
	  3 ――――  4 
	 
	 */
		
/* 입력
5 6
0 1 0 2 1 3 1 4 2 4 3 4		 
*/
		
		
		Scanner sc = new Scanner(System.in);
		// 노드 갯수 
		n = sc.nextInt();
		// 간선 갯수 
		e = sc.nextInt();
		
		for (int i = 0; i < e; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u][v] = graph[v][u] = 1;
		}
		
		bfs(0);
	}
	
	// queue
	private static void bfs(int node) {
		
		boolean[] visited = new boolean[max_n];		
		
		Queue<Integer> queue = new LinkedList<>();
		visited[node] = true;
		queue.add(node);
		/*	
			      0
			   ／   ＼ 
			  1       2
		 ／  ＼   ／ 
		3 ――――  4 
		
		0, 1, 2, 3, 4
		*/
		
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current +"");						
			
			for (int i = 0; i < n; i++) {
				if (!visited[i] && graph[current][i] != 0) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
	}
	
	
}
