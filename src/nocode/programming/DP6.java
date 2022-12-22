package nocode.programming;
 
// 152. Maximum Product SubArray
// ����*������ ��� 
// ��ȭ�� 3���� ���ü� �ִ� ���� ���ø��� �˾ƾ���.

// DPmin(n) = min(DPmin(n-1) * num[n], DPmax(n-1) * num[n], num[n])
// DPmax(n) = max(DPmin(n-1) * num[n], DPmax(n-1) * num[n], num[n])



public class DP6 {
	
	public static void main(String[] args) {
		int[] nums = {3, -2, 1, 0, -8, -9};

		System.out.println(maxProducArray(nums));

	}
	
	private static int maxProducArray(int[] nums) {
		
		int len = nums.length;
		
		int[] dpMin = new int[len];
		int[] dpMax = new int[len];
				
		dpMin[0] = nums[0];
		dpMax[0] = nums[0];
		
		for (int i = 1; i < len; i++) {
			dpMin[i] =  Math.min(dpMin[i-1] * nums[i],  Math.min(dpMax[i-1] * nums[i], nums[i]));
			dpMax[i] =  Math.max(dpMin[i-1] * nums[i],  Math.max(dpMax[i-1] * nums[i], nums[i]));
		}

		return dpMax[len-1];
	}

}
