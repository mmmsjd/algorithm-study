package programmers.dfs.bfs;

import java.util.ArrayList;
import java.util.Collections;

// DFS/BFS 6.������ 
// ��.. DFS+��Ʈ��ŷ ����(�����صǳ�..)
/*
���� ����)
�־��� �װ����� ��� �̿��Ͽ� �����θ� ¥���� �մϴ�. �׻� "ICN" ���׿��� ����մϴ�.

�װ��� ������ ��� 2���� �迭 tickets�� �Ű������� �־��� ��, �湮�ϴ� ���� ��θ� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���)
��� ������ ���ĺ� �빮�� 3���ڷ� �̷�����ϴ�.
�־��� ���� ���� 3�� �̻� 10,000�� �����Դϴ�.
tickets�� �� �� [a, b]�� a ���׿��� b �������� ���� �װ����� �ִٴ� �ǹ��Դϴ�.
�־��� �װ����� ��� ����ؾ� �մϴ�.
���� ������ ��ΰ� 2�� �̻��� ��� ���ĺ� ������ �ռ��� ��θ� return �մϴ�.
��� ���ø� �湮�� �� ���� ���� �־����� �ʽ��ϴ�.

����� ��)
tickets	return
[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]									: ["ICN", "JFK", "HND", "IAD"]
[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]		: ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 */
public class Solution6 {
	
	// Ǯ��1----------------------------------------------------------------
	private static final int ��� = 0;
    private static final int ���� = 1;

    private static ArrayList<String> answer = new ArrayList<>();
    private static String route = "";
    private static boolean[] visited; //�ǹ� �Ǵ�

    public static String[] solution(String[][] tickets) {
    	
        for (int i = 0; i < tickets.length; i++) {
            visited = new boolean[tickets.length];
            
            String src = tickets[i][���];
            String dst = tickets[i][����];

            if (src.equals("ICN")) {
                route = src + ",";
                visited[i] = true;
                dfs(tickets, dst, 1);//�ٽ��ڵ� ����ġ�� �ϱ����� ���
            }
        }
        
        
        Collections.sort(answer);
        
        System.out.println(answer.get(0).toString());
        System.out.println(answer.get(1).toString());
        System.out.println(answer.get(2).toString());
//        ICN,ATL,ICN,SFO,ATL,SFO,
//        ICN,ATL,SFO,ATL,ICN,SFO,
//        ICN,SFO,ATL,ICN,ATL,SFO,

//          ��� ["ICN","ATL","ICN","SFO","ATL","SFO"]�� �ٸ��ϴ�.
        return answer.get(0).split(",");
    }

    private static void dfs(String[][] tickets, String dst, int visitCount) {
    	
        route += dst + ",";
        
        if (visitCount == tickets.length) {//��� �湮�� �Ϸ��ߴٸ� return;
            answer.add(route); //�湮�� add
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String nextSrc = tickets[i][���];
            String nextDst = tickets[i][����];
            
            if (nextSrc.equals(dst) && !visited[i]) {// ���ǹ� �ϴٸ� ���� decision, ���ǹ� �ϴٸ� ���� //�ٽ��ڵ�
            	
                visited[i] = true;
                dfs(tickets, nextDst, visitCount + 1);                
                visited[i] = false;
                
                route = route.substring(0, route.length() - 4);
                
            }
        }
    }
    
	public static void main(String[] args) {
		Solution6 sol = new Solution6();

		String[][] a = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		
		System.out.println(sol.solution(a));

	}

}
