package nocode.programming;

import java.util.HashMap;

// 290. Word Pattern

// 대응되는 단어가 겹치면 안됨.


public class HashMap5 {

	public static void main(String[] args) {

		String[] strs = {"abba", "banna apple apple banna"}; 	//true
//		String[] strs = {"acc", "kiwi grape apple"};			//false
		
		System.out.println(wordPattern(strs));

	}

	private static String wordPattern(String[] strs) {
		String answer = "true";
		HashMap<String, String> map = new HashMap<>();
		String keys = strs[0];
		String[] arr = strs[1].split(" ");
		
		for(int i=0; i < keys.length(); i++) {
			String k = String.valueOf(keys.charAt(i));
			if(map.containsKey(k)) {
				if(!map.get(k).equals(arr[i])){
					answer = "false";
				}
				
			}else {
				map.put(k, arr[i]);
			}
			
			
		}
		System.out.println(map.toString());
		System.out.println(answer);
		return answer;
		
	}
	

}
