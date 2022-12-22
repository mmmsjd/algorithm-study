package level2;

// 피보나치 수열
public class Ex6 {
	
	public int solution2(int n) {
		int answer[] = new int[n+1];
		for (int i = 0; i <= n; i++) {
			if(i==0) answer[i] = 0;
			else if(i==1) answer[i] = 1;
			else {
				int sum = answer[i-1] + answer[i-2];
				answer[i] = sum % 1234567;
			}
		}
		
        return answer[n];
    }
	
	public int solution(int n) {
        return recursive(n);
    }
	
	
	int recursive(int n) {
		int sum = 0;
		if(n==0) return 0;
		else if(n==1) return 1;
		else 
			sum = recursive(n-1) + recursive(n-2);
		return 	sum % 1234567;	
	}

	public static void main(String[] args) {
		Ex6 sol = new Ex6();
		
		int s = 4;
		System.out.println(sol.solution2(s)); 

	}

}
