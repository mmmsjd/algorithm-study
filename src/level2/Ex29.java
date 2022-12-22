package level2;

import java.util.ArrayList;
import java.util.List;

//스킬트리

/*
 * 선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 

라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 

썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.

선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 

가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
*/

public class Ex29 {

//	private int answer;
//	private List<Character> order = new ArrayList<>();
//
//	public int solution2(String skill, String[] skill_trees) {
//		for (char ch : skill.toCharArray()) {
//			order.add(ch);//CBD
//		}
//		for (String skills : skill_trees) {
//			System.out.println();
//			System.out.println("--------------------------------------------------");
//			System.out.println(skills);
//			System.out.println("--------------------------------------------------");
//			
//			if (isAvailable(skills)) {
//				answer++;	
//			}			
//		}
//		return answer;
//	}
//
//	private boolean isAvailable(String skills) {
//		boolean[] visited = new boolean[order.size()];
//		
//		for (char skill : skills.toCharArray()) {
//			if (!order.contains(skill)) { // 존재 안하면 OK
//				continue;				
//			}
//			
//			int loop = order.indexOf(skill); // 인덱스 체크가 (핵심1)
//			System.out.println(skill+" "+loop);
//			
//			for (int i = 0; i < loop; i++) { // 존재하면 이전노드 방문여부 탐색(핵심2) 0 < 현재인덱스 까지 loop
//				if (!visited[i]) {
//					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>탈락");
//					return false;				
//				}
//			}
//			visited[loop] = true; //(핵심3)
//			
//		}
//		return true;
//	}

/*
 * 아이디어 
 * visit 배열 체크 loop 를 최초 index 부터 현재 index 까지만 확인
 * 
 * 
 */
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		List<Character> order = new ArrayList<>();
		
		for (Character ch : skill.toCharArray()) {
			order.add(ch);
		}
		
		for (String skills : skill_trees) {
			int no = 0;
			
			boolean[] visited = new boolean[order.size()];			
			for(Character c :skills.toCharArray()) {
				if(!order.contains(c)) {
					continue;
				}
				int skill_index = order.indexOf(c); // 인덱스 체크가 (핵심1)
				for (int i = 0; i < skill_index; i++) {
					if (!visited[i]) {
						no++;
						break;
					}
				}
				visited[skill_index] = true; //(핵심2)
			}
			if(no == 0) answer++;
		}
		return answer;
	}

	public static void main(String[] args) {
		Ex29 sol = new Ex29();
		
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		System.out.println(sol.solution(skill, skill_trees)); 

	}

}
