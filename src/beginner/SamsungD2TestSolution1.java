package beginner;

import java.util.Scanner;

// 1859. �鸸 ���� ������Ʈ

public class SamsungD2TestSolution1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		*/

		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int len = sc.nextInt();
			int[] arr = new int[len];

			for (int i = 0; i < len; i++) {
				arr[i] = sc.nextInt();
			}

			long answer = 0; 

			// �� ������ ��¥���� ���
			// i ��¥�� �Ĵ� ��, j ��¥�� ��� ���� �ȴ�.
			for (int i = len - 1; i >= 0; i--) {

				int j = i - 1; // ���� �Ĵ� ��¥���� �ٷ� ���� ��¥���� �˻�
				int tmp = 0;
				while (j >= 0 && arr[i] > arr[j]) { //i�� �Ĵ³�, j�� ��³� 
					tmp += arr[i]; // �Ĵ� ���� �ŸŰ��� �����ش�.
					tmp -= arr[j]; // ��� ���� �ŸŰ��� ���ش�.
					j--; // ���� ��¥�� �̵�
				}

				answer += tmp; // ���Ϳ� �����ش�.
				i = j + 1; // �Ĵ� ���� �Ű��ش�.
			}
			
			System.out.println("#"+test_case+" "+answer);
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 �� �κп� �������� �˰��� ������ ���ϴ�.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}

}
