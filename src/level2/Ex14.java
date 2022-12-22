package level2;

// �ָ� �ٱ�
/*
 * �Ǻ���ġ?
 * ������ �ߺ��� �Ѵ�.. 0 �� 1�� �ƴ϶� 1�� 2��.
 * �׸���... ���� �ϳ��� ���� �����Ѵ�..
 * �迭 ���..
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

	// ���� �ð� �ʰ�
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
