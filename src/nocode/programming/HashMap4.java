package nocode.programming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

// 242. Valid Anagram

// case : ���ڿ� �ϳ��� ���ڰ����� count �ؼ� �ְ�
// �� �ϳ��� ���ڰ�����ŭ -count �� �ϸ� ����.
// -> o(n)

// case : ���ڿ� �ΰ���� sort �ϰ� pointer �� ������Ű�鼭 ��
// -> o(nlogn)


public class HashMap4 {

	public static void main(String[] args) {

		String a = "nocodeprogram";
		String b = "promdernacoog";
		
		System.out.println(anagram(a, b));
		System.out.println(anagram2(a, b));

	}

	// O(nlogn)
	private static String anagram2(String a, String b) {
		boolean result = false;
		
		Arrays.sort(a.toCharArray());
		Arrays.sort(b.toCharArray());
		int idx = 0;
		int len = a.length()-1;
		
		while (idx < len) {
			char ch1 = a.charAt(idx);
			char ch2 = b.charAt(idx);
			
			if(ch1 == ch2) {
				result = true;
			}
			idx++;
			
		}
		return result ? "true" : "false";
	}
	
	// O(n)
	private static String anagram(String a, String b) {
		String answer = "";
		HashMap<String, Integer> count = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			String str = String.valueOf(a.charAt(i));
			count.put(str, count.getOrDefault(str, 0) +1);
		}
		System.out.println(count.toString());
		for (int i = 0; i < b.length(); i++) {
			String str = String.valueOf(b.charAt(i));
			count.put(str, count.getOrDefault(str, 0) -1);
		}
		
		System.out.println(count.toString());
		return answer;
		
	}
	

}
