package level2;

import java.util.Arrays;
import java.util.Collections;

// 최솟값 만들기
public class Ex3 {
	
	public int solution(int[] A, int[] B) {
     
        Arrays.sort(A);
        Arrays.sort(B);
        
        int total = 0;
        for (int i = 0; i < A.length; i++) {
        	total += (A[i] * B[B.length -1  -i]);
			
		}
        return total;
    }

	public static void reverseSort(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp; 
        }
    }
	public static void main(String[] args) {
		Ex3 sol = new Ex3();
		int[] a = {1, 4, 2};
		int[] b = {5, 4, 4};
		
		System.out.println(sol.solution(a, b));

	}

}
