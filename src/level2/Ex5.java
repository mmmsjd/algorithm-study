package level2;

// ������ ǥ��
public class Ex5 {
	
	/*
	 ���ӵ� ���ڵ��� ���� �ڿ��� n �̻��� �Ǵ� ��� ���� �ݺ��Ѵ�

	���� ���ӵ� ���ڵ��� ���� �ڿ��� n�� ���ٸ� ���� ī��Ʈ�� ���� ��Ų��

	�̷��� ������ 1���� �ϳ��� ������Ű�� �ݺ��Ѵ�

	�̶� �������� �ڿ��� n�� ������ �ʰ��ϰ� �Ǹ� ���ӵ� ���� ���� �ּҰ��� �ڿ��� n���� Ŀ���� �ǹǷ� n / 2 ������ �ݺ��Ѵ�
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
    
    //�־��� �ڿ����� ���ӵ� �ڿ����� ������ ǥ���ϴ� ����� ���� �־��� ���� Ȧ�� ����� ������ ���ٶ�� ������ ������ �ֽ��ϴ�.
    
    //�־��� �ڿ����� x�� �ϰ�, a, b, c, d, k, n�� �ڿ������ ���� 
    // 1) x�� Ȧ������ ���ӵ� �ڿ����� ������ ǥ���� �� �ִ� ��� 
    // - 1�� : b => 1*b [��, b >= 1] 
    // - 3�� : b-1, b, b+1 => 3*b [��, b >= 2] 
    // - 2a-1�� : b-(a-1), �� b, ��, b+(a-1) => (2a-1)*b [��, b >= a] 
    
    // 2) x�� ¦������ ���ӵ� �ڿ����� ������ ǥ���� �� �ִ� ��� 
    // - 2�� : d-1, d => 1*(2d-1) [��, d >= 2] 
    // - 4�� : d-2, d-1, d, d+1 => 2*(2d-1) [��, d >= 3] 
    // - 2d�� : d-c, ��, d, ��, d+(c-1) => c*(2d-1) [��, d >= c+1] 
    
    // 3) 1)�� 2)�� ���ļ� ǥ���ϸ� 
    // - x = (2k-1)n [��, n>=k�̸� Ȧ����, n
    
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
