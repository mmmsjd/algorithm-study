package nocode.programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// Top K Frequent Element
// + sorting rule

// �ݺ��� ������ k ���� ū ���ڸ� ��ȯ�ϸ� �Ǵ� ���� 

// case : map �� key ������ count + map �� ������ sorting �ϸ鼭 �迭 �����1
// case : map �� key ������ count + map �� ������ sorting �ϸ鼭 �迭 �����2

// case : ����Ʈ�� Top k �� ���� 

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
