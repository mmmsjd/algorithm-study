package nocode.programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 139. Word Break
// 주어지는 단어 문자열들로 해당 문자를 만들수 있는지 체크

// case : brute 비효율
// case : recursive 비효율 O(2^n)
// case : dp 


public class DP8 {
	
	public static void main(String[] args) {
		String word = "nocope";
		String[] dict = {"e","no","cop"};
		
//		System.out.println(wordBreak(word, dict));
		System.out.println(wordBreak검색된답(word, dict));// 더 효율적 O(n^2)
	}

	public static boolean wordBreak검색된답(String s, String[] wordDict) {
		
        HashSet<String> hs = new HashSet<>();
        for(String str : wordDict) hs.add(str);
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
        	
            for(int j = i - 1; j >= 0; j--){
            	String sss = s.substring(j, i);
            	System.out.println(sss);
            	
                if(dp[j] && hs.contains(sss)){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
	
	private static boolean wordBreak(String str, String[] dict) {
		Set<String> wordSet = new HashSet<>();
		for(String word: dict) {
			wordSet.add(word);
		}
		
		int len = str.length();
		boolean[] dp = new boolean[len+1];
		dp[0] = true;
		
		
		for (int i = 1; i < dp.length; i++) {
			for(String word: wordSet) {
				int wordLen = word.length();
				int prevIdx = i - wordLen;

				if(prevIdx < 0) {
					continue;
				}
				if(!dp[prevIdx]) {
					continue;
				}
				System.out.print("("+prevIdx);
				System.out.print(",");
				System.out.print(i+")");
				
				String s = String.valueOf(Arrays.copyOfRange(str.toCharArray(), prevIdx, i));
				
				if(s.equals(word)) {
					System.out.print("="+s);
					dp[i] = true;
					break;
				}
			}
			System.out.println();
			
		}
		for(boolean b:dp) {
			System.out.print(b);
			System.out.print(",");
		}
		System.out.println();
		//true,false,true,false,false,true,true
		return dp[len];
		
	}

}
