package nocode.programming;

// find peek element 


public class Arr5 {

	public static void main(String[] args) {

		int[] nums = {1,3,2,4,5,7,6};
		
		System.out.println(findPeekElement(nums));

	}

	private static int findPeekElement(int[] nums) {
		
		int left = 0;
		int right = nums.length -1;
		
		if(nums.length <= 1) return 0;
		
		while(left < right) {
			int pivot = (left+right) /2;
			int num = nums[pivot];
			int nextnum = nums[pivot+1];
			
			if(num < nextnum) {
				left = pivot+1;
			}else {
				right = pivot;
			}
		}
		return left;
		
	}

}
