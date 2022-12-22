package programmers.hash;
import java.util.HashMap;
import java.util.Iterator;

// �ؽ� 3.����(���� �ٸ����� �Ե��� �ϴ� ����)
public class Solution3 {
    public int solution(String[][] clothes) {
    	
    	// 1. �������� �з� 
    	HashMap<String, Integer> map = new HashMap<>();
    	for (String[] s : clothes) {
			String type = s[1];
			map.put(type, map.getOrDefault(type, 0) + 1);
		}
    	// 2. ���� �ʴ� ��� �߰� 
    	int answer = 1;
    	Iterator<Integer> iter = map.values().iterator(); 
    	while(iter.hasNext())
    		answer *= iter.next().intValue() +1;
    		
    	// 3. ��ü �����ϰ� �ƹ��͵� �����ʴ� ��츦 ���ش�.
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
