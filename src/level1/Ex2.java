package level1;


// level
public class Ex2 {
	
	 public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
        int win 	= 0;  	// ¸ÂÃá ¹øÈ£
        int zero 	= 0; 	// ±×Áö°°Àº µ¿»ý³ð
        
        for(int i : lottos){
            if(i == 0){ // µ¿¼ÄÀÌ ¶ËÄ¥ÇÑ ¹øÈ£
                zero++;
            } else {
                for(int j : win_nums){
                if(i == j){
                    win++;
                    break;
                }
            }
            }
        }
        
        answer[0] = (win+zero) > 1 ? 7-(win+zero) : 6;
        answer[1] = win > 1 ? 7-win : 6;
        return answer;
    }



	public static void main(String[] args) {
		Ex2 sol = new Ex2();
		
		int[] n = {44, 1, 0, 0, 31, 25};
		int[] m = {31, 10, 45, 1, 6, 19};				
		
		System.out.println(sol.solution(n, m)[0]);
		System.out.println(sol.solution(n, m)[1]);

	}

}
