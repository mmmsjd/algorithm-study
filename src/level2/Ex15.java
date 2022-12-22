package level2;

import java.util.LinkedList;

// [1차] 캐시
// 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
// cache hit일 경우 실행시간은 1이다.
// cache miss일 경우 실행시간은 5이다.
// LinkedList Dequeue 자료 형태를 쓴다..


public class Ex15 {
    public int solution(int cacheSize, String[] cities) {
    	int answer = 0;
    	int hit = 1;
    	int miss = 5;
    	
    	if(cacheSize == 0) return miss * cities.length;
    	
        LinkedList<String> list = new LinkedList<>();
        
        for (int i = 0; i < cities.length; i++) {
        	String city = cities[i].toLowerCase();
        	
        	if(list.remove(city)) {
        		list.addFirst(city);
        		answer += hit;
        		
        	}else {
        		int currentSize = list.size();
        		
        		if(currentSize == cacheSize) {
        			list.pollLast();
        		}
        		list.addFirst(city);
        		answer += miss;
        	}
			
		}
        return answer;
    }
    
	public static void main(String[] args) {
		Ex15 sol = new Ex15();

		int cache = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		System.out.println(sol.solution(cache, cities));

	}

}
