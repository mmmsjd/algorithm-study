package level2;

// JadenCase 문자열 만들기

public class Ex2 {
	public String solution(String s) {
			
		// 틀렸음..
//		String[] arr = s.split(" ");
//		StringBuilder answer = new StringBuilder();
//		
//		for (int i = 0; i < arr.length; i++) {
//			String str = arr[i];
//			
//			if(!str.isEmpty()) {
//				answer.append(str.substring(0, 1).toUpperCase());
//				answer.append(str.substring(1).toLowerCase());
//				if(i < arr.length-1)
//					answer.append(" ");
//			}else {
//				answer.append(str);
//			}
//		}
//		
		String answer = "";
		String[] arr = s.toLowerCase().split("");
		boolean flag = true;
		
		for(String str : arr) { 
			answer += flag ? str.toUpperCase() : str;
			flag = str.equals(" ") ? true : false;
		}
        
	    return answer.toString();
	}

	public static void main(String[] args) {
		Ex2 sol = new Ex2();
		
//		String s = "3people  unFollowed  me ";	
		String s = "for the last   week";	
		
		System.out.println(sol.solution(s));

	}

}
