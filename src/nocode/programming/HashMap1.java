package nocode.programming;

// hashMap(hash table) -> find O(1) �ٷ� ã�´�..
// bucket �ʱⰪ -> Ŀ���� new bucket resize

// case: Two Sum ���� (�ؽû��)
// �� hashMap �� ���鶧 ��Ƽ�������̼�(����ȭ)�� ���� �����Ѵٸ� 
// 		�� ���� ������ ���� ����.
// 		ex) {13,7,5,1,3,2}, n=10;
//			key �� �ʿ��� ���� -13 - 10 = -3 
//			value -13 �� IDX �� �־ ����ϸ� �� ���� 
//		key | value
//		-3  | 0
//		 3  | 1
//		 5  | 2
//		 9  | 3
//		 7  | 4
//		 8  | 5
		 
		 

public class HashMap1 {

	public static void main(String[] args) {

		
		System.out.println(23438498 % 10);
		System.out.println(4675330 % 10);

		int[] nums = {13,7,5,1,3,2};
		int n = 10;
		System.out.println(twosnum(nums));

	}

	private static String twosnum(int[] nums) {
		String answer = "";
		
		return answer;
		
	}
	

}
