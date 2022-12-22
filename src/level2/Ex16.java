package level2;

import java.util.Arrays;

// H-Index
// �̰��� ���� ������ ���غ��� �ϴ� ������.

public class Ex16 {
	
	public int solution2(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		
		for (int i = 0; i < citations.length; i++) {			
			int h = citations.length - i;
			
			// �׸��� �ʿ� 
//			3, 0, 6, 1, 5 ������
//			0, 1, 3, 5, 6 ������ 
//			6, 5, 3, 1, 0 ����
//			      �� ��Ⱑ nȸ�̻� �ο�Ǿ��� nȸ���� �ο�Ǿ��⿡ h==3
//			�׷��� ������ �ݺ������� i++ ��ŭ ���� index �� ���� ��
//			���� index �� ������ h-index
			
			
			
			if (citations[i] >= h) {
				answer = h;
				break;
			}
		}
		return answer;
	}
	// ��Ǯ�� ����
	public int solution(int[] citations) {
		//1. �ϴ� ���� 
		Arrays.sort(citations);
		
		int left  = citations[0];
		int right = citations[citations.length-1];
		
		return (left + right)/2; //2.mid �� ���ؼ� ����
		
	}
    
	public static void main(String[] args) {
		Ex16 sol = new Ex16();

		int[] citations = {3, 0, 6, 1, 5};
		
		System.out.println(sol.solution2(citations));

	}

}
