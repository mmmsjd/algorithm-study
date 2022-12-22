package programmers.brute.force;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// ����Ž�� 3.���ǰ��
public class Solution3 {

	HashSet<Integer> numberSet = new HashSet<>();
	
	 public int[] solution(int[] answers) {
	        
	        
//	        1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, | 1, 2, 3, 4, 5, ...
//	        2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5,| 2, 1, 2, 3, 2, 4, 2, 5, ...
//	        3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,| 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	        
	        int[] a1 = {1, 2, 3, 4, 5};
	        int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
	        int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	        
	        int[] good = {0, 0, 0};
	        // ��
	        for(int i = 0; i < answers.length; i++){	        	

//	        	System.out.print(a1[i % 5]+"|");
//	        	System.out.print(a2[i % 8]+"|");
//	        	System.out.print(a3[i % 10]+"|");
//	        	System.out.println("---------------");
	        	
	            if(a1[i % 5] == answers[i]){ good[0]++;}
	            if(a2[i % 8] == answers[i]){ good[1]++;}
	            if(a3[i % 10] == answers[i]){ good[2]++;}
	            
	        }
	        
	        int[] arr = good.clone();
	        
	        Arrays.sort(arr);
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        
	        for(int i = 0; i < arr.length; i++){
	            if(good[i] == arr[2]){ // 2�� index ���� �������� ������ �����Ƿ� max ������ ����.
	                list.add(i+1); //�����ڰ� 2�̻��̸� �������� ������ ���� +1 , �Ѹ��̸� �� ȥ�ڴ�.
	            }
	        }
	        
	        int[] answer = new int[list.size()];
	        for(int i = 0; i < list.size(); i++){
	        	answer[i] = list.get(i);
	        }
	        
	        return answer;
	    }
	
	public static void main(String[] args) {

		Solution3 sol = new Solution3();
		int[] answer = {1,3,2,4,2};
		System.out.println(sol.solution(answer));
	}

}
