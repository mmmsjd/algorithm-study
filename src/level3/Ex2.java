package level3;

// �ְ��� ���� 
/*
 * n���� ������ ���ʿ� +1 �Ѵٴ� ����
 */

public class Ex2 {
	public int[] solution(int n, int s) {
		int[] answer = new int[n];

		if (s < n) {
			answer = new int[1];
			answer[0] = -1;
			return answer;
		}
		for (int i = 0; i < n; i++) {
//			System.out.println(s/(n-i));
			answer[i] = s/(n-i);
			s -= answer[i];
		}
		return answer;
	}
    
	public static void main(String[] args) {
		Ex2 sol = new Ex2();
		
		int n = 2;
		int s = 9;
		
		System.out.println(s/(n-0));
		System.out.println(s/(n-1));
		
		System.out.println(sol.solution(n, s));

	}

}
