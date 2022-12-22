package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 정렬 2. 가장 큰 수
/*
문제 설명)
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항)
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

입출력 예)
numbers				return
[6, 10, 2]			"6210"
[3, 30, 34, 5, 9]	"9534330"
*/
 
public class Solution2 {
	
	// 풀이3 (with Lambda)
	public String solution3(int[] numbers) {
		
		List<String> result = Arrays.stream(numbers).mapToObj(n -> String.valueOf(n)).collect(Collectors.toList());
		System.out.println(result.toString());
		
	    Collections.sort(result, (s1, s2) -> -(s2 + s1).compareTo(s1 + s2));	
	    System.out.println(result.toString());
	    
	    Collections.sort(result, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));	
	    System.out.println(result.toString());
	    
	    if(result.get(0).equals("0")) 
	        return "0";
		    
	    return result.stream().collect(Collectors.joining());
	}
	
	
	// 풀이2
    public String solution2(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        //reference type 으르 변경하기 위해 
        for (Integer integer : numbers) {
        	list.add(integer);
		}
        
        // 기가 막힌 람다식 
        // Integer 라이브러리의 compare 함수를 살펴보면 x==y 인 경우 0을 반환, x < y인 경우 음수, x > y인 경우 양수를 반환합니다.
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
        
    }
    // 풀이1
    public String solution(int[] numbers) {
    	    	
        String answer = "";
        String[] s_numbers = new String[numbers.length];
        
        for(int i=0; i < numbers.length; i++)
        	s_numbers[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(s_numbers, new Comparator<String>(){
            public int compare(String o1, String o2){
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        if(s_numbers[0].equals("0")) return "0";	       
        
        for(String stringNumber: s_numbers)
            answer += stringNumber;
      
        return answer;
    }
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		
		int[] array = {3, 30, 34, 5, 9};
		
		System.out.println(sol.solution3(array));

	}

}
