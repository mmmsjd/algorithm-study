package nocode.programming;

import java.util.Arrays;
import java.util.HashMap;

// 49. Group Anagrams

// input {"abc", "cde", "bca", "adc", "dec", "ba"}
// output {"abc","bca"},{"cde","dec"},{"adc"},{"ba"}

// case : 일반적인 hashMap 사용 + key 값 정렬				-> O(nlogn)
// case : hashMap 사용은 동일하나 문자열의 특성을 이용하여 	-> O(mn)
// └- 정렬된 key 값을 사용하지않고 a2b1 이런식으로 sort 대신 알파벳 table 을 사용하여 hashMap 에 기록하여 사용
// 		└- 알파벳 table abcd... xyz


public class String4 {

	public static void main(String[] args) {

		String[] strs = {"abc", "cde", "bca", "adc", "dec", "ba"};
		System.out.println(Anagrams(strs));

	}

	private static String[] Anagrams(String[] strs) {
		
		HashMap<String, String> map = new HashMap<>();
		
		for(String str: strs) {
			char[] chs = str.toCharArray();
			Arrays.sort(chs);
			String key = String.valueOf(chs);
			
			if(map.containsKey(key)) {
				map.put(key, map.get(key) + "," + str);		
			}else {
				map.put(key, str);
			}
			
				
		}
		
		String[] answer = new String[map.size()];
		int add = 0;
		for(String value : map.values()) {
			answer[add++] = value;
		}
		
		for (String string : answer) {
			System.out.println(string);
		}
		return answer;
		
	}
	

}
