package level2;

import java.math.BigInteger;
import java.util.Arrays;

// k진수에서 소수 개수 구하기
/**
 * 진법 변환 <-> 다시 변환
 * 앞뒤에 0이 있는지?
 * 앞에 0이 있는지 
 * 뒤에 0이 있는지
 * 0을 포함하면 안됨?
 * 
 * 소수 약수가 1과 자기 자신뿐인 자연수, 즉 양의 약수가 2개인 수를 의미한다.
 */
public class Ex22 {
	
	//이야 이런것도 있네?
	public int solution2(int n, int k) {
        String s = Integer.toString(n, k);
        return (int) Arrays.stream(s.split("0"))
                .filter(p ->
                        !p.isEmpty()
                                && !p.equals("1")
                                && isPrime(BigInteger.valueOf(Long.parseLong(p)))
                                && (s.contains("0${p}0")
                                || s.contains("${p}0")
                                || s.contains("0${p}")
                                || s.contains(p))
                )
                .count();
    }

	private boolean isPrime(BigInteger n) {
		long l = 2;

		while (l <= Math.sqrt(n.doubleValue())) {
			if (n.remainder(BigInteger.valueOf(l)) == BigInteger.ZERO)
				return false;
			l++;
		}
		return true;
	}

    public int solution(int n, int k) {
        int answer = 0;
        /**
         * 오 이런 방법이 BigInteger.toString(진법수)
         */
//        String a = new BigInteger(String.valueOf(n)).toString(k);
        
        // k 진법 변환
        String str = "";
        while (n > 0) {
        	str = (n % k) + str;
        	n /= k;			
		}
//        System.out.println(str);
        
        String[] arr = str.split("0");
        for (String s : arr) {
        	if(s.equals("")) continue; // 이렇게 하는 이유는 문자가 00인 경우 중간에 공백이 올수있다.
			if(isPrime(Long.parseLong(s, 10))) answer++; 
		}
        
        // 다시 10진법 변환 
//      int i = Integer.parseInt(str, k);
        
        return answer;
    }
    
    // 제곱근을 구해서 제곱보다 작을떄까지 값을 나눠떨어지면 소수가 아님.
	private boolean isPrime(long val) {
		//	0 과 1은 소수가 아니다. 
		if(val == 0 || val == 1)
			return false;
		int limit  = (int)Math.sqrt(val); //제곱근을 구해주는 메서드(함수) 루트 
		
		// 소수는 1과 자기자신으로만 나눠지기에 제곱까지 가는 중간에 나눠떨어지면 안됨..!!!
		for (int i = 2; i <= limit; i++) {
			if(val % i == 0)
				return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		Ex22 sol = new Ex22();

		int n = 1000000;
		int k = 3;
		System.out.println(sol.solution(n, k)); 

	}

}
