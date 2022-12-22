package level2;

// 피로도 완전탐색(DFS)

/**
 * DFS 는 재귀와 반복문
 * BFS 는 반복문과 큐
 */

/*
 * 완전탐색 유형은 재귀와 + visited 함수가 핵심(DFS)
 * 
 * 아이디어 어떻게 짤까나?
 * 
 * 1.visit 변수 전역변수로 선언?
 * 2.재귀함수로 각노드를 모두 돌아보고 가능하면 count
 * 
 */

public class Ex26 {
	
	int answer = -1;
	
	public int solution(int k, int[][] dungeons) {
		
		boolean[] visited = new boolean[dungeons.length];		
		
		go(0, k , visited, dungeons);		
		return answer;
	}

	// 완전 탐색에 핵심 재귀함수+dfs!!!
	private void go(int n, int k, boolean[] visited, int[][] dungeons) {
		if (answer < n) answer = n;
		
		
		for (int i = 0; i < visited.length; i++) {
			// 방문한적이 없고 던전의 최소필요피로도 보다 현재 필요도가 크거나 같다면 방문
			if(!visited[i] && dungeons[i][0] <= k) {
				visited[i] = true;
				// 실행횟수 증가, 피로도 감소처리, 다음방문
				go(n+1, k - dungeons[i][1], visited, dungeons);
				visited[i] = false;
				
			}
		}
		
	}


	public static void main(String[] args) {
		Ex26 sol = new Ex26();
		
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		
		System.out.println(sol.solution(k, dungeons)); 

	}

}
