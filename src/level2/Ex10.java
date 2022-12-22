package level2;

import java.util.Arrays;

// 구명보트(greedy)
/*
 * 무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.

예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만 

1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
 
구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.

사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 

모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 */
public class Ex10 {
	
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        
        // 첫 풀이 (오답)
//        for (int i = 0; i < people.length-1; i++) {
//        	if(people[i] + people[i+1] <= limit) {
//        		answer++;
//        		i++;
//        	}else {
//        		answer++;
//        	}
//        	
//		}        
        // 최소값 두개를 비교하는 것보다.
        // 최대+최소를 비교하는게 효율적인 방법
        
        // 두번째 풀이 
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
