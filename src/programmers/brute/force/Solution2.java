package programmers.brute.force;
import java.util.HashSet;
import java.util.Iterator;

// ����Ž�� 1.�Ҽ� ã��
public class Solution2 {

	HashSet<Integer> numberSet = new HashSet<>();
	
    public int solution(String numbers) {
    	int answer = 0;
    	
    	//1. ��� ���������� �����.(����Լ�)
    	recursive("", numbers);
    	
//    	System.out.println(numberSet);
    	
    	//2. �Ҽ������� ����.)
    	Iterator<Integer> iter = numberSet.iterator(); 
    	while(iter.hasNext()) {
    		int val = iter.next();
    		//�Ҽ� �Ǵ�
    		if(isPrime(val)) {
    			answer++;
    		}
    	}
    		
    	//3. �Ҽ������� ��ȯ�Ѵ�.
    	return answer;
    }
	
	private boolean isPrime(int val) {
		//	0 �� 1�� �Ҽ��� �ƴϴ�. 
		if(val == 0 || val == 1)
			return false;
		//	�����佺�׳׽��� ü���� limit�� ��� �� limit ������ ������θ� Ȯ���Ѵ�.
		int limit  = (int)Math.sqrt(val); //�������� �����ִ� �޼���(�Լ�) ��Ʈ 
		
		for (int i = 2; i <= limit; i++) {
			if(val % i == 0)
				return false;
		}
		
		return true;
	}

	private void recursive(String use, String unuse) {
		//1. ���������� Set �� �߰��Ѵ�.

		if(!use.isEmpty())
		numberSet.add(Integer.valueOf(use));
		
		//2. ���� �����߿� ���ο� ������ ����� �ش�.
		for (int i = 0; i < unuse.length(); i++) {
//			System.out.println("use		:"+use + unuse.charAt(i)); // ������
//			System.out.println("unuse	:"+unuse.substring(0, i) + unuse.substring(i+1));// �Ⱦ�����
			recursive(use + unuse.charAt(i), unuse.substring(0, i) + unuse.substring(i+1));
		}
	}

	public static void main(String[] args) {

		Solution2 sol = new Solution2();
		System.out.println(sol.solution("71"));
	}

}
