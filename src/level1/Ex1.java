package level1;


// level
public class Ex1 {
	
	public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int max = Math.max(n, m);
	    int min = Math.min(n, m);
	    
	    answer[0] = gcd(min, max);
	    answer[1] = lcm(min, max);
	    

        return answer;
    }
	
	private int lcm(int min, int max) {
		return Math.abs(min * max)/gcd(min, max); 
	}
	
	private int gcd(int min, int max) {
		int answer = 1;
		for (int i=1; i<=max; i++) {
			if (min % i == 0 && max % i == 0) {
				answer = i;
			}
		}
	        
		return answer;
	}



	public static void main(String[] args) {
		Ex1 sol = new Ex1();
		
		int n = 2;
		int m = 5;				
		
		System.out.println(sol.solution(n, m));

	}

}
