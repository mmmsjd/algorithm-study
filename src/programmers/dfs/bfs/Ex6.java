package programmers.dfs.bfs;

import java.util.PriorityQueue;
import java.util.Scanner;

// ���ͽ�Ʈ��(Dijkstra)
/*
 * �ִܰ�θ� ã�� �˰���
 * -.�׷������� �� ���� ������ ��ε��� ������ ����ġ ���� �ּ��� ���
 * 
 * Ư¡ : 
 * 		.greedy algorithm
 * 			�� ���ÿ��� ����� ������ Ž��
 * 			���� ����ġ�� ������� ����
 * 		.dynamic programming
 * 			���ο� �������� �ִ� ��θ� ���ϱ� ���ؼ� ������ ����� ����� ���
 */

public class Ex6 {
	static final int INF = 987654321;
	static final int max_n = 10;
	static int n, e;
	static int[][] graph = new int[max_n][max_n];
	static int[] dist = new int[max_n];
	static int[] prev = new int[max_n];
	
	public static void main(String[] args) {
		
/*
�Է�
0 1 50
0 2 30
1 3 30
1 4 70
2 3 20
2 4 40
3 4 10
3 5 80
4 5 30
*/
/*
���
0 50 30 50 60 90
 */
		Scanner sc = new Scanner(System.in);
		// ��� ���� 
		n = 6;
		// ���� ���� 
		e = 9;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == j) 	graph[i][j] = 0;
				else 		graph[i][j] = INF;
			}
		}
		
		for (int i = 0; i < e; i++) {
			int u 		= sc.nextInt();
			int v 		= sc.nextInt();
			int cost 	= sc.nextInt();
			graph[u][v] = graph[v][u] = cost;
		}
		
		dijkstra(0);		
		for (int i = 0; i < n; i++) {
			System.out.println(dist[i]+" ");
		}
		
		dijkstrapath(0);
		
		StringBuffer sb = new StringBuffer();
		sb.append("0,");// �����
		
		for (int i = 1; i < n; i++) {			
			if(prev[i] > 0) {
				sb.append(prev[i]);
				sb.append(",");
			}
		}
		
		sb.append(5);// ������ 
		System.out.println(sb.toString());

	}

	static void dijkstra(int src) {
		
		PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		boolean[] visited = new boolean[max_n];		
		
		for (int i = 0; i < n; i++) dist[i] = INF;
		dist[src] = 0;
		pq.add(new Integer[] {0, src});
		
		while (!pq.isEmpty()) {
			Integer[] current = pq.poll();			
			int u = current[1];
			
			if (visited[u]) continue;
			visited[u] = true;
			
			for (int v = 0; v < n; v++) {
				if (dist[v] > dist[u] + graph[u][v]) {					
					dist[v] = dist[u] + graph[u][v];
					pq.add(new Integer[] {dist[v], v});
				}				
			}
		}
	}
	
	//��ΰ� �ʿ��� ��� 
	static void dijkstrapath(int src) {
		
		PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		boolean[] visited = new boolean[max_n];		
		
		for (int i = 0; i < n; i++) {
			prev[i] = -1;
			dist[i] = INF;
		}
		
		dist[src] = 0;
		pq.add(new Integer[] {0, src});
		
		while (!pq.isEmpty()) {
			Integer[] current = pq.poll();			
			int u = current[1];
			
			if (visited[u]) continue;
			visited[u] = true;
			
			for (int v = 0; v < n; v++) {
				if (dist[v] > dist[u] + graph[u][v]) {
					prev[v] = u;
					dist[v] = dist[u] + graph[u][v];
					pq.add(new Integer[] {dist[v], v});
				}				
			}
		}
	}
	
}
