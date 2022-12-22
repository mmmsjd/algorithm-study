package level2;

import java.math.BigInteger;
import java.util.ArrayList;

//[3차] n진수 게임
/*
 * 진법변환 
 * 
 */
public class Ex28 {
	
	/*
	 	int n = 2;//진법
		int t = 4;//미리 구할 개수
		int m = 2;//인원
		int p = 1;//내순서
		 
	 */
	public String solution2(int n, int t, int m, int p) {        
		String answer = "";
		StringBuilder sb = new StringBuilder();
		
		//10진수 
		int num = 0;
		//내 순서 
		int oper = 1;
		
		while(sb.length() < t) { // 구하고자하는 갯수를 모두 구하면 끝.
			String[] tmp = Integer.toString(num++, n).split("");
			for (int i = 0; i < tmp.length; i++) {
				// 순서가 참가자보다 커지면 1로 초기화
				if(oper > m)
						oper = 1;
				// 내 순서면 append
				if(oper == p)
					sb.append(tmp[i]);
				// StringBuilder 크기가 t 와 같다면 종료
				if(sb.length() == t)
					break;
				
				oper++;
			}
		}
		answer = sb.toString().toUpperCase();
        return answer;
    }
	
    public String solution(int n, int t, int m, int p) {        
        ArrayList<String> nums = new ArrayList<>();
                
        for (int i = 0; i < (t * m * p); i++) {
        	 String calc_str = new BigInteger(String.valueOf(i)).toString(n).toUpperCase();
        	 
        	 if(calc_str.length() > 1) {
        		 for (int j = 0; j < calc_str.length(); j++) {
        			 nums.add(String.valueOf(calc_str.charAt(j)));
				}
        	 }else {
        		 nums.add(calc_str);
        	 }
		}
        StringBuilder sb = new StringBuilder();
        
        for (int j = 0; j < t; j++) {
        	sb.append(nums.get((m * j + p - 1)));
		}
        return sb.toString();
    }

	public static void main(String[] args) {
		Ex28 sol = new Ex28();
		
		int n = 2;//진법
		int t = 1000;//미리 구할 개수
		int m = 100;//인원
		int p = 2;//내순서 
		
		System.out.println(sol.solution(n, t, m, p)); 

	}

}
