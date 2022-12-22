package nocode.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// merge intervals

public class Arr6 {

	public static void main(String[] args) {

		int[][] nums = {{1,5},{3,7},{10,15},{8,16}};
		
		mergeIntervals(nums);

	}

	private static void mergeIntervals(int[][] intervals) {
		
		if(intervals.length < 2) return;		
//		Arrays.sort(intervals, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[0] - o2[0];
//			}
//		});
//		
		Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		
		List<int[]> list = new ArrayList<>();
		int[] new_interval = intervals[0];
		list.add(new_interval);
		
		for (int[] current_interval: intervals) {
			System.out.println(current_interval[0]);
			if(new_interval[1] >= current_interval[0]) {// {1,5},{3,7} -> 5 > 3 if
														// => merge {1,7} 
														// => {1,7},{10,15} -> 7 > 10 else
														// => add {10,15} 
														// => {10,15},{8,16} -> 15 > 8 if
														// => merge {8,16} 
				new_interval[1] = Math.max(current_interval[1], new_interval[1]);
			}
			else {
				new_interval = current_interval;
				list.add(new_interval);
			}
		}
		
		for (int[] i : list) {
			System.out.println(i[0]);
			System.out.println(i[1]);
		}
		
		
	}

}
