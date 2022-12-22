package nocode.programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 939. Minimum Area Rectangle(직사각형)
// 최소면적의 직사각형 갯수를 반환해라.

// sorting, 2potinters, dp.. 등을 떠올릴줄 알아야 한다.. 
// 두개의 점 (1,1), (3,2)
//			 (1,2), (3,1)
//			 (1x,2y), (2x,1y)
// case : 이중for문 + 2point -> hashSet + hashMap

public class HashMap10 {

	public static void main(String[] args) {

		int[][] input =  {{1,1},{1,2},{1,3},{2,1},{2,2},{2,3},{3,1}};
//		int[][] input =  {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};//2

		System.out.println(simulaion(input));

	}
	
	private static int simulaion(int[][] input) {
		int answer = 0;
		
		Map<Integer, Set<Integer>> hash = new HashMap<>();
		// 내코드
		int xlength = input.length;		
		int idx1 = 0;		
		while(idx1 < xlength) {
			int[] point = input[idx1++];
			int x = point[0];
			int y = point[1];
			
			if(hash.containsKey(x)) {
				Set<Integer> set = hash.get(x);
				set.add(y);
				hash.put(x, set);
			}else {
				hash.put(x, new HashSet<>(Arrays.asList(y)));	
			}
			
		}
		// 검색된 코드 (개 깔끔)
//		for(int[] point:input) {
//			if(!hash.containsKey(point[0])) {
//				hash.put(point[0], new HashSet<Integer>());
//			}
//			hash.get(point[0]).add(point[1]);
//		}
		int area = Integer.MAX_VALUE;
		for (int i = 0; i < input.length -1; i++) {
			for (int j = 0; j < input.length; j++) {
				int x1 = input[i][0];
				int x2 = input[j][0];
				int y1 = input[i][1];
				int y2 = input[j][1];
				
				
				
				if(x1 != x2 && y1 != y2) {
					
					System.out.print("> > > > ");
					System.out.println(x1+" "+x2+" "+y1+" "+y2);
					System.out.println(Math.abs((x2 -x1)*(y2-y1)));
					if(area >  Math.abs((x2 -x1)*(y2-y1))) {
						if(hash.get(x1).contains(y2) && hash.get(x2).contains(y1)) {
							area = Math.abs((x2 -x1)*(y2-y1));
						}
					}
				}
				
			}
			
		}
//		System.out.println(area);		
		
		return area < Integer.MAX_VALUE ?  area : 0;
		
	}
	
}
