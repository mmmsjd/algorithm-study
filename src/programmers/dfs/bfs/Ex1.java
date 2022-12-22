package programmers.dfs.bfs;

import java.util.Scanner;
import java.util.Stack;

// DFS (Depth Frist Search)
/*
 �׷��� ��ȸ ����� �ϳ� (���̿켱 Ž��)
 -.���۳�忡�� ���̰� Ŀ���� �������� Ž���� �����Ͽ� 
 ���̻� �湮�� ���� ��尡 ���� ��� �������� ���ư���
 �ٽ� ���� �켱 Ž���� �ݺ��ϴ� �˰���
 */
public class Ex1 {
	
	static final int max_n = 10;
	static int n, e;
	static int[][] graph = new int[max_n][max_n];
	static boolean[] visited = new boolean[max_n];
	
	public static void main(String[] args) {
	/*	
		      0
		   ��   �� 
		  1       2
	   ��  ��   �� 
	  3 ��������  4 
	 
	 */
		
/* �Է�
5 6
0 1 0 2 1 3 1 4 2 4 3 4		 
 */
		
		
		Scanner sc = new Scanner(System.in);
		// ��� ���� 
		n = sc.nextInt();
		// ���� ���� 
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
			   ��   �� 
			  1       2
		��  ��   �� 
		3 ��������  4 
		
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
