package level2;

// 다음 큰 숫자
public class Ex7 {
	
	
	public int solution(int n) {
		
		// 개간단하네.. Integer.bitCount(n);
		int bitCount = Integer.bitCount(n);
		System.out.println(bitCount);
		
		String ori_str = Integer.toBinaryString(n);
		int one_count = 0;
		for(char c : ori_str.toCharArray()) {
    		if(c == '1')
    			one_count++;
    	}
		int m = n;
		
		while (true) {
			m++;
			String m_str = Integer.toBinaryString(m);
			int target_count = 0;
			for(char c : m_str.toCharArray()) {
        		if(c == '1')
        			target_count++;
        	}
//			System.out.print(one_count+",");
//			System.out.println(target_count);
			if(target_count == one_count) break;
		}
		
        return m;
    }
	

	public static void main(String[] args) {
		Ex7 sol = new Ex7();
		
		int n = 15;
		System.out.println(sol.solution(n));

	}

}
