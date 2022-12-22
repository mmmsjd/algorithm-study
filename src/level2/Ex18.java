package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 튜플
/*
 * 튜플들을 배열로 변경한 뒤, 요소가 적은 순서대로 정렬한 후 새로
 * 등장하는 숫자들을 차례대로 집어넣은 배열을 반환하기만 하면되는 간단한 문제입니다.
 * 
 * 하.. 어렵구만 
 */
class Ex18 {
	
    public int[] solution(String s) {
    	HashMap<String, Integer> map = new HashMap<>();
    	
        char frist_bracket = '{';
        char last_bracket = '}';
        char comma = ',';
        
		int idx = 0;
		StringBuilder sb = new StringBuilder();		
		
        for (int i = 0; i < s.length(); i++) {
        	char current = s.charAt(i);
			if(s.charAt(i) == frist_bracket 
					|| s.charAt(i) == last_bracket
					|| s.charAt(i) == comma) {
				
				idx++;
			} else 
				idx = 0;
			
			if(idx == 0) sb.append(current);
			else if(sb.length() > 0) {
				
				map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) +1);
				sb.setLength(0);
				
			}
		}
        
        ArrayList<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));// 내림차순 정렬
        
        
        int[] answer = new int[keyList.size()];
        int add = 0;
        for(Object obj : keyList.toArray()){
        	answer[add++] = Integer.parseInt((String)obj);
        }
        return answer;
    }
    // 정규식 사용 풀이.. 쩐다..
    public int[] solution2(String s) {

        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String n = matcher.group();
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int size = map.size();
        int[] answer = new int[size];
        for (String key: map.keySet()) {
            answer[size - map.get(key)] = Integer.parseInt(key);
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	Ex18 sol = new Ex18();
		
//		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//    	String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		String s = "{{20,111},{111}}";
//		String s = "{{123}}";
		
		System.out.println(sol.solution2(s));
	}
    
}