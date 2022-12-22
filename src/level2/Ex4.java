package level2;

// ���� ��ȯ �ݺ��ϱ�
public class Ex4 {
	
	public int[] solution(String s) {
		int[] answer = new int[2];
        
        while(s.length() != 1) {
        	for(char c : s.toCharArray()) {
        		if(c == '0')
        			answer[1]++;
        	}
        	
        	s = s.replaceAll("0", "");
        	
        	int befor_len = s.length();
        	String binary_str = "";
        	
        	// ������ȯ 
        	while(befor_len > 0) {
        		binary_str = befor_len % 2  + binary_str;
        		befor_len = befor_len / 2;
        	}

        	s = binary_str; // ��ȯ�� 
        	answer[0]++; 
        }
        
        return answer;
    }
	
	public int[] solution2(String s) {
		int[] answer = new int[2];
        int zeroCount = 0;
        int length = s.length();
        int count = 0;
        
        // s�� ���̰� 1�� �ƴҵ��� �ݺ�
        while (s.length() != 1) {
            // ���� ��ȯ Ƚ�� count ����
            count++;
            s = s.replaceAll("0", "");
            
            // 0�� ������ ����
            zeroCount += (length - s.length());
            
            // 0 ���� ���� ����
            length = s.length();
            
            s = "";
            // 0 ���� ���� ���� ���� ��ȯ
            while (length != 0) {
                s = length % 2 + s;
                length = length / 2;
            }
            // ���� ��ȯ �� s�� ���� length ����
            length = s.length();
        }
        
        answer[0] = count;
        answer[1] = zeroCount;
        
        return answer;
    }
	public static void main(String[] args) {
		Ex4 sol = new Ex4();
		
		String s = "110010101001";
		System.out.println(sol.solution(s)[0]);
		System.out.println(sol.solution(s)[1]);

	}

}
