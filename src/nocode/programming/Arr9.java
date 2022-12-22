package nocode.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* 
 * 1) 1. Two sum :  Ư������ ���ڷ� �ָ� ����� �ΰ��� ���ؼ� ���� ���ڿ� �������� index �� �����Ͻÿ�. 
 target number �� �Ǵ� �迭�� index1, index2 �� ��ȯ�ϴ� ����

// 1.hashmap �� �̿��� Ǯ�� -> O(n)
	// ����
// 2.brote-force pointer 2�ΰ��� num1+num2 == target ->O(n^2)
	// ����
// 3.sorting �ϰ� pointer 2�ΰ��� �ڿ������� �ٿ�������. ->O(nlogn)
	// ����
*/

/*
 * 2) advens problme : 16. 3Sum Closest : 3���� sum �� 0�̵Ǵ� ������ ��� ã�ƶ�.
 * 1. brote-force pointer 2�ΰ�
 *  //index �� ã�� ������ �ƴ϶� ���� ã�� ���� �׷��Ƿ� sort �� �ص� ����
 * 	// 1=����
 * 2. �ٸ� ���?
 */
	
	

/*
 * 3) advens problme : 18. 4Sum
 */

public class Arr9 {

	public static void main(String[] args) {

		// 2sum
//		int[] nums = {1, 3, 7, 4, 8};
//		int target = 5;
//		System.out.println(twoSum3(nums, target));
		
		// 3sum ���� ���� 
//		int[] nums2 = {2, 5, 1, -1, -7, 3};//-7,-1, 1, 2, 3, 5
//		int target2 = 0;
//		System.out.println(threeSumEx(nums2, target2));
		
		// 3sum 3���� sum �� 0�̵Ǵ� ������ ��� ã�ƶ�. 
		int[] nums = {-1, 0, 1, 2, -1, 4};//-1, -1, 0, 1, 2, 4
											
		int target = 0;
		int[][] result = threeSum2(nums, target);
		
		for (int[] i : result) {
			for (int integer : i) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}
		
	}
	
	private static int[][] threeSum2(int[] nums, int target) {
		
		
		return null;
	}
	private static int[][] threeSum(int[] nums, int target) {
		Arrays.sort(nums);
		
		ArrayList<String> result = new ArrayList<>();
		
		for (int point = 0; point < nums.length; point++) {
			
			int left = point+1;
			int right = nums.length-1;
			while(left < nums.length-1) {
				if(point == right) break;
				int sum = nums[point] + nums[left] + nums[right];
				if(sum == target){
					StringBuilder sb = new StringBuilder();
					sb.append(nums[point]+",");
					sb.append(nums[left]+",");
					sb.append(nums[right]);
					
					result.add(sb.toString());
					break;
					
				}else if(sum > target) {// Ÿ�ٺ��� ũ�� �������� ��õ� 				
					right--;
				}else if(sum < target) {// Ÿ�ٺ��� ������ ū���� ��õ�				
					left++;
				}
			}
		}
		int[][] answer = new int[result.size()][3];
		
		for (int i = 0; i < result.size(); i++) {
			String[] str = result.get(i).split(",");
			answer[i][0] = Integer.parseInt(str[0]);
			answer[i][1] = Integer.parseInt(str[1]);
			answer[i][2] = Integer.parseInt(str[2]);
		}
		
		return answer;
	}

	private static int[] threeSumEx(int[] nums, int target) {
		int[] answer = new int[3];
		
		Arrays.sort(nums);
		
		int fixed = 0;
		int left = fixed+1;
		int right = nums.length-1;
		
		while(left < nums.length-1) {
			if(nums[fixed] + nums[left] + nums[right] == target){
				answer[0] = fixed;
				answer[1] = left;
				answer[2] = right;
				break;
				
			}else if(nums[fixed] + nums[left] + nums[right] > target) {// Ÿ�ٺ��� ũ�� �������� ��õ� 
				
				right--;
				
			}else if(nums[fixed] + nums[left] + nums[right] < target) {// Ÿ�ٺ��� ������ ū���� ��õ�
				
				left++;
				
			}
		}
		
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		System.out.println(answer[2]);
		
		return answer;
	}

	private static int[] twoSum3(int[] nums, int target) {
		int[] answer = new int[2];
		Arrays.sort(nums);
		
		int left = 0;
		int right = nums.length-1;
		
		while(left < nums.length-1) {
			if(nums[left] + nums[right] == target){
				answer[0] = left;
				answer[1] = right;
				break;
				
			}else if(nums[left] + nums[right] > target) {// Ÿ�ٺ��� ũ�� �������� ��õ� 
				right--;
			}else if(nums[left] + nums[right] < target) {// Ÿ�ٺ��� ������ ū���� ��õ�
				left++;
			}
		}
		
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		
		return answer;
	}

	private static int[] twoSum2(int[] nums, int target) {
		int[] answer = new int[2];
		
		int len = nums.length-1;
		
		for (int i = 0; i < len; i++) {
			for(int j = len;j > 0; --j) {
				if(nums[i]+nums[j] == target){
					answer[0] = i;
					answer[1] = j;
					break;
				}
			}
		}
		
//		int left = 0;
//		int right = len;
//		
//		while (left < len) {
//			int num1 = nums[left];
//			int num2 = 0;
//			
//			while(right > 0) {
//				num2 = nums[right];
//				
//				if(num1+num2 == target){
//					answer[0] = left;
//					answer[1] = right;
//					break;
//				}
//				right--;
//			}
//			
//			right = len;
//			left++;
//		}
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		
		return answer;
	}

	//hashMap 
	private static int[] twoSum1(int[] nums, int target) {
		int[] answer = new int[2];
		
		HashMap<Integer, Integer> map = new HashMap<>();
		// set
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);// key=��, value=�ε���
		}
		for (int i = 0; i < nums.length; i++) {
			int diff = target-nums[i];
			if(map.containsKey(diff)) {
				if(map.get(diff) == i) {
					continue;
				}
				answer[0] = map.get(diff);
				answer[1] = i;
				break;
			}
		}
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		
		return answer;
	}


}
