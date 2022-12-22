package kakao2022;

// 1.상자 놀이 

/* 춘식이는 한 줄로 이어진 상자들을 가지고 놀이를 하려고 합니다.
 * 놀이에는 정수 x, y, z가 주어집니다.
 * 춘식이는 왼쪽에서 x번째 상자에서 놀이를 시작하고, 매 턴마다 오른쪽이나 왼쪽으로 이동하여 y번째 상자에 도착해야 합니다.
 * 놀이를 진행하는 동안 최대 z 번의 이동이 가능하며, 모든 이동 방향은 동일할수 있습니다.
 * 춘식이가 놀이를 진행하며 도착할 수 있는 k번째 상자 주, 가능한 k 의 최대값을 구하세요.
 * 
 * Constraints(제한사항): 1<=x,y,z<= 10^8 (100000000) 
 * 
 * Ex1)
 * x = 4; 
 * y = 4;
 * z = 4;
 * 
 * 
 */

/**
 * 단순 구현 문제 (쉬웠는데 절었다.. ㅆㅂ)
 *
 */

public class Test1 {

	public static void main(String[] args) {

//		int x = 8;
//		int y = 5;
//		int z = 3; //8
		
//		int x = 4;
//		int y = 4;
//		int z = 6; //7
		
//		int x = 4; 
//		int y = 4;
//		int z = 4; //6
		
//		int x = 6; 
//		int y = 9;
//		int z = 10; //12
		
		int x = 100000000; 
		int y = 100000000;
		int z = 3; 

		System.out.println(solution(x,y,z));

	}
	
	public static int solution(int x, int y, int z) {
		
	    int diff = Math.abs(x - y);
	    int max = Math.max(x, y);
	     
	    if(diff > z) return -1;
	    else if(diff == z) return max;
	    else if(diff == 0) {
	    	if(z % 2 == 0) {// 짝수
	    		return max + (z / 2);
	    	}
	    	else {			// 홀수
	    		return max + ((z-1) / 2);
	    	}
	    } 
	    else {
	    	int carry = (z - diff);
	    	if(carry % 2 == 0) {// 짝수
	    		return max + (carry / 2); 
	    	}else {				// 홀수
	    		return max + ((carry-1) / 2); 
	    	}
	    	
	    }
    }

}
