package level2;

import java.math.BigInteger;
import java.util.Arrays;

// k�������� �Ҽ� ���� ���ϱ�
/**
 * ���� ��ȯ <-> �ٽ� ��ȯ
 * �յڿ� 0�� �ִ���?
 * �տ� 0�� �ִ��� 
 * �ڿ� 0�� �ִ���
 * 0�� �����ϸ� �ȵ�?
 * 
 * �Ҽ� ����� 1�� �ڱ� �ڽŻ��� �ڿ���, �� ���� ����� 2���� ���� �ǹ��Ѵ�.
 */
public class Ex22 {
	
	//�̾� �̷��͵� �ֳ�?
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
         * �� �̷� ����� BigInteger.toString(������)
         */
//        String a = new BigInteger(String.valueOf(n)).toString(k);
        
        // k ���� ��ȯ
        String str = "";
        while (n > 0) {
        	str = (n % k) + str;
        	n /= k;			
		}
//        System.out.println(str);
        
        String[] arr = str.split("0");
        for (String s : arr) {
        	if(s.equals("")) continue; // �̷��� �ϴ� ������ ���ڰ� 00�� ��� �߰��� ������ �ü��ִ�.
			if(isPrime(Long.parseLong(s, 10))) answer++; 
		}
        
        // �ٽ� 10���� ��ȯ 
//      int i = Integer.parseInt(str, k);
        
        return answer;
    }
    
    // �������� ���ؼ� �������� ���������� ���� ������������ �Ҽ��� �ƴ�.
	private boolean isPrime(long val) {
		//	0 �� 1�� �Ҽ��� �ƴϴ�. 
		if(val == 0 || val == 1)
			return false;
		int limit  = (int)Math.sqrt(val); //�������� �����ִ� �޼���(�Լ�) ��Ʈ 
		
		// �Ҽ��� 1�� �ڱ��ڽ����θ� �������⿡ �������� ���� �߰��� ������������ �ȵ�..!!!
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
