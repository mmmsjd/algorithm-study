package level2;

import java.util.Arrays;

// N���� �ּҰ����
//��Ŭ���� ȣ����
//if (a % b == 0) return b;  // a�� b�� ������ �������ٸ� gcd�� b�� �ȴ�.

	

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
				
				if(i % n != 0) {//14 % n������ ��� ���� �������� 0�̸� �����.. ��� �������� 0�ΰ�찡 �ּ� �������.
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
