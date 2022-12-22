package programmers.brute.force;
import java.util.HashSet;
import java.util.Iterator;

// 완전탐색 1.소수 찾기
public class Solution2 {

	HashSet<Integer> numberSet = new HashSet<>();
	
    public int solution(String numbers) {
    	int answer = 0;
    	
    	//1. 모든 숫자조합을 만든다.(재귀함수)
    	recursive("", numbers);
    	
//    	System.out.println(numberSet);
    	
    	//2. 소수개수만 샌다.)
    	Iterator<Integer> iter = numberSet.iterator(); 
    	while(iter.hasNext()) {
    		int val = iter.next();
    		//소수 판단
    		if(isPrime(val)) {
    			answer++;
    		}
    	}
    		
    	//3. 소수개수를 반환한다.
    	return answer;
    }
	
	private boolean isPrime(int val) {
		//	0 과 1은 소수가 아니다. 
		if(val == 0 || val == 1)
			return false;
		//	에라토스테네스의 체에서 limit을 계산 후 limit 까지만 배수여부를 확인한다.
		int limit  = (int)Math.sqrt(val); //제곱근을 구해주는 메서드(함수) 루트 
		
		for (int i = 2; i <= limit; i++) {
			if(val % i == 0)
				return false;
		}
		
		return true;
	}

	private void recursive(String use, String unuse) {
		//1. 현재조합을 Set 에 추가한다.

		if(!use.isEmpty())
		numberSet.add(Integer.valueOf(use));
		
		//2. 남은 숫자중에 새로운 조합을 만들어 준다.
		for (int i = 0; i < unuse.length(); i++) {
//			System.out.println("use		:"+use + unuse.charAt(i)); // 쓴조합
//			System.out.println("unuse	:"+unuse.substring(0, i) + unuse.substring(i+1));// 안쓴조합
			recursive(use + unuse.charAt(i), unuse.substring(0, i) + unuse.substring(i+1));
		}
	}

	public static void main(String[] args) {

		Solution2 sol = new Solution2();
		System.out.println(sol.solution("71"));
	}

}
