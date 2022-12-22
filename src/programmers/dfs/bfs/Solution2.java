package programmers.dfs.bfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// BFS 2.네트워크(큐/스택+방문)
public class Solution2 {
	
	public int solution(int n, int[][] computers) {
        int answer = 0;
        // BFS(큐)
        Queue<Integer> queue = new LinkedList<>();
        // 1.방문체크 배열
        boolean[] visited = new boolean[n];
        
        // 2.방문한 컴퓨터를 큐에 삽입
        for (int i = 0; i < n; i++) {
        	
			if(!visited[i]) {
				queue.add(i);
				answer++;
				
				// 3.방문한 컴퓨터부터 탐색해서 연결된 컴퓨터 방문처리하기
				while(!queue.isEmpty()) {
					int com = queue.poll();

					visited[com] = true; // 방문
					for (int j = 0; j < n; j++) {
						if(computers[com][j] == 1 && !visited[j]) {
							queue.add(j);
						}
					}
				}
			}
		}
        
        return answer;
    }
	
	public int solution2(int n, int[][] computers) {
        int answer = 0;
        // 스택 이용
        Stack<Integer> stack = new Stack<>();
        
        // 1.방문체크 배열
        boolean[] visited = new boolean[n];
        
        // 2.방문한 컴퓨터 스택에 삽입 (한번에 방문체크 배열이 모두 true 되면 네트워크는 1개임.)
        for (int i = 0; i < n; i++) {
        	
			if(!visited[i]) { 
				stack.push(i);
				answer++; 
				
				// 3.방문한 컴퓨터부터 탐색해서 연결된 컴퓨터 방문처리하기
				while(!stack.isEmpty()) {
					
					int com = stack.pop();
					// 방문처리
					visited[com] = true; 
					
					for (int j = 0; j < n; j++) {
						if(computers[com][j] == 1 && !visited[j]) { // 연결되어있고 방문안했었다면 next 방문
							stack.push(j);
						}
					}
				}
			}
		}
        
        return answer;
    }
    

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		
		int n = 3;
//		int[][] computers= {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int[][] computers= {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		
		
		System.out.println(sol.solution(n, computers));

	}

}
