package level2;

import java.util.HashMap;

// 모음사전 (완전탐색)
/*
 * 재귀적으로 단어조합 계속하셈..
 * 'A', 'E', 'I', 'O', 'U'
 */

public class Ex33 {
	

	HashMap<String, Integer> wordMap = new HashMap<>();
	int count = 1;
	int answer = 0;
	
    public int solution(String word) {
    	
        String[] dictionary = {"A","E","I","O","U"};        
        
        recursive("", dictionary, word);
        
        return answer;
    }
    
	private void recursive(String use, String[] dictionary, String target) {
		// 1. 현재조합을 Map 에 추가한다.	
		if(!use.isEmpty()) {
			wordMap.put(use, count++);
			
		}
		if(use.equals(target)) {
			answer = wordMap.get(use);
			return;
		}
		// 2. 남은 문자중에 새로운 조합을 만들어 준다.
		for (int i = 0; i < dictionary.length; i++) {
			if(use.length() == 5)
				return;
			recursive(use + dictionary[i], dictionary, target);
			
		}
	}

	public static void main(String[] args) {
		Ex33 sol = new Ex33();

//		String word = "AAAAE";	
//		String word = "AAAE";	
//		String word = "I";	
		String word = "EIO";	
		
		System.out.println(sol.solution(word)); 

	}

}
