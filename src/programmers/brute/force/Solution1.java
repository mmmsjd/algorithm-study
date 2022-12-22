package programmers.brute.force;

import java.util.Arrays;

// 완전탐색 1.최소직사각형
public class Solution1 {
	
    public int solution(int[][] sizes) {
           
        for (int i = 0; i < sizes.length; i++) {
        	// 원소 비교해서 자리를 바꿔준다.
        	if(sizes[i][0] > sizes[i][1]) {
        		swap(sizes[i], 0, 1);
        	}
		}
        
        int[] w = new int[sizes.length];
        int[] h = new int[sizes.length];        
        
        for (int i = 0; i < sizes.length; i++) { 
        	w[i] = sizes[i][0];
        	h[i] = sizes[i][1];
		}
        
        Arrays.sort(w);
        Arrays.sort(h);
//        
    	for (int i : w) {
			System.out.print(i);
		}
		System.out.println();
		
		for (int i : h) {
			System.out.print(i);
		}
		System.out.println();
        
        
        return w[w.length-1] * h[h.length-1];
    }
    
    // 두 인덱스의 원소를 교환하는 함수
 	private void swap(int[] a, int i, int j) {
 		int temp = a[i];
 		a[i] = a[j];
 		a[j] = temp;
 	}
	
	

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		
		int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
		
		System.out.println(sol.solution(sizes));

	}

}
