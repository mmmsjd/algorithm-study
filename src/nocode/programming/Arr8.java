package nocode.programming;

import java.util.Arrays;
import java.util.HashMap;

// Leetcode - 442.find duplicates

// {1~n} add i = {n+1}
// {1,2,3,4,2}

// 
// 1.배열을 앞뒤로 point를 올려가면서 값을 확인해서 같은 값이면 반환하면 정답->이중for문 O(n^2)
// 2.정렬 해서 인접한 두숫자가 같은지 체크 같으면 정답->정렬(nlogn)+n = O(nlgn)
// 3.hash 에 add 하면서 count 해서  이미있는 값이라면 index 가 정답->(비둘기 집 이론)->O(n)
// 4.비둘기 집 이론 -> 확장된 형태 새로 array 를 따로 생성하지 않고 -음수 마크를 이용해서 사용한다.
// 5.더 확장된 방안이 존재한다 graph 에서 다룬다.
public class Arr8 {

	public static void main(String[] args) {

//		int[] nums = {1,2,3,5,4,2};		
		int[] nums = {5,4,3,2,1,3};
		System.out.println(duplicates4(nums));
	}

	private static int duplicates4(int[] nums) {
		int answer = 0;
		
		int index = 0;
		while(index <= nums.length-1) {
			int value = nums[index];
			value = value < 0 ? value *= -1: value;
			if(nums[value] < 0) {
				answer = value;
			}else {
				nums[value] *= -1;
			}
			index++;
		}
		
//		for (int i = 0; i <= nums.length-1; i++) {
//			int value = nums[i];
//			value = value < 0 ? value *= -1: value;
//			if(nums[value] < 0) {
//				answer = value;
//			}else {
//				nums[value] *= -1;
//			}
//		}
		return answer;
	}
	private static int duplicates3(int[] nums) {
		int answer = 0;
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int num : nums) {
			String key = String.valueOf(num);
			if(map.containsKey(key)){
				answer = num;
				break;
			}else {
				map.put(key, num);
			}
		}
		
		return answer;
	}
	private static int duplicates2(int[] nums) {
		
		Arrays.sort(nums);
		int answer = 0;
		int index = 0;
		
		while (index < nums.length) {
			if(nums[index] == nums[index+1]) {
				answer = nums[index];
				break;
			}
			index++;
		}
		return answer;
	}
	private static int duplicates1(int[] nums) {
		int answer = 0;
		for (int i = 0; i < nums.length; i++) {
			int compare = nums[i];
			for(int j=nums.length-1;j>=0;--j){
				if(compare == nums[j]) {
					answer = nums[j];
					break;
				}
			}
		}
		
		return answer;
	}


}
