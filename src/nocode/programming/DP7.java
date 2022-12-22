package nocode.programming;
 
// 5. Longest Palindromic SubString
// 647. Palindromic SubString

// Palindromic 성질 앞에서 읽을때와 뒤에서 읽을 때 같은 문자 중 가장긴 문자 

// [aabcbad] -> abcba

// case : brute-force 이중for 문 O(n^3), 1: 2points 끝에서 부터 하거나 중간에서 부터 양옆으로 확인 = OK
// case : dp matrix 
/*
baabc
----
  0  1  2  3  4
0[1, 0, 0, 4, 0],
1[0, 1, 2, 0, 0],
2[0, 0, 1, 0, 0],
3[0, 0, 0, 1, 0],
4[0, 0, 0, 0, 1]
*/





public class DP7 {
	
	public static void main(String[] args) {
		String s = "baabc";

//		System.out.println(isPalindromic("babad"));
//		System.out.println(bruteForce(s));
		
		System.out.println(dp(s));

	}
	
	// 하 dynamic 어렵네.. ㅆㅂ
	private static String dp(String s) {
		int len = s.length();
		int[][] dpTable = new int[len][len];
		
		for (int i = 0; i < len; i++) { // 모두 1로시작 문자하나도 palindromic 하다.
			dpTable[i][i] = 1;
		}
		
		for (int i = 0; i < len-1; i++) { // 두문자 까지만 비교 
			char start = s.charAt(i);
			char end = s.charAt(i+1);

			if (start == end) {
				dpTable[i][i+1] = 2;
			}
		}
		for (int i = 2; i < len; i++) { //두번째 부터 시작
			int row = 0;
			int col = i;
			while(col < len) {
				char start = s.charAt(row);
				char end = s.charAt(col);
				int prevCount = dpTable[row+1][col-1];
				
				if(start == end && prevCount != 0) {
					dpTable[row][col] = prevCount +2;
				}
				row++;
				col++;
			}
		}
		// 피니쉬
		int maxLen = 0;
		int start = 0;
		int end = 0;
		
		for (int row = 0; row < len; row++) {
			for (int col = 0; col < len; col++) {
				int currLen = dpTable[row][col];
				if(maxLen < currLen) {
					maxLen = currLen;
					start = row;
					end = col;
				}
				
			}
		}
		
		return s.substring(start, end+1);
	}

	private static String bruteForce(String s) {
		int len = s.length();
		int maxLen = 0;
		String maxSub = "";
		
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len+1; j++) {
				String sub = s.substring(i, j);
//				System.out.println(sub);
				if(isPalindromic(sub)) {
					if(maxLen < sub.length()) {
						maxLen = sub.length();
						maxSub = sub;
					}
				}
			}
		}
		return maxSub;
	}

	private static boolean isPalindromic(String sub) {
		int subLen = sub.length();
		int fIdx = 0;
		int lIdx = subLen-1;
		int mid = (subLen / 2);
		
		if(subLen == 1) return true;		
		if(subLen % 2 == 0) {
			boolean ret = true;
			while(fIdx < mid) {
				char first = sub.charAt(fIdx);
				char last = sub.charAt(lIdx);
				
				if(first != last){
					return false;
				}
				fIdx++;
				lIdx--;
			}
			return ret;
			
		}else {
			boolean ret = true;
	
			while(fIdx < mid) {
				if(fIdx == lIdx) {
					break;
				}
				char first = sub.charAt(fIdx);
				char last = sub.charAt(lIdx);
				
				if(first != last){
					return false;
				}		
				fIdx++;
				lIdx--;
			}
			return ret;
		}
	}

}
