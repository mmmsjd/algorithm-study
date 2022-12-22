package nocode.programming;

// 53. Maximum SubArray
// ������ ��ȯ�� �ʿ�..
/**
 * SubArray �� ������ element ���� �����Ͽ� ����Ͽ� ������ �ϸ� DP�� ���� 
 * @author minsoo
 */

// case : brute-force ȿ�������� ������ �����غ���.
// case : maxValueArray + startPointer (Kadane's algorithm:ī����)


 

public class DP5 {
	
	public static void main(String[] args) {
		int[] nums = {5, -2, 9, -15, 8};
		
		System.out.println(bruteForce(nums));//O(n^2)
		
//		System.out.println(maxValueArray(nums));

	}
	
	private static int maxValueArray(int[] nums) {
		int len = nums.length;
		int[] dpArray = new int[len];
		dpArray[0] = nums[0];
		
		for (int i = 1; i < len; i++) {
			
			int prevMax = dpArray[i-1];
			int currVal = nums[i];
			
			int connSum = prevMax + currVal;
			int maxSub = Math.max(connSum, currVal);
			
			dpArray[i] = maxSub;
			
		}
		int maxSum = 0;
		for(int val:dpArray) {
			if(maxSum < val) {
				maxSum = val;
			}
		}
		
		return maxSum;
	}

	// {5, -2, 9, -15, 8};
	//  5, 3, 12, -3, 5
	private static int bruteForce(int[] nums) {
		int len = nums.length;

		
		int idx1 = 0;
		int idx2 = 1;
		int sum = 0;
		int max = 0;
		while(idx1 < len) {
			sum += nums[idx1++];
			max = Math.max(sum, max);
			
			while(idx2 < len) {
				sum += nums[idx2++];				
				max = Math.max(sum, max);
			}
		}
		
		return max;
	}
	
}
