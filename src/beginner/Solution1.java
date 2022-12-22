package beginner;

import java.util.Arrays;
import java.util.Collections;

// 옹알이 = 문법문제네..
/*
 괜히 어렵게 생각했네..
 연속된 조합은 불가 "aya+aya", "ye+ye", "woo+woo", "ma+ma"
 */

public class Solution1 {
	
	private int solution(String[] babbling) {
		String[] baby_word = {"aya", "ye", "woo", "ma"};
	    int answer = 0;
	     
	    for(String str : babbling) {
	    	String re = str;
	    	for (int i = 0; i < baby_word.length; i++) {
	    		String no = baby_word[i] + baby_word[i];
	    		if(str.contains(no)) {
	    			str.replace(str, "-1");
	    		}
			}
	    	
	    	Arrays.sort(baby_word);
			for(String yes : baby_word) {
				str = str.replace(yes, "");
            }
			
			Arrays.sort(baby_word, Collections.reverseOrder());			
			for(String yes : baby_word) {
				re = re.replace(yes, "");
            }
			
			if(str.length() == 0 && re.length() == 0 )answer++;
	    }
	    	
        return answer;

	}

	public static void main(String[] args) {
		Solution1 sol = new Solution1();

		String[] str = {"aya", "yee", "u", "maa", "wyeoo"};
		
		System.out.println(sol.solution(str));
	}
}
