package programmers.hash;

import java.util.HashMap;

// 해시 1.완주하지 못한 선수 
public class Solution1 {

	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String s:participant)
            map.put(s, map.getOrDefault(s, 0) + 1);
        
        for(String s:completion)
            map.put(s, map.get(s) -1);
        
        for(String key: map.keySet()) 
            if(map.get(key) != 0){
                
                answer = key;
                break;
            }
        return answer;
    }

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		
		String[] s1= {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] s2= {"josipa", "filipa", "marina", "nikola"};
		
		System.out.println(sol.solution(s1, s2));

	}

}
