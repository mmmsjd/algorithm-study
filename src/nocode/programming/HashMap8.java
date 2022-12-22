package nocode.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// sub array sum = k 
// 974. Subarray Sums Divisible by K


// case : brute-force ÀÌÁß for¹®
// case : hash + cumulate ÀÌ¿ë ¾î·Æ´ÙÀ×

public class HashMap8 {

	public static void main(String[] args) {

		int[] nums = {6,3,2,5,3,-3}; 	
		int k = 10;
		
		System.out.println(subArraySum(nums, k));

	}
	
	private static String[] subArraySum(int[] nums, int k) {
		List<String> result = new ArrayList<>();
		
		List<Integer> cumulate = new ArrayList<>();		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		
		int sum = 0;		
		
		// 1. CREATE cumulate SubArray, HashMap
		cumulate.add(0);
		map.put(0, new ArrayList<>(Arrays.asList(-1)));
		
		//O(n)
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			cumulate.add(sum);
			
			if(map.containsKey(sum)) {
				ArrayList<Integer> list = map.get(sum);
				list.add(i);
				map.put(sum, list);
			}else {
				map.put(sum, new ArrayList<>(Arrays.asList(i)));
			}
		}
		
		//O(n)
		int idx = 0;
		while(idx < cumulate.size()) {
			int subKey = cumulate.get(idx);
			int key = subKey + k;
			
			if(map.containsKey(key)) {
				ArrayList<Integer> values = map.get(key);				
				int[] loop = values.stream().mapToInt(Integer::intValue).toArray();
				
				
				for (int i = 0; i < loop.length; i++) {
					
					StringBuilder sb = new StringBuilder();
					int lastIdx = loop[i];
					
					int subSum = 0;
					int subIdx = 0;
					
					
					while(subIdx <= lastIdx) {
						subSum += nums[subIdx];
						if(subKey < subSum) {
							sb.append(nums[subIdx]);
							sb.append(" ");
						}
						subIdx++;
					}
					result.add(sb.toString());
				}
				
			}
			idx++;
		}
		
		int add = 0;
		String[] answer = new String[result.size()];
		for(String s : result) {
			System.out.println(s);
			answer[add++] = s;
		}
		return answer;
		
	}
	

}
