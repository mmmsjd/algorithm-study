package level2;

// ����� ����
// matrix(���) �� ����
/*
 * ��� ������ �� * �� �̴�..���� ��� (3x2) * (2x2) �� ������ �����ϳ� (3x2) * (2x3) �� ������ �Ұ��ϴ�.
 */
public class Ex17 {

	public int[][] solution(int[][] arr1, int[][] arr2) {
								// [3]*[2]
		int[][] answer = new int[arr1.length][arr2[0].length];

		System.out.println(arr1.length);
		System.out.println(arr1[0].length);
		System.out.println(arr1[1].length);
		System.out.println();
		System.out.println(arr2.length);
		System.out.println(arr2[0].length);
		System.out.println(arr2[1].length);
		
		for (int i = 0; i < arr1.length; i++) { // 3
			
			for (int j = 0; j < arr2[0].length; j++) { // 2
				
				for (int n = 0; n < arr1[0].length; n++) {// 2
					
					answer[i][j] += (arr1[i][n] * arr2[n][j]);
				}
			}
		}

		return answer;
	         
	}
    
	public static void main(String[] args) {
		Ex17 sol = new Ex17();

		int[][] arr1 = {{1, 4}, 
						{3, 2}, 
						{4, 1}};
		
		int[][] arr2 = {{3, 3}, 
						{3, 3}};
		
		System.out.println(sol.solution(arr1, arr2));

	}

}
