package level2;

// 이진 변환 반복하기
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
        	
        	// 이진변환 
        	while(befor_len > 0) {
        		binary_str = befor_len % 2  + binary_str;
        		befor_len = befor_len / 2;
        	}

        	s = binary_str; // 변환후 
        	answer[0]++; 
        }
        
        return answer;
    }
	
	public int[] solution2(String s) {
		int[] answer = new int[2];
        int zeroCount = 0;
        int length = s.length();
        int count = 0;
        
        // s의 길이가 1이 아닐동안 반복
        while (s.length() != 1) {
            // 이진 변환 횟수 count 증가
            count++;
            s = s.replaceAll("0", "");
            
            // 0의 개수를 저장
            zeroCount += (length - s.length());
            
            // 0 제거 후의 길이
            length = s.length();
            
            s = "";
            // 0 제거 후의 길이 이진 변환
            while (length != 0) {
                s = length % 2 + s;
                length = length / 2;
            }
            // 이진 변환 후 s의 길이 length 저장
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
