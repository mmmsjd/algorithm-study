package nocode.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 
// Continguous Array
// a�� b �� ������ ���� ���� �� subArray �� ã�ƶ� 

// case : brute-force sliding window ���� for�� + count + maxlength ã�� : O(n^2)
// case : hash + cumulate subArray 

public class HashMap9 {

	public static void main(String[] args) {

		String str = "babbbaabb";//abbbaa
		// subArray 		"1,-1,1,1,1,-1,-1,1,1"
		// cumulate Array 	"1,0,1,2,3,2,1,2,3"

		// hash 
		// 1=[0,2,6] 
		// 0=[-1,1]
		// 2=[3,5,7]
		// 3=[4,8]
		System.out.println(simulaion(str));

	}
	
	private static int simulaion(String str) {
		int answer = 0;
		int[] numsArr = new int[str.length()];
		
		// 1. a=-1, b=1 �� ġȯ 
		int idx = 0;
		for(char c: str.toCharArray()) {
			if('a'== c) numsArr[idx] = -1;
			else numsArr[idx] = 1;
			
			idx++;
		}
		
		// 2. ���� sub Array ����(cumulate sub array)
		int add = 0;
		int[] cum = new int[str.length()+1];
		cum[add] = 0;
		
		int prev = 0;
		while(add < numsArr.length) {
			int next = numsArr[add++];
			prev += next;		
			cum[add] = prev;			
		}
		
		// 3. cum arr�� hash ����
		HashMap<Integer, ArrayList<Integer>> hashmap = new HashMap<>();
		for (int i = 0; i < cum.length; i++) {
			int value = cum[i];
			// 3. hashMap ���� 
			if(hashmap.containsKey(value)){
				ArrayList<Integer> list = hashmap.get(value);
				list.add(i-1);
				hashmap.put(value, list);
			}else {
				hashmap.put(value, new ArrayList<>(Arrays.asList(i-1)));
			}			
		}
		
		int max = 0;
		// 4. ���� ���� ��� 
		for(ArrayList<Integer> list: hashmap.values()) {
			int diff = list.get(list.size()-1) - list.get(0);
			max = Math.max(max, diff);
		}
		answer = max;
		return answer;
		
	}
	
}
 