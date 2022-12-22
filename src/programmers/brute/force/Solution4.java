package programmers.brute.force;

// 완전탐색 4.카펫
public class Solution4 {
	
	public int[] solution(int brown, int yellow) {
		
		int[] answer = new int[2];
		 int sum = brown + yellow;
	        
        for(int i = 2; i < sum; i++) {
            int k = sum / i; // 4  3  2  2
            if(sum % i == 0 && k >= 3){
                int x = Math.max(i,k);
                int y = Math.min(i,k);
                int z = (x - 2) * (y - 2);
                if(z == yellow) {
                    answer[0] = x;
                    answer[1] = y;
                    
                }
            }
        }

		// 단순화 아이디어 
		// brown 의 w, h 는 항상 yellow 의 w,h 보다 (w+2), (h+2) 이다.
		// w*h = yellow, (w+2)*(h+2) = brown
		// 전개 w+h = (borwn -4) /2
		
//		int[] answer = new int[2];
//		int sum = (brown - 4) / 2;
//		System.out.println(sum);
//		System.out.println();
//		
//		for (int i = sum-1; i >= sum/2; i--) {
////			System.out.println(sum-1);
////			System.out.println(sum/2);
//			System.out.println(i);
//			if(i * (sum -i) == yellow) {
//				answer[0] = i + 2;
//				answer[1] = sum - 1 + 2;
//				break;
//			}
//		}
			
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		
        return answer;
    }

	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		
		int brown = 10;
		int yellow = 2;
		
		System.out.println(sol.solution(brown, yellow));

	}

}
