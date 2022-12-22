package level2;

import java.util.HashSet;
import java.util.Set;

// 방문길이 

/*
U: 위쪽으로 한 칸 가기

D: 아래쪽으로 한 칸 가기

R: 오른쪽으로 한 칸 가기

L: 왼쪽으로 한 칸 가기
 */
public class Ex31 {
			
	 
    public int solution(String dirs) {
        int max = 5;
        int min = -5;
        
        int x = 0; 		// 위아래
        int y = 0; 		// 좌우
        int bf_x = 0;	// 이전 위아래
        int bf_y = 0;	// 이전 좌우
        
        Set<String> set = new HashSet<>();
        
    	for (int i = 0; i < dirs.length(); i++) {
    		char c = dirs.charAt(i);
    		if(c=='U') {
    			if(x >= max) {
    				continue;
    			}else {
    				bf_x = x;
    				bf_y = y;
    				x++;
    			}
    		}else if(c=='D') {
    			if(x <= min) {
    				continue;
    			}else {
    				bf_x = x;
    				bf_y = y;
    				x--;
    			}
    		}else if(c=='L') {
    			if(y <= min) {
    				continue;
    			}else {
    				bf_x = x;
    				bf_y = y;
    				y--;
    				
    			}
    		}else {
    			if(y >= max) {
    				continue;
    			}else {
    				bf_x = x;
    				bf_y = y;
    				y++;
    				
    			}
    				
    		}
    		set.add(String.valueOf(bf_x) + String.valueOf(bf_y) + String.valueOf(x) + String.valueOf(y));   
    		set.add(String.valueOf(x) + String.valueOf(y) + String.valueOf(bf_x) + String.valueOf(bf_y));   
		}
    	        
        return set.size()/2;
    }
    
	public static void main(String[] args) {
		Ex31 sol = new Ex31();
		
		String dirs = "ULURRDLLU";
//		String dirs = "LULLLLLLU";
		System.out.println(sol.solution(dirs)); 

	}

}
