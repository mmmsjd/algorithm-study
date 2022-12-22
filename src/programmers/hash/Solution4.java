package programmers.hash;

import java.util.HashSet;

// 해시 4.포켓몬
public class Solution4 {
	public int solution(int[] nums) {
		int answer = 0;
		
		// 단순화 
		// 1. n/2 마리만 가져갈수 있다. max 값 도출
		int max = nums.length / 2;
		System.out.println(max);
		
		// 2. 유형별로 중복제거 해서 넣어둠.
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		for (Integer integer : set) {
			answer++;
		}
		if(answer > max) 
			answer = max;

        return answer;
    }
	
	
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		
		int[] nums = {3,3,3,2,2,2};
		
		System.out.println(sol.solution(nums));

	}

}
