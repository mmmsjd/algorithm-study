package level2;

import java.util.ArrayList;
import java.util.Collections;

//[1차] 뉴스 클러스터링
/**
 * List는 중복허용 하기에 다중집합으로 쓰기 좋다.
 *	for (String s : multiset1) {
		if (multiset2.remove(s)) { //존재하면 교집합(remove 해야? 원래 교집합만 생각하면 안해도 되는데 아래 합집합을 생각해서 remove)
			intersection.add(s);
		}
		union.add(s);
	}

	for (String s : multiset2) {			
		union.add(s);
	}
 */

public class Ex21 {

	public int solution(String str1, String str2) {
		
		ArrayList<String> multiset1 = new ArrayList<>();
		ArrayList<String> multiset2 = new ArrayList<>();
		ArrayList<String> union = new ArrayList<>();
		ArrayList<String> intersection = new ArrayList<>();

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		// 유효값 추출해서 Set
		for (int i = 0; i < str1.length() - 1; ++i) {
			char first = str1.charAt(i);
			char next = str1.charAt(i + 1);

			if (first >= 'a' && first <= 'z' && next >= 'a' && next <= 'z') {
				multiset1.add(first+""+next);
			}
		}

		for (int i = 0; i < str2.length() - 1; ++i) {
			char first = str2.charAt(i);
			char next = str2.charAt(i + 1);

			if (first >= 'a' && first <= 'z' && next >= 'a' && next <= 'z') {
				multiset2.add(first+""+next);
			}
		}

		/**
		 * 다중집합 A = {1, 1, 2, 2, 3}, 
		 * 다중집합 B = {1, 2, 2, 4, 5}라고 하면, 
		 * 교집합 A ∩ B = {1, 2, 2}, 
		 * 합집합 A ∪ B = {1, 1, 2, 2, 3, 4, 5}가 되므로, 
		 * 자카드 유사도 J(A, B) = 3/7, 약 0.42가 된다
		 * 
		 * 각각 {FR, RA, AN, NC, CE}, {FR, RE, EN, NC, CH}가 되며, 
		 * 교집합은 {FR, NC}, 
		 * 합집합은 {FR, RA, AN, NC, CE, RE, EN, CH}가 되므로, 
		 * 두 문자열 사이의 자카드 유사도 J("FRANCE", "FRENCH") = 2/8 = 0.25가 된다.
		 */
		
		System.out.println(multiset1.toString());
		System.out.println(multiset2.toString());
		
		Collections.sort(multiset1);
		Collections.sort(multiset2);

		for (String s : multiset1) {
			if (multiset2.remove(s)) {
				intersection.add(s);
			}
			union.add(s);
		}

		for (String s : multiset2) {			
			union.add(s);
		}
		

		
		float calc = 0;
		if (union.size() == 0) calc = 1;
		else calc = (float) intersection.size() / (float) union.size();

		return (int) (calc * 65536);
	}

	public static void main(String[] args) {
		Ex21 sol = new Ex21();

		String str1 = "FRANCE";
		String str2 = "french";
		System.out.println(sol.solution(str1, str2)); 

	}

}
