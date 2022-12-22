package nocode.programming;

// shortest Unsorted Cotinuous Subarray

// 

public class Arr7 {

	public static void main(String[] args) {

		int[] nums = {2,6,4,8,10,9,15};		
		System.out.println(subarray(nums));
	}

	private static int subarray(int[] nums) {
		
		int left = 0;
		int right = nums.length-1;
		
		if (left == right)
			return 0;
		
		while (left < right) {
			if (nums[left] > nums[left+1]) // 앞에서부터 이전 값과 비교 이전값이 더크면 종료 case 에선 left=1
				break;
			
			left++;
		}
		while(right > 0) {
			if (nums[right-1] > nums[right]) // 뒤에서부터 앞의 값과 비교 앞의 값이 더크면 종료 case 에선 right=7-2=5
				break;
			
			right--;
			
		}
		// case 1 < 5 = 5-1+1 = 5
		return (left < right) ? right - left + 1 : 0;
	}

}
