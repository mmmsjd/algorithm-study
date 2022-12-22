package nocode.programming;

// sort colors (dutch flag problem)
// 앞뒤로 포인터 구현

public class Arr3 {

	public static void main(String[] args) {
		// 일반적인 sort 	= O(nlogn)
		// 간단한 풀이 		= O(n)
		// in-place swap  	= O(n)
		
		int[] nums = {1,0,2,2,0,1,2,1,0};
		
		int[] values = sortColorsBasic(nums);
		for (int i : values) {			
			System.out.print(i);
		}
		System.out.println();

		
		int[] values2 = sortColorsInplaceSwap(nums); //가 효율적 
		for (int i : values2) {
			System.out.print(i);
		}

		

	}
	// O(n)
	private static int[] sortColorsInplaceSwap(int[] nums) {
		int[] answer = new int[nums.length];
		// 0만 만나는 point swap 하면 +1
		// 2만 만나는 point swap 하면 -1
		
		int idx0 = 0; 				//0<주황 
		int idx2 = nums.length-1;	//초록<2
		int i = 0;					//핑크 swap
		
		while(i <= idx2) {
			if(nums[i] == 0) {
				swap(nums, i, idx0);
				idx0++;
				i++;
			}else if(nums[i] == 2){
				swap(nums, i, idx2);
				idx2--;
			}else {//nums[i] ==1
				i++;
			}
		}
		answer = nums;
		return answer;
	}
	
	private static void swap(int[] nums, int i, int j) {
 		int temp = nums[i];
 		nums[i] = nums[j];
 		nums[j] = temp;
 	}

	// O(n)
	private static int[] sortColorsBasic(int[] nums) {
		int[] answer = new int[nums.length];
		int a = 0, b = 0, c = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if(0 == nums[i]) a++;
			if(1 == nums[i]) b++;
			if(2 == nums[i]) c++;
		}
		int count = 0;
		for (; count < a; count++) {
			answer[count] = 0;
		}
		for (; count < a+b; count++) {
			answer[count] = 1;
		}
		for (; count < a+b+c; count++) {
			answer[count] = 2;
		}
		return answer;
		
	}
	

}
