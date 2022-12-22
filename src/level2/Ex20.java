package level2;

import java.util.ArrayList;
import java.util.List;

//n^2 배열 자르기

public class Ex20 {
	
//    public int[] solution2(int n, long left, long right) {
    	
//    	int[] answer = new int[(int) (right-left+1)];// 최종1차원 배열 left 부터 right 까지니까 right-left+1
//        int left_row = (int) (left/n);
//        int right_row = (int) (right/n);
//        
//        for(int i=left_row+1; i<=right_row+1; i++) {
//        	long idx = ((long) (i-1)) * n;
//        	
//        	for(int j=1; j<=i; j++)
//        		if(left <= idx + (j-1) && idx + (j-1) <= right)
//        			answer[(int) (idx+(j-1)-left)] = i;
//        	
//        	for(int j=i+1; j<=n; j++)
//        		if(left <= idx + (j-1) && idx + (j-1) <= right)
//        			answer[(int) (idx+(j-1)-left)] = j;
//        	
//        }
//    }
    
    // ㅆㅂ 메모리 초과
    public int[] solution(int n, long left, long right) {
    	List<Long> list = new ArrayList<>();
    	
    	for (int i = 0; i < n; i++) {
            int now = i + 1; // 1
            for (int j = 0; j < n; j++) {
            	
//            	arr[i][j] = (i >= j ? now : now + j - i); 		//<--- 맞게 조립된걸 확인하고 순서가 보장되는 자료구조로 때려박음 (아래줄로 교체)
            	list.add((long)(i >= j ? now : now + j - i)); 	//<--- 교체
            }
        }
    	
    	int[] answer = new int[(int) (right-left+1)];// 최종1차원 배열 left 부터 right 까지니까 right-left+1
    	int add = 0;
    	for(long i = left; i<=right; i++) {
    		answer[add++] = Integer.valueOf(list.get((int)i).toString());
        }
        return answer;
    }
    // 어째서? 
    //    int row = (int)(i / n) + 1;
    //    int col = (int)(i % n) + 1;
    public int[] solution2(int n, long left, long right) {
		List<Long> list = new ArrayList<>();

		for (long i = left; i <= right; i++) {
			System.out.print(i / n);
			System.out.print(" ");
			System.out.println(i % n);
			long temp = Math.max(i / n, i % n) + 1;
			list.add(temp);
		}

		int[] answer = new int[(int) (right-left+1)];// 최종1차원 배열 left 부터 right 까지니까 right-left+1
		int add = 0;
		for (long i = 0; i < list.size(); i++) {
			answer[add++] = Integer.valueOf(list.get((int) i).toString());
		}

		return answer;
    }
    
	public static void main(String[] args) {
		Ex20 sol = new Ex20();

		int n		= 3;
		long left	= 2;
		long right	= 5;
		
		
		System.out.println(sol.solution2(n, left, right));

	}

}
