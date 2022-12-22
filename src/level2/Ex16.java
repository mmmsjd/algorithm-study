package level2;

import java.util.Arrays;

// H-Index
// 이것참 많은 문제를 접해봐햐 하는 이유다.

public class Ex16 {
	
	public int solution2(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		
		for (int i = 0; i < citations.length; i++) {			
			int h = citations.length - i;
			
			// 그림이 필요 
//			3, 0, 6, 1, 5 정렬전
//			0, 1, 3, 5, 6 정렬후 
//			6, 5, 3, 1, 0 역순
//			      ↑ 요기가 n회이상 인용되었고 n회이하 인용되었기에 h==3
//			그래서 정렬후 반복문에서 i++ 만큼 빼준 index 와 값을 비교
//			값이 index 와 같으면 h-index
			
			
			
			if (citations[i] >= h) {
				answer = h;
				break;
			}
		}
		return answer;
	}
	// 내풀이 ㅆㅂ
	public int solution(int[] citations) {
		//1. 일단 정렬 
		Arrays.sort(citations);
		
		int left  = citations[0];
		int right = citations[citations.length-1];
		
		return (left + right)/2; //2.mid 값 구해서 리턴
		
	}
    
	public static void main(String[] args) {
		Ex16 sol = new Ex16();

		int[] citations = {3, 0, 6, 1, 5};
		
		System.out.println(sol.solution2(citations));

	}

}
