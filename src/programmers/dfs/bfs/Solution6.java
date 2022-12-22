package programmers.dfs.bfs;

import java.util.ArrayList;
import java.util.Collections;

// DFS/BFS 6.여행경로 
// 음.. DFS+백트래킹 문제(좀이해되네..)
/*
문제 설명)
주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.

항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항)
모든 공항은 알파벳 대문자 3글자로 이루어집니다.
주어진 공항 수는 3개 이상 10,000개 이하입니다.
tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
주어진 항공권은 모두 사용해야 합니다.
만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.

입출력 예)
tickets	return
[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]									: ["ICN", "JFK", "HND", "IAD"]
[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]		: ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 */
public class Solution6 {
	
	// 풀이1----------------------------------------------------------------
	private static final int 출발 = 0;
    private static final int 도착 = 1;

    private static ArrayList<String> answer = new ArrayList<>();
    private static String route = "";
    private static boolean[] visited; //의미 판단

    public static String[] solution(String[][] tickets) {
    	
        for (int i = 0; i < tickets.length; i++) {
            visited = new boolean[tickets.length];
            
            String src = tickets[i][출발];
            String dst = tickets[i][도착];

            if (src.equals("ICN")) {
                route = src + ",";
                visited[i] = true;
                dfs(tickets, dst, 1);//핵심코드 가지치기 하기위한 재귀
            }
        }
        
        
        Collections.sort(answer);
        
        System.out.println(answer.get(0).toString());
        System.out.println(answer.get(1).toString());
        System.out.println(answer.get(2).toString());
//        ICN,ATL,ICN,SFO,ATL,SFO,
//        ICN,ATL,SFO,ATL,ICN,SFO,
//        ICN,SFO,ATL,ICN,ATL,SFO,

//          기댓값 ["ICN","ATL","ICN","SFO","ATL","SFO"]과 다릅니다.
        return answer.get(0).split(",");
    }

    private static void dfs(String[][] tickets, String dst, int visitCount) {
    	
        route += dst + ",";
        
        if (visitCount == tickets.length) {//모든 방문을 완료했다면 return;
            answer.add(route); //방문지 add
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String nextSrc = tickets[i][출발];
            String nextDst = tickets[i][도착];
            
            if (nextSrc.equals(dst) && !visited[i]) {// 무의미 하다면 상위 decision, 유의미 하다면 진행 //핵심코드
            	
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
