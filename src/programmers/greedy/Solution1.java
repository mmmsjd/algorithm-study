package programmers.greedy;

import java.util.HashSet;

// 그리디 1. 체육복
public class Solution1 {
	
	// 체육복(HashSet으로 풀이)
    public int solution(int n, int[] lost, int[] reserve) {
    	
    	// 1.Set 생성 
    	// 빌려줄 옷이 있는 놈들
    	HashSet<Integer> wear_student = new HashSet<>();
    	// 옷 잃어버린 놈들
    	HashSet<Integer> lost_student = new HashSet<>(); 
    	
    	for(int wear_stu : reserve)
    		wear_student.add(wear_stu);
    	
    	for(int lost_stu:lost) {
    		// 옷 빌려줄 놈이 옷을 잃어버렸다면 빌려줄 옷을 지가 입어야 하기 때문에 빌려줄 옷 없음 처리.
    		if(wear_student.contains(lost_stu)){ 
    			wear_student.remove(lost_stu);
    		}else {
    			lost_student.add(lost_stu);
    		}
    	}
    	
    	// 2.여분빌려주는 처리
    	// 번호 앞뒤 놈만 빌려줄수 있다네.. 내 앞뒤놈이 잃어버린 놈인지 확인하고 빌려주고 lost_student에서 빼줌.
    	for (int wear_stu : wear_student) {
    		if(lost_student.contains(wear_stu-1)) {
    			lost_student.remove(wear_stu-1);
    		}else if(lost_student.contains(wear_stu+1)){
    			lost_student.remove(wear_stu+1);
    		}
			
		}
    	
    	// 3. 나머지 계산     	
    	// 여기까지 왔다면 옷을 못빌린 놈들만 lost_student 에 남아있음. 총원에서 빼준다.
        int answer = n - lost_student.size();
        return answer;
    }
    
    // 체육복(배열로 문제풀이)
    public int solution2(int n, int[] lost, int[] reserve) {
    	
    	// 1. 배열생성
    	int[] student = new int[n+2]; 
    	int answer = 0;
    	
    	// 2. 배열에 정보 반영
    	for (int l : lost) {
    		student[l]--;
		}
    	for (int r : reserve) {
    		student[r]++;
		}
    	
    	// 3. 빌려줌 처리 
    	for (int i = 1; i <= n; i++) {
			if(student[i] == 1) {
				if(student[i-1] == -1) {
					student[i]--;
					student[i-1]++;
					
				}else if(student[i+1] == -1) {
					student[i]--;
					student[i+1]++;
				}
			}
		}
    	for (int i = 1; i <= n; i++) {
    		if(student[i] >= 0) {
				answer ++;
				
			}
		}
    	// 4. 결과리턴
        return answer;
    }

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};
		
		
		System.out.println(sol.solution(n, lost, reserve));

	}

}
