package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// ���� 2. ���� ū ��
/*
���� ����)
0 �Ǵ� ���� ������ �־����� ��, ������ �̾� �ٿ� ���� �� �ִ� ���� ū ���� �˾Ƴ� �ּ���.

���� ���, �־��� ������ [6, 10, 2]��� [6102, 6210, 1062, 1026, 2610, 2106]�� ���� �� �ְ�, ���� ���� ū ���� 6210�Դϴ�.

0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��, ������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���ڿ��� �ٲپ� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����)
numbers�� ���̴� 1 �̻� 100,000 �����Դϴ�.
numbers�� ���Ҵ� 0 �̻� 1,000 �����Դϴ�.
������ �ʹ� Ŭ �� ������ ���ڿ��� �ٲپ� return �մϴ�.

����� ��)
numbers				return
[6, 10, 2]			"6210"
[3, 30, 34, 5, 9]	"9534330"
*/
 
public class Solution2 {
	
	// Ǯ��3 (with Lambda)
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
	
	
	// Ǯ��2
    public String solution2(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        //reference type ���� �����ϱ� ���� 
        for (Integer integer : numbers) {
        	list.add(integer);
		}
        
        // �Ⱑ ���� ���ٽ� 
        // Integer ���̺귯���� compare �Լ��� ���캸�� x==y �� ��� 0�� ��ȯ, x < y�� ��� ����, x > y�� ��� ����� ��ȯ�մϴ�.
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
    // Ǯ��1
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
