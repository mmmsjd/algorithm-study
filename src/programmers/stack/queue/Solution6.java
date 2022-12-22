package programmers.stack.queue;

import java.util.ArrayList;

// ����/ť 6.�ֽİ���
public class Solution6 {

	public int[] solution2(int[] prices) {
		
		int[] answer = new int[prices.length];
		int index = 0;
		
		while(index < prices.length) {
		   for (int i = index+1; i < prices.length; i++) {
	    	   if(prices[index] > prices[i]) {
	    		   answer[index] = i-index; break;
	    	   }
	    	   answer[index] = prices.length-1-index;
		   }
		   index++;
		}

        return answer;
    }
	public int[] solution(int[] prices) {
		ArrayList<Integer> list = new ArrayList<>();
        
        // 1. 1�ʸ� ���� 
       for (int i = 0; i < prices.length; i++) {
    	   int f = prices[i];
    	   
    	   // 2.�����Ͽ� ������ �����ǰų� �þҴٸ� �ʸ� ī��Ʈ
    	   int count = -1; 
    	   for (int j = i; j < prices.length; j++) {
    		   int n = prices[j];
    		   if(f <= n) {
    			   count++; 
    		   }
    	   }
    	   list.add(count);
		}
        
    	int[] answer = new int[list.size()];
    	int c = 0;
    	for (int value : list) {
    		answer[c++] = value;
		}
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		Solution6 sol = new Solution6();
		
		int[] prices = {1, 2, 3, 2, 3};
		
		System.out.println(sol.solution2(prices));

	}

}
