package programmers.dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

// DFS 4.�ܾ� ��ȯ(���+�湮)
public class Solution4 {
	boolean[] visited;
	int answer = 0;

	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		
		dfs(begin, target, words, 0);
		
        return answer;
    }


	private void dfs(String begin, String target, String[] words, int count) {
		// 1.Ż������(��� ���ؼ� �ܾ ������ Ż��)
		if(begin.equals(target)) {
			answer = count;
			return;
		}
		
		// 2.���ൿ�� (�߿������� ���ڿ��� ����� ���ϴ� ���� �ƴ϶� �ּҴܰ踦 ���ϴ� ��)
		for (int i = 0; i < words.length; i++) {
			if(visited[i]) {
				continue;
			}
			// ���� ���縵 ���� 
			int s_count = 0;
			for (int j = 0; j < begin.length(); j++) {
				// ���� loop(�ܾ��� ���̴� �����ϴ�.)
				if(begin.charAt(j) == words[i].charAt(j)) {
					s_count++;
				}
				if(s_count == begin.length() -1) { // �ѱ��� ���� ���� ���(�ֳĸ� �� ���� �� ���� ���ĺ��� �ٲ� �� �ֱ⿡)
					visited[i] = true;
					dfs(words[i], target, words, count+1);
					visited[i] = false;
				}
			}
		}
		
	}

	// ť+Ŭ���� �̿�
	public int solution2(String begin, String target, String[] words) {
		int n = words.length, answer = 0;
	
		Queue<Node> queue = new LinkedList<>();	
	
	    boolean[] visited = new boolean[n];
	    queue.add(new Node(begin, 0)); //ù��°
	
	    while(!queue.isEmpty()) {
	        Node cur = queue.poll(); //������
	        if (cur.next.equals(target)) {
	        	answer = cur.edge;
	            break;
	        }
	
	        for (int i=0; i<n; i++) {
	            if (!visited[i] && isNext(cur.next, words[i])) {// �湮 ���߾���, ���� ���̶�� �湮+1;
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
	        if (cur.charAt(i) != n.charAt(i)) {//�ϳ��� ���ٸ� ���� ��
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
