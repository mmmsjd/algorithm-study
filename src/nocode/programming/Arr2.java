package nocode.programming;

import java.util.Arrays;

// find pivot index
// 오른쪽 숫자들의 합과 왼쪽 숫자들의 합이 같아지는 피벗의 위치 찾기
public class Arr2 {

	public static void main(String[] args) {

		// sliding = O(n)
		// brute-force = O(n^2)
		
		int[] nums = {1,8,2,9,2,3,6};
		
		int pivot = pivotIndexBruteForce(nums);
		System.out.println(pivot);
		
		int pivot_sliding = pivotIndex(nums); //가 효율적 
		System.out.println(pivot_sliding);
		
//		for (int i : nums) {			
//			System.out.print(i);
//		}

	}
	
	// brute-force
	private static int pivotIndexBruteForce(int[] nums) {
		
		for (int i = 0; i < nums.length; i++) {//o(n)
			int mid = 0;
			int leftsum = 0;
			int rightsum = 0;
			
			for (int j = 0; j < nums.length; j++) {//o(n)*n = o(n^2)
				if(i==j) {
					mid = nums[j];
				}else if(i < j) {
					leftsum += nums[j];
				}else {
					rightsum += nums[j];
				}
			}
			if(leftsum == rightsum) return i;
		}
		
		return -1;
	}

	// sliding
	private static int pivotIndex(int[] nums) {
		int sum = Arrays.stream(nums).sum();// int avg = (int) Arrays.stream(nums).average().orElse(0); //참고

		int leftSum = 0;
		int rightSum = sum;
		
		int prev = 0;//이전 num;
		
		for (int i = 0; i < nums.length; i++) { //오퍼레이션이 o(1)이고 n번이므로 o(n)
			int num = nums[i];
			
			leftSum = leftSum + prev; //left sum + prev num 
			rightSum = rightSum - num;//right sum - num
			
			if(leftSum == rightSum) {
				return i;
			}
			
			prev = num;
		}
		
		return -1;
	}

}
