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
			if (nums[left] > nums[left+1]) // �տ������� ���� ���� �� �������� ��ũ�� ���� case ���� left=1
				break;
			
			left++;
		}
		while(right > 0) {
			if (nums[right-1] > nums[right]) // �ڿ������� ���� ���� �� ���� ���� ��ũ�� ���� case ���� right=7-2=5
				break;
			
			right--;
			
		}
		// case 1 < 5 = 5-1+1 = 5
		return (left < right) ? right - left + 1 : 0;
	}

}
