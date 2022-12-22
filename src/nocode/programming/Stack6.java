package nocode.programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 739. Daily Temperatures (Distance to gueater number)
// 뒤에오는 큰숫자와의 거리 계산

// case : brute-force 2 pointer 이중 for문
// case : stack


public class Stack6 {

	public static void main(String[] args) {


		int[] nums = {39, 20, 70, 36, 30, 60, 80, 1};

//		Integer[] answer = brute(nums);//21421100
		int[] answer = stack(nums);
		
		for(Integer i: answer) {			
			System.out.print(i);
		}

	}

	private static int[] stack(int[] nums) {
//		List<Integer> list = new ArrayList<>();
		
		int[] result = new int[nums.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < nums.length; i++){
            while(!stack.empty() && nums[stack.peek()] < nums[i]){
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

		
		
		return result;
	}
	static class Node{
		int value;
		int index;
		public Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	private static Integer[] brute(int[] nums) {
		int min = 1;
		List<Integer> list = new ArrayList<>();
		
		int idx1 = 0;
		while(idx1 < nums.length) {
			int count = 0;
			int idx2 = idx1+1;
			int prev = nums[idx1++];
			
			while(idx2 < nums.length) {
				int next = nums[idx2++];
				if(next <= min) break;
				count++;
				
				if(prev < next) {
					break;
				}
				
			}
			list.add(count);
			
		}
		
		Integer[] answer = list.stream().toArray(Integer[]::new);
		
		return answer;
		
	}
	

}
