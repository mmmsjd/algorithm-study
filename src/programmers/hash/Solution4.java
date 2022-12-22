package programmers.hash;

import java.util.HashSet;

// �ؽ� 4.���ϸ�
public class Solution4 {
	public int solution(int[] nums) {
		int answer = 0;
		
		// �ܼ�ȭ 
		// 1. n/2 ������ �������� �ִ�. max �� ����
		int max = nums.length / 2;
		System.out.println(max);
		
		// 2. �������� �ߺ����� �ؼ� �־��.
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
