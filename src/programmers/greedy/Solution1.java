package programmers.greedy;

import java.util.HashSet;

// �׸��� 1. ü����
public class Solution1 {
	
	// ü����(HashSet���� Ǯ��)
    public int solution(int n, int[] lost, int[] reserve) {
    	
    	// 1.Set ���� 
    	// ������ ���� �ִ� ���
    	HashSet<Integer> wear_student = new HashSet<>();
    	// �� �Ҿ���� ���
    	HashSet<Integer> lost_student = new HashSet<>(); 
    	
    	for(int wear_stu : reserve)
    		wear_student.add(wear_stu);
    	
    	for(int lost_stu:lost) {
    		// �� ������ ���� ���� �Ҿ���ȴٸ� ������ ���� ���� �Ծ�� �ϱ� ������ ������ �� ���� ó��.
    		if(wear_student.contains(lost_stu)){ 
    			wear_student.remove(lost_stu);
    		}else {
    			lost_student.add(lost_stu);
    		}
    	}
    	
    	// 2.���к����ִ� ó��
    	// ��ȣ �յ� �� �����ټ� �ִٳ�.. �� �յڳ��� �Ҿ���� ������ Ȯ���ϰ� �����ְ� lost_student���� ����.
    	for (int wear_stu : wear_student) {
    		if(lost_student.contains(wear_stu-1)) {
    			lost_student.remove(wear_stu-1);
    		}else if(lost_student.contains(wear_stu+1)){
    			lost_student.remove(wear_stu+1);
    		}
			
		}
    	
    	// 3. ������ ���     	
    	// ������� �Դٸ� ���� ������ ��鸸 lost_student �� ��������. �ѿ����� ���ش�.
        int answer = n - lost_student.size();
        return answer;
    }
    
    // ü����(�迭�� ����Ǯ��)
    public int solution2(int n, int[] lost, int[] reserve) {
    	
    	// 1. �迭����
    	int[] student = new int[n+2]; 
    	int answer = 0;
    	
    	// 2. �迭�� ���� �ݿ�
    	for (int l : lost) {
    		student[l]--;
		}
    	for (int r : reserve) {
    		student[r]++;
		}
    	
    	// 3. ������ ó�� 
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
    	// 4. �������
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
