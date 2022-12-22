package nocode.programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// Top K Frequent Element
// + sorting rule

// 반복된 문자중 k 보다 큰 문자를 반환하면 되는 문제 

// case : map 에 key 값으로 count + map 의 값으로 sorting 하면서 배열 만들기1
// case : map 에 key 값으로 count + map 의 값으로 sorting 하면서 배열 만들기2

// case : 이진트리 Top k 로 정렬 

public class HashMap6 {

	public static void main(String[] args) {

		String[] strs = {"no", "code", "program", "code", "no", "code"}; 	
		int k = 2;
		
		System.out.println(topK(strs, k));

	}
	private static String topK(String[] strs, int k) {
		String answer = "";
		HashMap<String, Integer>  map = new HashMap<>();
		for(String str : strs) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		List<String> keyList = new ArrayList<>(map.keySet());
		Collections.sort(keyList, (s1, s2) -> (map.get(s2).compareTo(map.get(s1))));
		
//		System.out.println(keyList.get(0));
//		System.out.println(keyList.get(1));
		
		answer +=keyList.get(0);
		answer +=",";
		answer +=keyList.get(1);
		
		return answer;
		
	}
	

}
