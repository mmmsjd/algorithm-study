package beginner;

public class BubbleSort {

	public static void main(String[] args) {
	
		// 버블정렬
		int i, j;
		int temp;
		int a[] = {75, 95, 85, 100, 50};
		
		for (i = 0; i < 4; i++) {			
			System.out.println();
			System.out.println(i+"---");
			for (j = 0; j < 4-i; j++) {
				System.out.println(j+"-------");
				
				System.out.println("check:"+a[j] +", "+  a[j+1]);
				if (a[j] > a[j+1]) {
					System.out.println("true");
					
					temp = a[j];					
					a[j] = a[j+1];
					a[j+1] = temp;
					
					System.out.println("change:"+a[j] +", "+  a[j+1]);					
				}
				
			}
		}
		System.out.println();
		System.out.println("result->");
		for (i = 0; i < 5; i++) {
			System.out.printf("%d ", a[i]);
		}

	}

}
