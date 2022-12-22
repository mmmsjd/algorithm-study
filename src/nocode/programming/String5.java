package nocode.programming;

// 3. Longest substring w/o repeating characters

// 주어진 문자열에서 겹치지 않는(문자 반복불가) 문자를 만들어내는데 
// 가장 긴 문자열을 반환하는 문제

// case : brute-force 두개 pointer(앞뒤) + 이중for문 +  길이와 반복을 체크(length, repeat) -> O(n^3)
// case : 두개 pointer(앞앞) 이 더 효율적
// └ 추가 변수를 이용 = maxlength, begin, finish + hashMap



public class String5 {

	public static void main(String[] args) {

		String strs = "abcdeca";
		
		System.out.println(LongestSubstring(strs));

	}

	private static String LongestSubstring(String strs) {
		String answer = "";
		return answer;
		
	}
	

}
