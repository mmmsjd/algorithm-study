package nocode.programming;

import java.util.ArrayList;
import java.util.List;

// 39. Combination Sum

public class BT4 {
	
	
	public static void main(String[] args) {
		int[] num = {1,2,3};		
		int k = 5;
		
		System.out.println(combinationSum(num, k));
		
	}
	
	static List<List<Integer>> result = new ArrayList<>();
	
	private static List<List<Integer>> combinationSum(int[] num, int k) {
		
		bt(num, 0, k, new ArrayList<>(), 0);
		return result;
	}

	private static void bt(int[] num, int sum, int k, List<Integer> comb, int prevIdx) {
		// exit part
		if(sum > k ) return;		
		if(sum == k){
			result.add(new ArrayList<>(comb));
			return;
		}
		// precess part
		for (int i = 0; i < num.length; i++) {
			if(i < prevIdx) { // 이전 인덱스보다 작으면 이전 인덱스로 교체 
				i = prevIdx;
			}
			// recusion part
			comb.add(num[i]);
			System.out.println(+i+":"+comb);
			bt(num, sum + num[i], k, comb, i);
			comb.remove(comb.size() -1);
		}
	}
}


//from typing import List
//
//class CombSum:
//def solution(self, in_list: List[int], target: int) -> List[List[int]]:
//  if len(in_list)==0:
//    return []
//
//  #set init member Vars
//  self.__result = []
//  self.__in_list = in_list
//  comb = []
//  self.__bt(0,target,comb) #backtracking
//  return self.__result
//
//
//def __bt(self, prevIdx:int, targetSum:int, comb:List[int]):
//  #exit conditions
//  if targetSum==0:
//    self.__result.append(comb.copy())
//  elif targetSum < 0:
//    return
//  
//  #process(candidates filtering)
//  for idx in range(prevIdx,len(self.__in_list)):
//    num = self.__in_list[idx] 
//
//    #recusion call
//    comb.append(num)       
//    self.__bt(idx,targetSum-num,comb)
//    comb.pop()
//  return
//
//combSum = CombSum()

