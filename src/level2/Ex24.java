package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// [3차] 압축 LZW(Lempel–Ziv–Welch) 
/*
 * 사전 : HashMap<String, Ineteger>
 * 입력은 배열로 변경 
 * 한번에 current, next 문자를 get
 * current 가 있으면 get index(answer++) 없으면 set
 * curren + next 를 사전에 set
 * 마지막은 get index(answer++) 만 처리 
 * 
 */
public class Ex24 {
	
    public int[] solution(String msg) {
  
    	
    	
        List<Integer> out = new ArrayList<>();
        
        // 사전 초기화
        HashMap<String, Integer> index = new HashMap<>();
        char ch = 'A';
    	for (int i = 1; i <= 26; ++i) {
    		index.put(String.valueOf(ch), i);
			ch++;
		}
    	if(msg.length() == 1) {
    		int[] answer = new int [msg.length()];
    		answer[0] = index.get(msg);
    		return answer;
    	}
    	// "TOBEORNOTTOBEORTOBEORNOT"
    	char[] m = msg.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	StringBuilder split = new StringBuilder();
    	
    	for (int i = 0; i < m.length ; i++) {
    		sb.append(m[i]);
    		
    		
    		while(i < m.length -1) {
    			String wc = sb.append(m[i+1]).toString();
    			
    			if(index.containsKey(wc)) { //있으면 다음..
    				i++;
    			}else {						//없으면 put index.. 그다음 붙임문자(마지막문자) 떼어내고 break;
    				index.put(wc, index.size()+1);
    				wc = sb.deleteCharAt(sb.length() - 1).toString();
    				// 만약 두자리인 경우 마지막 문자를 떼어내면 한자리가 됨.(그래서 여기서 사전을 찾아 Add)
    				out.add(index.get(wc));
    				split.append(wc);
    				break;
    			}
    		}
    		sb.setLength(0);
    	}

    	int[] answer = new int[out.size()+1];
    	int add = 0;
    	for (Integer i : out) {
    		answer[add++] = i;
		}
    	
		String[] compare = msg.toString().split(split.toString());
		answer[add++] = index.get(compare[1]);
    	
    	
        return answer;
    }
	
	public static void main(String[] args) {
		Ex24 sol = new Ex24();

//		String msg = "TOBEORNOTTOBEORTOBEORNOT";
//		String msg = "ABABABABABABABAB";
		String msg = "A";
		
		System.out.println(sol.solution(msg)); 

	}

}
