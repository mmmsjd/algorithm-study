package kakao2022;

import java.util.HashMap;

// 성격 유형 검사하기

public class Solution1 {
	
//	지표 번호	성격 유형
//	1번 지표	라이언형(R), 튜브형(T)
//	2번 지표	콘형(C), 프로도형(F)
//	3번 지표	제이지형(J), 무지형(M)
//	4번 지표	어피치형(A), 네오형(N)
	
//	choices	뜻
//	1	매우 비동의
//	2	비동의
//	3	약간 비동의
//	4	모르겠음
//	5	약간 동의
//	6	동의
//	7	매우 동의
	
	
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
		
//		실행한 결괏값 "RFMA"이 기댓값 "TCMA"과 다릅니다.
		
		System.out.println(sol.solution(survey, choices));
	}

}
