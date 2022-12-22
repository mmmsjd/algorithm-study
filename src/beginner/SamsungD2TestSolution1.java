package beginner;

import java.util.Scanner;

// 1859. 백만 장자 프로젝트

public class SamsungD2TestSolution1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int len = sc.nextInt();
			int[] arr = new int[len];

			for (int i = 0; i < len; i++) {
				arr[i] = sc.nextInt();
			}

			long answer = 0; 

			// 맨 마지막 날짜부터 계산
			// i 날짜가 파는 날, j 날짜가 사는 날이 된다.
			for (int i = len - 1; i >= 0; i--) {

				int j = i - 1; // 현재 파는 날짜보다 바로 앞의 날짜들을 검사
				int tmp = 0;
				while (j >= 0 && arr[i] > arr[j]) { //i는 파는날, j는 사는날 
					tmp += arr[i]; // 파는 날의 매매가를 더해준다.
					tmp -= arr[j]; // 사는 날의 매매가를 빼준다.
					j--; // 앞의 날짜로 이동
				}

				answer += tmp; // 이익에 더해준다.
				i = j + 1; // 파는 날을 옮겨준다.
			}
			
			System.out.println("#"+test_case+" "+answer);
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
	}

}
