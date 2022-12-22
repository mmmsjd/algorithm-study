package level2;

import java.util.Arrays;

// ����Ʈ(greedy)
/*
 * ���ε��� ���� ������� ����Ʈ�� �̿��Ͽ� �����Ϸ��� �մϴ�. ����Ʈ�� �۾Ƽ� �� ���� �ִ� 2�� �ۿ� Ż �� ����, ���� ���ѵ� �ֽ��ϴ�.

���� ���, ������� �����԰� [70kg, 50kg, 80kg, 50kg]�̰� ����Ʈ�� ���� ������ 100kg�̶�� 2��° ����� 4��° ����� ���� Ż �� ������ 

1��° ����� 3��° ����� ������ ���� 150kg�̹Ƿ� ����Ʈ�� ���� ������ �ʰ��Ͽ� ���� Ż �� �����ϴ�.
 
����Ʈ�� �ִ��� ���� ����Ͽ� ��� ����� �����Ϸ��� �մϴ�.

������� �����Ը� ���� �迭 people�� ����Ʈ�� ���� ���� limit�� �Ű������� �־��� ��, 

��� ����� �����ϱ� ���� �ʿ��� ����Ʈ ������ �ּڰ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 */
public class Ex10 {
	
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        
        // ù Ǯ�� (����)
//        for (int i = 0; i < people.length-1; i++) {
//        	if(people[i] + people[i+1] <= limit) {
//        		answer++;
//        		i++;
//        	}else {
//        		answer++;
//        	}
//        	
//		}        
        // �ּҰ� �ΰ��� ���ϴ� �ͺ���.
        // �ִ�+�ּҸ� ���ϴ°� ȿ������ ���
        
        // �ι�° Ǯ�� 
        int min = 0;
        for (int max = people.length-1; max >= min ; max--) {
        	if(people[min] + people[max] <= limit) {
        		answer++;
        		min++;
        	}else {
        		answer++;
        	}
        	
		}        
        
        return answer;
    }
    
    public int solution2(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;

        for (int max = people.length - 1; min <= max; max--){
          if (people[min] + people[max] <= limit) min++;
          answer++;
        }

        return answer;
    }

	public static void main(String[] args) {
		Ex10 sol = new Ex10();

		int[] people = {70, 50, 80, 50};
		int limit = 100;
		System.out.println(sol.solution(people, limit));

	}

}
