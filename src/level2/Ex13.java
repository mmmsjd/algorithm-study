package level2;

// ������ ���� �̵�
/*
 * K ĭ�� ������ �����ϰų�, (������� �� �Ÿ�) x 2 �� �ش��ϴ� ��ġ�� �����̵�
 * �����ϸ� K ��ŭ ���͸� �Ҹ�
 * �ִ��� ���͸� �Ҹ� �ٿ��� �̵��ض�.
 * 
 * �̰� ������ ��.. �ָ� �߾�..
 * ���� N: 1 �̻� 10�� ������ �ڿ��� 
 * �� ����� �ϴ� �ų�.. ����
 * dfs bfs �� �����Ұ� �ƴ϶� 
 * top-down ������� ���ٷ� �������� ���ڴ�..
 * ������ �������� ������ ������ 
 * �ȶ������� n���� �ϳ� ���ְ� count++; 
 * 
 * 
 */
public class Ex13 {
	public int solution(int n) {
		int answer = 0;
        
        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            } else {
                n--;
                answer++;
            }
        }
        return answer;
        
    }
	public static void main(String[] args) {
		Ex13 sol = new Ex13();

		int n = 5000;
		
		System.out.println(sol.solution(n));

	}

}
