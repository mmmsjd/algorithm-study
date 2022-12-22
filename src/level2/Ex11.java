package level2;

import java.util.Arrays;

// N개의 최소공배수
//유클리드 호제법
//if (a % b == 0) return b;  // a가 b로 나누어 떨어진다면 gcd는 b가 된다.

	

public class Ex11 {
    public int solution(int[] arr) {
        
        Arrays.sort(arr);
        int last = arr[arr.length-1];
        
        for (int i = last; ;i++) { //14..15..16
			int flag = 0;
			for (int n : arr) {
//				System.out.print(i);
//				System.out.print(" ");
//				System.out.print(n);
//				System.out.print(" ");
//				System.out.print(i % n);
//				System.out.println();
				
				if(i % n != 0) {//14 % n번으로 모두 나눈 나머지가 0이면 배수임.. 모두 나머지가 0인경우가 최소 공배수임.
					flag = 1;
					break;
				}
			}
			if(flag == 0) return i;
		}
    }
    
	public static void main(String[] args) {
		Ex11 sol = new Ex11();

		int[] arr = {2,6,8,14};
		System.out.println(sol.solution(arr));

	}

}
