package level2;

import java.util.HashMap;
import java.util.TreeMap;

//주차 요금 계산
//hashmap 을 두개써서 하나는 취합용, 하나는 누적용으로 !!! 하나 배웠다잉!!!


/**
 * 기본 시간(분)	기본 요금(원)		단위 시간(분)	  단위 요금(원)
------------------|----------------|-------------------|--------------
			180				5000				10				600
			
차량 번호						누적 주차 시간(분)					주차 요금(원)
------|---------------------|-------------------------------------|----------------
0000	34 + 300 = 334			5000 + ⌈(334 - 180) / 10⌉ x 600 = 	14600
0148	670						5000 + ⌈(670 - 180) / 10⌉ x 600 = 	34400
5961	145 + 1 = 146			5000

출차를 안했다면 23:59로 계산
 */
public class Ex23 {
	
	public int[] solution(int[] fees, String[] records) {
		int full_time 	= 1439;
		
		HashMap<String, Integer> intime = new HashMap<>();
		TreeMap<String, Integer> result = new TreeMap<>();
		
		for (int i = 0; i < records.length; i++) {
			String[] arr 		= records[i].split(" ");
			String hour 		= arr[0].split(":")[0];
			String minu 		= arr[0].split(":")[1];
			String car_num 		= arr[1];
			String in_out 		= arr[2];
			
			int total_minu = Integer.parseInt(hour) * 60 + Integer.parseInt(minu);
			
			// 핵심코드
			if(in_out.equals("IN")) {
				intime.put(car_num, total_minu);
				if(!result.containsKey(car_num)) result.put(car_num, 0);
			}else {
				result.put(car_num, result.get(car_num) + total_minu - intime.get(car_num));//누적계산!!!
				intime.remove(car_num);

			}
		}
		
		// intime에 남아있는 놈이 안나간 놈 23:59 로 계산!!!
		for (String key :intime.keySet()) {
			result.put(key, result.get(key) + full_time - intime.get(key));	
//			intime.remove(key);
		}
		
		int[] answer 	= new int[result.size()];
		
		int add = 0;		
		for(int value : result.values()) {
			int bill = fees[1];
			if(value > fees[0]) {				
				bill +=  Math.ceil((value - fees[0]) / (double)fees[2]) * fees[3];
			}
			answer[add++] = bill;
		}
		System.out.println(intime.toString());
		return answer;
	}
	
	public static void main(String[] args) {
		Ex23 sol = new Ex23();

		int[] n = {180, 5000, 10, 600};
		String[] record = {	"05:34 5961 IN", 
							"06:00 0000 IN", 
							"06:34 0000 OUT", 
							"07:59 5961 OUT", 
							"07:59 0148 IN", 	//<
							"18:59 0000 IN", 
							"19:09 0148 OUT", 	//<
							"22:59 5961 IN", 
							"23:00 5961 OUT"};
		
		System.out.println(sol.solution(n, record)); 

	}

}
