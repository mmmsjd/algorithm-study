package kakao2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// 신고 결과 받기
public class Solution4 {

	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		HashMap<String, HashSet<String>> reportMerge = new HashMap<>();
		HashMap<String, Integer> reportBlackCount= new HashMap<>();
		HashSet<String> reportTmp = new HashSet<>(Arrays.asList(report));
		
		for (String string : reportTmp) {
			String user 		= string.split(" ")[0];
			String blackUser 	= string.split(" ")[1];
			
			reportMerge.putIfAbsent(user, new HashSet<String>(){{add(blackUser);}});
			reportMerge.get(user).add(blackUser);
            
			reportBlackCount.put(blackUser, reportBlackCount.getOrDefault(blackUser, 0) + 1);
		}
//		System.out.println(reportMerge.toString());
//		System.out.println(reportBlackCount.toString());
       
		for (String blackUser : reportBlackCount.keySet()) {
			int blackCount = reportBlackCount.get(blackUser);
			if(blackCount >= k) {
				
				for (int i = 0; i < id_list.length; i++) {
					if(reportMerge.containsKey(id_list[i]) && reportMerge.get(id_list[i]).contains(blackUser) ){
                        answer[i]++;
                    }
				}
			}
		}
		return answer;
    }
	
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		System.out.println(sol.solution(id_list, report, k));
	}

}
