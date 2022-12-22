package level2;

import java.util.ArrayList;
import java.util.List;

//n^2 �迭 �ڸ���

public class Ex20 {
	
//    public int[] solution2(int n, long left, long right) {
    	
//    	int[] answer = new int[(int) (right-left+1)];// ����1���� �迭 left ���� right �����ϱ� right-left+1
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
    
    // ���� �޸� �ʰ�
    public int[] solution(int n, long left, long right) {
    	List<Long> list = new ArrayList<>();
    	
    	for (int i = 0; i < n; i++) {
            int now = i + 1; // 1
            for (int j = 0; j < n; j++) {
            	
//            	arr[i][j] = (i >= j ? now : now + j - i); 		//<--- �°� �����Ȱ� Ȯ���ϰ� ������ ����Ǵ� �ڷᱸ���� �������� (�Ʒ��ٷ� ��ü)
            	list.add((long)(i >= j ? now : now + j - i)); 	//<--- ��ü
            }
        }
    	
    	int[] answer = new int[(int) (right-left+1)];// ����1���� �迭 left ���� right �����ϱ� right-left+1
    	int add = 0;
    	for(long i = left; i<=right; i++) {
    		answer[add++] = Integer.valueOf(list.get((int)i).toString());
        }
        return answer;
    }
    // ��°��? 
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

		int[] answer = new int[(int) (right-left+1)];// ����1���� �迭 left ���� right �����ϱ� right-left+1
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
