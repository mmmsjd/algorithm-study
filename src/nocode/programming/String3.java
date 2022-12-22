package nocode.programming;

import java.util.ArrayList;
import java.util.Collections;

// 415. Add Strings
// String 타입의 두값을 더하여서 리턴하라(단, Integer 로 변환하지말고 String 자체로해라.)

// case : carry 비트를 사용하는 방법

public class String3 {

	public static void main(String[] args) {


		String nums1 = "3850";
		String nums2 = "273";
		System.out.println(Palindrome(nums1, nums2));

	}

	private static String Palindrome(String nums1, String nums2) {
		String answer = "";
		String[] arr1 = nums1.split("");
		String[] arr2 = nums2.split("");
		
		
		// 1. carry 용 변수를 선언한다.		
		// 2. 더하기 연산을 해서 n/10 과 n%10 연산을 해서 구하여 Array에 넣어준다.
		// 3. reverse 하여 리턴한다.
		
		ArrayList<String> list = new ArrayList<>();
		
		int idx = 0;
		int carry = 0;// 자리바꿈수
		
		while(idx <= arr1.length-1) {
			int num1 = 0;
			int num2 = 0;
			
			if(idx <= arr1.length-1) num1 = Integer.parseInt(arr1[arr1.length-1-idx]);
			if(idx <= arr2.length-1) num2 = Integer.parseInt(arr2[arr2.length-1-idx]);
				
			int union = num1 + num2;
			
			int val 	= carry + union;
			int result 	= val % 10;
			carry 		= val / 10;
			
			list.add(String.valueOf(result));	
			
			idx++;
		}
		System.out.println(list.toString());
		
		Collections.reverse(list);
		for (String string : list) {
			answer += string;
		}
		
		return answer;
		
	}
	

}
