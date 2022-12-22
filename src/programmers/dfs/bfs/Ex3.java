package programmers.dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BFS (Breadth Frist Search)
/*
 �׷��� ��ȸ ����� �ϳ� (���� �켱 Ž��)
 -.���۳�忡�� ������带 ��� �湮�ϰ�, �湮�� ��忡�� 
 ������带 ��� �湮�ϴ� ���� �ݺ��ϴ� �˰���
 */
public class Ex3 {
	static final int max_n = 10;
	static int n, e;
	static int[][] graph = new int[max_n][max_n];
	
	static void main(String[] args) {
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
			   ��   �� 
			  1       2
		 ��  ��   �� 
		3 ��������  4 
		
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
