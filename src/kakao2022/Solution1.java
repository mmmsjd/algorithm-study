package kakao2022;

import java.util.HashMap;

// ���� ���� �˻��ϱ�

public class Solution1 {
	
//	��ǥ ��ȣ	���� ����
//	1�� ��ǥ	���̾���(R), Ʃ����(T)
//	2�� ��ǥ	����(C), ���ε���(F)
//	3�� ��ǥ	��������(J), ������(M)
//	4�� ��ǥ	����ġ��(A), �׿���(N)
	
//	choices	��
//	1	�ſ� ����
//	2	����
//	3	�ణ ����
//	4	�𸣰���
//	5	�ణ ����
//	6	����
//	7	�ſ� ����
	
	
	public String solution(String[] survey, int[] choices) {
			
		HashMap<String, Integer> map  = new HashMap<>();
		
		for (int i = 0; i < survey.length; i++) {
			String sur 	= survey[i];
			int choice 	= choices[i];			
			map.put(sur, map.getOrDefault(sur, 0) + setPoint(choice));				
		}		
		
		map.put("RT", map.getOrDefault("RT", 0) + (map.getOrDefault("TR", 0) * -1));
		map.put("CF", map.getOrDefault("CF", 0) + (map.getOrDefault("FC", 0) * -1));
		map.put("JM", map.getOrDefault("JM", 0) + (map.getOrDefault("MJ", 0) * -1));
		map.put("AN", map.getOrDefault("AN", 0) + (map.getOrDefault("NA", 0) * -1));
		
		map.remove("TR");
		map.remove("FC");
		map.remove("MJ");
		map.remove("NA");
		
		StringBuilder sb = new StringBuilder();
		String[] idx = {"RT","CF","JM","AN"};
		for (int i = 0; i < idx.length; i++) {
			int value = map.get(idx[i]);
			
			if(value <= 0) {
				sb.append(idx[i].charAt(0));
			}else {
				sb.append(idx[i].charAt(1));
			}
		}
		
        return sb.toString();
    }
	
	private int setPoint(int i) {
		if(i == 1) return -3;
		else if(i == 2) return -2;
		else if(i == 3) return -1;
		else if(i == 4) return 0;
		else if(i == 5) return 1;
		else if(i == 6) return 2;
		else if(i == 7) return 3;
		else return 0;
	}


	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		
//		System.out.println(0 * -1);
//		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		String[] survey = {"TR", "RT", "TR"};
//		int[] choices = {5, 3, 2, 7, 5};
		int[] choices = {7, 1, 3};
		
//		������ �ᱣ�� "RFMA"�� ��� "TCMA"�� �ٸ��ϴ�.
		
		System.out.println(sol.solution(survey, choices));
	}

}
