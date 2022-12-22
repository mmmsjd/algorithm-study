package kakao2022;

// 1.���� ���� 

/* ����̴� �� �ٷ� �̾��� ���ڵ��� ������ ���̸� �Ϸ��� �մϴ�.
 * ���̿��� ���� x, y, z�� �־����ϴ�.
 * ����̴� ���ʿ��� x��° ���ڿ��� ���̸� �����ϰ�, �� �ϸ��� �������̳� �������� �̵��Ͽ� y��° ���ڿ� �����ؾ� �մϴ�.
 * ���̸� �����ϴ� ���� �ִ� z ���� �̵��� �����ϸ�, ��� �̵� ������ �����Ҽ� �ֽ��ϴ�.
 * ����̰� ���̸� �����ϸ� ������ �� �ִ� k��° ���� ��, ������ k �� �ִ밪�� ���ϼ���.
 * 
 * Constraints(���ѻ���): 1<=x,y,z<= 10^8 (100000000) 
 * 
 * Ex1)
 * x = 4; 
 * y = 4;
 * z = 4;
 * 
 * 
 */

/**
 * �ܼ� ���� ���� (�����µ� ������.. ����)
 *
 */

public class Test1 {

	public static void main(String[] args) {

//		int x = 8;
//		int y = 5;
//		int z = 3; //8
		
//		int x = 4;
//		int y = 4;
//		int z = 6; //7
		
//		int x = 4; 
//		int y = 4;
//		int z = 4; //6
		
//		int x = 6; 
//		int y = 9;
//		int z = 10; //12
		
		int x = 100000000; 
		int y = 100000000;
		int z = 3; 

		System.out.println(solution(x,y,z));

	}
	
	public static int solution(int x, int y, int z) {
		
	    int diff = Math.abs(x - y);
	    int max = Math.max(x, y);
	     
	    if(diff > z) return -1;
	    else if(diff == z) return max;
	    else if(diff == 0) {
	    	if(z % 2 == 0) {// ¦��
	    		return max + (z / 2);
	    	}
	    	else {			// Ȧ��
	    		return max + ((z-1) / 2);
	    	}
	    } 
	    else {
	    	int carry = (z - diff);
	    	if(carry % 2 == 0) {// ¦��
	    		return max + (carry / 2); 
	    	}else {				// Ȧ��
	    		return max + ((carry-1) / 2); 
	    	}
	    	
	    }
    }

}
