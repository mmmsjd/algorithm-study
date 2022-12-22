package programmers.hash;
import java.util.HashMap;
import java.util.Iterator;

// 해시 3.위장(매일 다른옷을 입도록 하는 문제)
public class Solution3 {
    public int solution(String[][] clothes) {
    	
    	// 1. 종류별로 분류 
    	HashMap<String, Integer> map = new HashMap<>();
    	for (String[] s : clothes) {
			String type = s[1];
			map.put(type, map.getOrDefault(type, 0) + 1);
		}
    	// 2. 입지 않는 경우 추가 
    	int answer = 1;
    	Iterator<Integer> iter = map.values().iterator(); 
    	while(iter.hasNext())
    		answer *= iter.next().intValue() +1;
    		
    	// 3. 전체 조합하고 아무것도 입지않는 경우를 빼준다.
        return answer -1;
    }

	
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		
		String[][] s = {{"yellow_hat", "headgear"}, 
				{"blue_sunglasses", "eyewear"}, 
				{"green_turban", "headgear"}};
		
		System.out.println(sol.solution(s));
		
	}

}
