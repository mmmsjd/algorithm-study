package nocode.programming;

// merge sorted array

public class Arr4 {

	public static void main(String[] args) {

		
		int[] nums1 = {1,3,5,0,0,0};
		int[] nums2 = {2,4,6};
		
//		int[] nums1 = {1,2,3,0,0,0};
//		int[] nums2 = {4,5,6};
		
		int m = 3;
		int n = 3;
		
		basic(nums1, nums2, m, n);
		
//		mergeSortArray(nums1, nums2, m, n);

	}

	private static void mergeSortArray(int[] nums1, int[] nums2, int m, int n) {
		
		int num1Idx = m-1;
		int num2Idx = n-1;
		int wIdx = nums1.length -1;
		
		if(num2Idx < 0) {
			return;
		}
		while (0 <= num1Idx && 0 <= num2Idx) {//둘다 0보다 크거나 같은경우 계속 반복(하나라도 -1 면 빠져나와 
			int num1 = nums1[num1Idx];
			int num2 = nums2[num2Idx];

			if(num2 <= num1) {
				int num = num1;
				nums1[wIdx] = num;// 현재값
				num1Idx--;
				wIdx--;
				
			}else {
				int num = num2;
				nums1[wIdx] = num;// 현재값
				num2Idx--;
				wIdx--;
			}
			System.out.print(num1Idx);
			System.out.print(" ");
			System.out.println(num2Idx);			
		}
		while (0 <= num2Idx) {
			nums1[wIdx] = nums2[num2Idx];
			num2Idx--;
			wIdx--; 
			
		}
		
		for (int i : nums1) {
			System.out.println(i);
		}
	}

	// 하 어렵다 썅
	private static void basic(int[] nums1, int[] nums2, int m, int n) {

		int num1Idx = 0;
		int num2Idx = 0;
		int[] answer = new int[m+n];
		
		
		int add = 0;
		while (add < m+n) {
			int num1 = nums1[num1Idx];
			int num2 = nums2[num2Idx];
			int num = 0;
			
			if(num2 >= num1 && num1Idx != m) {
				num = num1;
				num1Idx++;
			}else {
				num = num2;
				num2Idx++;
			}
			answer[add++] = num;
			
		}
		for (int i : answer) {
			System.out.println(i);
		}
	}

}
