package programmers.dfs.bfs;

// DFS 1.Å¸°Ù³Ñ¹ö(Àç±Í)
public class Solution1 {
	
	int[] numbers;
	int target;
	int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
	private void dfs(int idx, int sum) {
		
		//1. Å»ÃâÁ¶°Ç
		if(idx == numbers.length) {
			if(sum == target) answer++;
			return;
		}
		
		//2. ¼öÇàµ¿ÀÛ
		dfs(idx + 1, sum + numbers[idx]);
		dfs(idx + 1, sum - numbers[idx]);
		
		 
	}

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		
		int[] num= {1,1,1};
		int target = 1;
		
		System.out.println(sol.solution(num, target));

	}

}
