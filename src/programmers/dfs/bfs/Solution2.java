package programmers.dfs.bfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// BFS 2.��Ʈ��ũ(ť/����+�湮)
public class Solution2 {
	
	public int solution(int n, int[][] computers) {
        int answer = 0;
        // BFS(ť)
        Queue<Integer> queue = new LinkedList<>();
        // 1.�湮üũ �迭
        boolean[] visited = new boolean[n];
        
        // 2.�湮�� ��ǻ�͸� ť�� ����
        for (int i = 0; i < n; i++) {
        	
			if(!visited[i]) {
				queue.add(i);
				answer++;
				
				// 3.�湮�� ��ǻ�ͺ��� Ž���ؼ� ����� ��ǻ�� �湮ó���ϱ�
				while(!queue.isEmpty()) {
					int com = queue.poll();

					visited[com] = true; // �湮
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
        // ���� �̿�
        Stack<Integer> stack = new Stack<>();
        
        // 1.�湮üũ �迭
        boolean[] visited = new boolean[n];
        
        // 2.�湮�� ��ǻ�� ���ÿ� ���� (�ѹ��� �湮üũ �迭�� ��� true �Ǹ� ��Ʈ��ũ�� 1����.)
        for (int i = 0; i < n; i++) {
        	
			if(!visited[i]) { 
				stack.push(i);
				answer++; 
				
				// 3.�湮�� ��ǻ�ͺ��� Ž���ؼ� ����� ��ǻ�� �湮ó���ϱ�
				while(!stack.isEmpty()) {
					
					int com = stack.pop();
					// �湮ó��
					visited[com] = true; 
					
					for (int j = 0; j < n; j++) {
						if(computers[com][j] == 1 && !visited[j]) { // ����Ǿ��ְ� �湮���߾��ٸ� next �湮
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
