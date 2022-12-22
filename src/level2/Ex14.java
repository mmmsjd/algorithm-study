package level2;

// 멀리 뛰기
/*
 * 피보나치?
 * 조건을 잘봐야 한다.. 0 과 1이 아니라 1과 2다.
 * 그리고... 변수 하나로 쓰면 개망한다..
 * 배열 써라..
 */
public class Ex14 {
	
	public long solution2(int n) {
		long answer[] = new long[n+1];
		
		for (int i = 1; i <= n; i++) {
			if(i==1) answer[i] = 1;
			else if(i==2) answer[i] = 2;
			else {
				long sum = answer[i-1] + answer[i-2];
				answer[i] = sum % 1234567;
			}
		}
        return answer[n];
	}

	// ㅆㅂ 시간 초과
    public long solution(int n) {		
    	
    	
    	int m = n % 1234567;
    	
        return recursive(m) % 1234567;
    }
    
    long recursive(int n) {
		if(n==1) return 1;
		else if(n==2) return 2;
		else return recursive(n-1) + recursive(n-2);
	}
    
	public static void main(String[] args) {
		Ex14 sol = new Ex14();

		int n = 4;
		
		System.out.println(sol.solution2(n));

	}

}
