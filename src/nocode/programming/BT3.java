package nocode.programming;

import java.util.ArrayList;
import java.util.List;

// 46. Permutations

// 중복되지 않는 문자중 겹치지 않는 문자를 모두 반환 즉, 자리만 바꿔서 조합을 만들어야 한다..
// part1 : 종료조건 파트 
// part2 : 프로세스 파트
// part3 : 재귀(recursion) 호출 파트 

// case : bt 로 푸는 방법
// case : 위 방법에서 개선하는 아이디어 
// └ 프로세스 파트에서 !containsb 인 경우를 걸러 냈는데 
// └ swap 을 통해 for 문을 사용하지 않아도 된다.
// a b c  라면 
// b a    를 swap
// c   a  를 swap
//   c b  를 swap
// 이렇게 swap 을 사용하면 프로세스 파트의 O(n) -> O(1)  으로 줄어들게 된다.




public class BT3 {
	
	
	public static void main(String[] args) {
		String[] num = {"a", "b", "c"};		//n!
				
		
		System.out.println(permutations(num));
		
	}

	private static String[] permutations(String[] num) {
		List<String> list = new ArrayList<>();
		
		bt(0, "", num, list);
		System.out.println(list.toString());
		
		return list.stream().toArray(String[]::new);
	}

	private static void bt(int idx, String letter, String[] num, List<String> list) {
		
		if(idx == num.length) {
			list.add(letter);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(String s: num) {
			if(!letter.contains(s)) {
				sb.append(s);
			}
		}
		String[] newnum = sb.toString().split("");
		
		for(String s: newnum) {
			bt(idx+1, letter + s, num, list);
		}
		
	}

}
