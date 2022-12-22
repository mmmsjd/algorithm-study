package nocode.programming;

import java.util.Arrays;
import java.util.HashMap;

// 49. Group Anagrams

// input {"abc", "cde", "bca", "adc", "dec", "ba"}
// output {"abc","bca"},{"cde","dec"},{"adc"},{"ba"}

// case : �Ϲ����� hashMap ��� + key �� ����				-> O(nlogn)
// case : hashMap ����� �����ϳ� ���ڿ��� Ư���� �̿��Ͽ� 	-> O(mn)
// ��- ���ĵ� key ���� ��������ʰ� a2b1 �̷������� sort ��� ���ĺ� table �� ����Ͽ� hashMap �� ����Ͽ� ���
// 		��- ���ĺ� table abcd... xyz


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
