package nocode.programming;

// zero moves
public class Arr1 {

	public static void main(String[] args) {

		int[] nums = {0,5,0,7,6,3};
		moveZeroes(nums);
		
		for (int i : nums) {			
			System.out.print(i);
		}

	}


	private static void moveZeroes2(int[] nums) {
		int wIdx = 0;
		for (int idx = 0; idx < nums.length; idx++) {
			if(nums[idx] !=0) {
				nums[wIdx] = nums[idx];
				wIdx++;
			}
		}
		for (; wIdx < nums.length; wIdx++) {
			nums[wIdx] = 0;
		}
	}
	
	private static void moveZeroes(int[] nums) {
		int wIdx = 0;
		for (int idx = 0; idx < nums.length; idx++) {
			if(nums[idx] !=0) {
				swap(nums, wIdx, idx);
				wIdx++;
			}
		}
	}
	
 	private static void swap(int[] nums, int i, int j) {
 		int temp = nums[i];
 		nums[i] = nums[j];
 		nums[j] = temp;
 	}
}
