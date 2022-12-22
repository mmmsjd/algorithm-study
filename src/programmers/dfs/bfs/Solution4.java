package programmers.dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

// DFS 4.단어 변환(재귀+방문)
public class Solution4 {
	boolean[] visited;
	int answer = 0;

	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		
		dfs(begin, target, words, 0);
		
        return answer;
    }


	private void dfs(String begin, String target, String[] words, int count) {
		// 1.탈출조건(모두 비교해서 단어가 같으면 탈출)
		if(begin.equals(target)) {
			answer = count;
			return;
		}
		
		// 2.수행동작 (중요한점은 문자열을 만들어 비교하는 것이 아니라 최소단계를 구하는 것)
		for (int i = 0; i < words.length; i++) {
			if(visited[i]) {
				continue;
			}
			// 같은 스펠링 세기 
			int s_count = 0;
			for (int j = 0; j < begin.length(); j++) {
				// 이중 loop(단어의 길이는 동일하다.)
				if(begin.charAt(j) == words[i].charAt(j)) {
					s_count++;
				}
				if(s_count == begin.length() -1) { // 한글자 빼고 같은 경우(왜냐면 한 번에 한 개의 알파벳만 바꿀 수 있기에)
					visited[i] = true;
					dfs(words[i], target, words, count+1);
					visited[i] = false;
				}
			}
		}
		
	}

	// 큐+클래스 이용
	public int solution2(String begin, String target, String[] words) {
		int n = words.length, answer = 0;
	
		Queue<Node> queue = new LinkedList<>();	
	
	    boolean[] visited = new boolean[n];
	    queue.add(new Node(begin, 0)); //첫번째
	
	    while(!queue.isEmpty()) {
	        Node cur = queue.poll(); //꺼내요
	        if (cur.next.equals(target)) {
	        	answer = cur.edge;
	            break;
	        }
	
	        for (int i=0; i<n; i++) {
	            if (!visited[i] && isNext(cur.next, words[i])) {// 방문 안했었고, 다음 턴이라면 방문+1;
	            	visited[i] = true;
	                queue.add(new Node(words[i], cur.edge + 1));
	            }
	        }
	    }
	
	    return answer;
	}

	 boolean isNext(String cur, String n) {
	    int cnt = 0;
	    for (int i=0; i<n.length(); i++) {
	        if (cur.charAt(i) != n.charAt(i)) {//하나만 같다면 다음 턴
	            if (++ cnt > 1) return false;
	        }
	    }
	
	    return true;
	}    
	 
	class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

	public static void main(String[] args) {
		Solution4 sol = new Solution4();

		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(sol.solution2(begin, target, words));

	}

}
