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
public class Ex1 {
	
	static final int max_n = 10;
	static int n, e;
	static int[][] graph = new int[max_n][max_n];
	static boolean[] visited = new boolean[max_n];
	
	public static void main(String[] args) {
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
		dfs2(0);
	}
	
	// basic
	private static void dfs(int node) {
		visited[node] = true;
		System.out.print(node + "");
		
		for (int i = 0; i < n; i++) {
			if (!visited[i] && graph[node][i] != 0) {
				dfs(i);
			}
		}
	}
	
	//stack
	private static void dfs2(int node) {
		boolean[] visited = new boolean[max_n];
		
		Stack<Integer> stack = new Stack<>();
		stack.push(node);
		
		/*	
			      0
			   ／   ＼ 
			  1       2
		／  ＼   ／ 
		3 ――――  4 
		
		4
		3
		2
		1
		0
		*/
		while(!stack.isEmpty()) {
			int current = stack.pop();
			
			if(visited[current]) continue;
			
			visited[current] = true;
			
			System.out.print(current +"");
			
			for (int i = 0; i < n; i++) {
				if (!visited[i] && graph[current][i] != 0) {
					stack.push(i);
				}
			}
		}
	}
	
}
