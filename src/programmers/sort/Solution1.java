package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// ���� 1. K��° ����
public class Solution1 {
	
	// Ǯ��2 java.util.Arrays ��¾��..
	public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
	
	// Ǯ��1
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
        	int[] cmd = commands[i];        	
    		// ��� �ڸ��� (�׻� ���̰� 3�̱⿡ �׳� 0,1,2 �� ������)
        	int f 	= cmd[0]-1;
    		int l 	= cmd[1]-1;
    		int c 	= cmd[2]-1;
    		
    		System.out.println(f+":"+l+":"+c);
        	
    		ArrayList<Integer> list = new ArrayList<>();
    		for (int j = 0; j < array.length; j++) {
    			if(j >= f && j <= l) {// ù��°���� ������ �ε������� ���鼭 list �� add
    				list.add(array[j]);
    			}
			}
    		list.sort(Comparator.naturalOrder());
    		answer[i] = list.get(c);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] cmd = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		
		System.out.println(sol.solution2(array, cmd));

	}

}
