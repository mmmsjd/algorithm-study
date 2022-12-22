package level2;

// 숫자의 표현
public class Ex5 {
	
	/*
	 연속된 숫자들을 더해 자연수 n 이상이 되는 경우 까지 반복한다

	만약 연속된 숫자들의 합이 자연수 n과 같다면 정답 카운트를 증가 시킨다

	이러한 과정을 1부터 하나씩 증가시키며 반복한다

	이때 시작점이 자연수 n의 절반을 초과하게 되면 연속된 수의 합의 최소값이 자연수 n보다 커지게 되므로 n / 2 까지만 반복한다
	 */
    public int solution(int n) {
    	int answer = 1; 
    	
        for(int i = 1; i <= n / 2; i++) {
            int sum = i;
            for(int j = i + 1; sum < n; j++) {
                sum += j;
            }
            if(sum == n) answer++;
        }
        return answer;
    }
    
    //주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리가 있습니다.
    
    //주어진 자연수를 x라 하고, a, b, c, d, k, n은 자연수라고 가정 
    // 1) x를 홀수개의 연속된 자연수의 합으로 표현할 수 있는 경우 
    // - 1개 : b => 1*b [단, b >= 1] 
    // - 3개 : b-1, b, b+1 => 3*b [단, b >= 2] 
    // - 2a-1개 : b-(a-1), … b, …, b+(a-1) => (2a-1)*b [단, b >= a] 
    
    // 2) x를 짝수개의 연속된 자연수의 합으로 표현할 수 있는 경우 
    // - 2개 : d-1, d => 1*(2d-1) [단, d >= 2] 
    // - 4개 : d-2, d-1, d, d+1 => 2*(2d-1) [단, d >= 3] 
    // - 2d개 : d-c, …, d, …, d+(c-1) => c*(2d-1) [단, d >= c+1] 
    
    // 3) 1)과 2)를 합쳐서 표현하면 
    // - x = (2k-1)n [단, n>=k이면 홀수개, n
    
    public int expressions(int num) {
        int answer = 0;
        for (int i = 1; i <= num; i += 2) {
        	System.out.print(i);
        	System.out.print(" ");
        	System.out.println(num % i);
            if (num % i == 0) {
                answer++;
            }
        }
        return answer;
    }
    
	public static void main(String[] args) {
		Ex5 sol = new Ex5();
		
		int s = 15;
		System.out.println(sol.expressions(s));

	}

}
