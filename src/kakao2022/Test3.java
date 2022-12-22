package kakao2022;

// 3.�� �ű��

/* ������ �˹ٻ� �Ҹ��� �Ϸķ� ������ n���� ���� �迭 box�� ��� ���� �ٽ� ���� �������� �մϴ�.
 * �� ���ڴ� 1���� �����ϴ� ���� ������ �ε����� �����ϴ�.
 * �Ҹ���� ������ ���� �������θ� ���� �ű�� ������, �̰����� �����ʰ� �����մϴ�.
 * 
 * ����
 * 1. 2<=i<=n �� �����ϴ� i�� �����ϴ�. 
 * 2. 1<=x<=box[i] �� �����ϴ� x�� �����ϴ�.
 * 3. i��° box���� x�� ��ŭ�� ���� �����ϴ�.(box[i] = box[i]-x)
 * 4. i-1��° box�� ���� x�� ��ŭ�� ���� �ֽ��ϴ�.(box[i-1] = box[i-1]+x)
 * 
 * �Ҹ����� ������ �ű�� ������ ���� �� ��� ���� �� ���� ���� ���� ���ڿ� �� ���� ������ ��������������
 * ���� �ű�� ���Դϴ�.
 * ���������� ������ �ִ� ���� ���� ���� ���ڿ� �� �ּ����� �� ������ ���ϼ���.
 * 
 * Ex1)
 * int n=4
 * int[] box={1,5,7,6}
 * result = 5
 * 
 * ������ �ű�� ������ ������ �����ϴ�.(�迭box�� 1���� �����մϴ�)
 * 	1. ù��° �ű�� : 
 * 		i=3, x=4 ���� (x�� 1 <= 4 <= box[i] �� �����մϴ�.
 * 		i ��° �ڽ����� ���� x�� ��ŭ�� ���� �����ϴ�.(7-4=3)
 * 		i-1 ��° �ڽ��� ���� x�� ��ŭ�� ���� �ֽ��ϴ�. (5+4=9)
 * 	2. �ι�° �ű�� :
 * 		i=2, x=4 ����
 * 		i ��° �ڽ����� ���� x�� ��ŭ�� ���� �����ϴ�.(9-4=5)
 * 		i-1 ��° �ڽ��� ���� x�� ��ŭ�� ���� �ֽ��ϴ�. (1+4=5)
 * 		�迭 box�� ���� [5,5,3,6]�� �Ǿ����ϴ�.(���� ���� ���� ������ �� ������ 6�Դϴ�.)
 * 	3. �ι�° �ű�� :
 * 		i=4, x=1 ����
 * 		�ű��� ����� [5,5,4,5] �Դϴ�. (���� ���� ���� ������ �� ������ 5�Դϴ�.)
 * 
 * Ex2)
 * int n=3
 * int[] box{5,15,19}
 * result = 13
 * 
 *  1. ù��° �ű�� : i=3, x=6 -> [5,21,13] 
 *  2. �ι�° �ű�� : i=2, x=8 -> [13,13,13]
 * 
 * Ex3)
 * int n=4
 * int[] box{10,3,5,7}
 * result = 10
 * 
 * �� ��� �ű�� �ൿ���� ���� ���� ���ڿ� �� �ּ����� �� ������ ���Ϲ���� �����ϴ�.
 * 
 * 2<=i<=n �� �����ϴ� i�� �����ϴ�. <-- ���⼭ Ż��
 */

/**
 * �̷� ������ ó���ε�..?
 * 
 */

public class Test3 {

	public static void main(String[] args) {

		// ������ ����
		int n = 4;
		// ���ڹ迭
		int[] box = {1,5,7,6};
		
		System.out.println(solution(n, box));

	}

	private static char[] solution(int n, int[] box) {
		
		return null;
	}
	

}