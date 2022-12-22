package nocode.programming;

// ★유명한 문제 
// 1143. Longest Common Subsequence(subArray 는 연속되어야 하지만 sequence 는 연속적이지 않아도 된다.)

/*
 * dp(m,n) = 	if A[n] == B[n]
 * 					dp(m-1, n-1) +1
 * 				else
 * 					max(dp[m-1], n), dp(m. n-1)
 */


public class DP12 {
	 
	public static void main(String[] args) {

		String str1 = "abdcg";
		String str2 = "bdag";
		
		subSequence(str1, str2);
		
	}

	private static int subSequence(String str1, String str2) {
		
		return 0;
		
	}
	
}

//from typing import List   
//
//def longestCommonSubsequence(text1: str, text2: str) -> int:
//  dp_table = [[0]*(len(text1)+1) for j in range(len(text2)+1)]
//  
//  for rowIdx in range(1,len(dp_table)):
//    prev_row = rowIdx - 1
//    char2 = text2[rowIdx-1]
//    for colIdx in range(1,len(dp_table[rowIdx])):
//      prev_col = colIdx-1
//      char1 = text1[colIdx-1]
//      
//      dp = 0
//      if char1 == char2:
//        dp = dp_table[prev_row][prev_col] + 1
//      else:
//        dp = max(dp_table[prev_row][colIdx], dp_table[rowIdx][prev_col])        
//      dp_table[rowIdx][colIdx] = dp
//  return dp_table[-1][-1]  #return last dp table elem 
