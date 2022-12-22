package level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

// DFS 여행경로

/*
 * DFS+재귀+Stack으로 풀어보자.
 */
public class Ex6 {
	
	List<Stack<String>> list;
	String[][] tickets;

    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        this.tickets = tickets;
        boolean[] visited = new boolean[tickets.length];
        
        Stack<String> stack = new Stack<>();
        stack.push("ICN");
        
        dfs(visited, stack, 0);
        
        if(list.size() > 1) {
        	
        	Collections.sort(list, new Comparator<Stack<String>>() {

				@Override
				public int compare(Stack<String> o1, Stack<String> o2) {
					for (int i = 0; i < o1.size(); i++) {
						String s1 = o1.get(i);
						String s2 = o2.get(i);
						if(!s1.equals(s2)) {
							return s1.compareTo(s2);
						}
					}
					return 0;
				}
        		
			});
        }
        Stack<String> response = list.remove(0); //정렬중 제일로 빠른놈
        String[] answer = new String[response.size()];
        int add = 0;
        for (String string : response) {
        	System.out.println(string);
			answer[add++] = string;
		}
        
        
                
        return answer;
    }
    
	private void dfs(boolean[] visited, Stack<String> stack, int count) {
		if(count == tickets.length) {
			Stack<String> newlist = new Stack<>();
			for (String string : stack) {
				newlist.push(string);
			}
			list.add(newlist);
			return;
		}
		String dst = stack.peek();
		
		for (int i = 0; i < tickets.length; i++) {
			String[] ticket = tickets[i];
			if(!visited[i] && dst.equals(ticket[0])) {//출발지
				stack.push(ticket[1]);
				visited[i] = true;
				dfs(visited, stack, count +1);
				visited[i] = false;
				stack.pop();
				
			}
		}
		
	}

	public static void main(String[] args) {
		Ex6 sol = new Ex6();
		
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		System.out.println(sol.solution(tickets)); 

	}

}
