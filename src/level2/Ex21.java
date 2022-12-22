package level2;

import java.util.ArrayList;
import java.util.Collections;

//[1��] ���� Ŭ�����͸�
/**
 * List�� �ߺ���� �ϱ⿡ ������������ ���� ����.
 *	for (String s : multiset1) {
		if (multiset2.remove(s)) { //�����ϸ� ������(remove �ؾ�? ���� �����ո� �����ϸ� ���ص� �Ǵµ� �Ʒ� �������� �����ؼ� remove)
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

		// ��ȿ�� �����ؼ� Set
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
		 * �������� A = {1, 1, 2, 2, 3}, 
		 * �������� B = {1, 2, 2, 4, 5}��� �ϸ�, 
		 * ������ A �� B = {1, 2, 2}, 
		 * ������ A �� B = {1, 1, 2, 2, 3, 4, 5}�� �ǹǷ�, 
		 * ��ī�� ���絵 J(A, B) = 3/7, �� 0.42�� �ȴ�
		 * 
		 * ���� {FR, RA, AN, NC, CE}, {FR, RE, EN, NC, CH}�� �Ǹ�, 
		 * �������� {FR, NC}, 
		 * �������� {FR, RA, AN, NC, CE, RE, EN, CH}�� �ǹǷ�, 
		 * �� ���ڿ� ������ ��ī�� ���絵 J("FRANCE", "FRENCH") = 2/8 = 0.25�� �ȴ�.
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
