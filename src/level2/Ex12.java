package level2;

// 예상 대진표

/*
 * 항상 이긴다.
 * 1 2 3 4 5 6 7 8 
 *  1   2   3   4
 *    1       2
 *    
 */
public class Ex12 {

	public int solution(int n, int a, int b) {
		int answer = 0;

//		12 = 1
//		34 = 2
//		56 = 3
//		78 = 4
		
		int count = 0;
		while (true) {
			count++;
			a = ngame(a);
			b = ngame(b);
			
			if(a == b){
				break;
			}
		}
		
		return count;
	}
	int ngame(int i) {
		if(i%2 == 0) return i /2;
		else return (i / 2)+1; 
	}
	public static void main(String[] args) {
		Ex12 sol = new Ex12();

		int n = 8;
		int a = 4;
		int b = 7;
		
		System.out.println(sol.solution(n, a, b));

	}

}
