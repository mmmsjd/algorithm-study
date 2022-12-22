package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// 정렬 1. K번째 숫자
public class Solution1 {
	
	// 풀이2 java.util.Arrays 개쩐다..
	public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
	
	// 풀이1
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
        	int[] cmd = commands[i];        	
    		// 요소 자르기 (항상 길이가 3이기에 그냥 0,1,2 로 가져옴)
        	int f 	= cmd[0]-1;
    		int l 	= cmd[1]-1;
    		int c 	= cmd[2]-1;
    		
    		System.out.println(f+":"+l+":"+c);
        	
    		ArrayList<Integer> list = new ArrayList<>();
    		for (int j = 0; j < array.length; j++) {
    			if(j >= f && j <= l) {// 첫번째부터 마지막 인덱스까지 돌면서 list 에 add
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
