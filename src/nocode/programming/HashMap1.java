package nocode.programming;

// hashMap(hash table) -> find O(1) 바로 찾는다..
// bucket 초기값 -> 커지면 new bucket resize

// case: Two Sum 문제 (해시사용)
// └ hashMap 을 만들때 옵티마이제이션(최적화)를 통해 생성한다면 
// 		더 좋은 성능을 낼수 있음.
// 		ex) {13,7,5,1,3,2}, n=10;
//			key 는 필요한 숫자 -13 - 10 = -3 
//			value -13 의 IDX 를 넣어서 사용하면 더 빠름 
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
