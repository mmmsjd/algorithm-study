package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ���� �����ձ�
/*
 * ����� �� n�� ������� ������� ���� �ܾ� words �� �Ű������� �־��� ��, 
 * ���� ���� Ż���ϴ� ����� ��ȣ�� �� ����� �ڽ��� �� ��° ���ʿ� Ż���ϴ����� ���ؼ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 */
public class Ex9 {
	
	// �� ����
	public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        HashMap<String, Integer> map  = new HashMap<>();	
        
        // ���� ī���� 		
        int trun = 0;
        String bf_last = "";
        for (int i = 0; i < words.length; i++) {
        	trun++;        	
        	if(bf_last.length() > 0) {
        		if(bf_last != String.valueOf(words[i].charAt(0))) {
        			answer[0] = trun;
        			answer[1] = trun;
        			break;
        		}
        	}
        	 
        	bf_last = String.valueOf(words[i].charAt(words[i].length()-1));
        	System.out.println(bf_last);
        	if(map.containsKey(words[i])) {
    			answer[0] = trun;
    			answer[1] = trun;
    			break;
        	}
        	
        	map.put(words[i], trun); 
        	
        	if(trun == n) trun = 0;
        	System.out.println(map.toString());
		}		
        return answer;
    }

	public int[] solution2(int n, String[] words) {
        int[] answer = new int[2];
        
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);
        
        for(int i = 1; i < words.length; i++){
        	
            String current = list.get(list.size()-1);
            String next = words[i];
            
            if(!list.contains(next) && 
               (current.charAt(current.length()-1) == next.charAt(0))){
                   list.add(next);
               }
            else{
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        return answer;
    }
	public static void main(String[] args) {
		Ex9 sol = new Ex9();
		
		// "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
		
		
		int n = 3;
		String[] word = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		

//		int n = 2;
//		String[] word = {"hello", "one", "even", "never", "now", "world", "draw"};
		
		System.out.println(sol.solution(n, word)[0]);
		System.out.println(sol.solution(n, word)[1]);

	}

}
