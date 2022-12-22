package kakao2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// �ڵ� �׽�Ʈ ���� ��Ĺ���..?

/*
problems�� ���Ҵ� [alp_req, cop_req, alp_rwd, cop_rwd, cost]�� ���·� �̷���� �ֽ��ϴ�.
alp_req�� ������ Ǫ�µ� �ʿ��� �˰���Դϴ�.
0 �� alp_req �� 150

cop_req�� ������ Ǫ�µ� �ʿ��� �ڵ����Դϴ�.
0 �� cop_req �� 150

alp_rwd�� ������ Ǯ���� �� �����ϴ� �˰���Դϴ�.
0 �� alp_rwd �� 30

cop_rwd�� ������ Ǯ���� �� �����ϴ� �ڵ����Դϴ�.
0 �� cop_rwd �� 30

cost�� ������ Ǫ�µ� ��� �ð��Դϴ�.
1 �� cost �� 100

 */
public class Solution3todo {
	
	public int solution2(int alp, int cop, int[][] problems) {
        // ��� ������ Ǯ�� ���� �䱸�Ǵ� �ִ� �˰��, �ִ� �ڵ���
        int maxAlp = 0, maxCop = 0;
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        System.out.println(maxAlp);
        System.out.println(maxCop);
        
        // times[i][j]: �˰�� i, �ڵ��� j�� ����� ���� �ּ� �ð�
        int SIZE = 152;
        int[][] times = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i > alp || j > cop) {
                    times[i][j] = 300;
                }
            }
        }

        for (int a = 0; a <= maxAlp; a++) {
        	System.out.println();
            for (int c = 0; c <= maxCop; c++) {
            	System.out.print(times[a][c]);
            	
                // �˰�� 1 ����
                times[a + 1][c] = Math.min(times[a + 1][c], times[a][c] + 1);//?
                
                // �ڵ��� 1 ����
                times[a][c + 1] = Math.min(times[a][c + 1], times[a][c] + 1);//?
                
                // ���� Ǯ��
                for (int[] problem : problems) {
                    // �̹� ���� Ǯ�̰� ������ ���
                    if (a >= problem[0] && c >= problem[1]) {
                        int nextAlp = Math.min(maxAlp, a + problem[2]);
                        int nextCop = Math.min(maxCop, c + problem[3]);
                        
                        times[nextAlp][nextCop] = Math.min(times[nextAlp][nextCop], times[a][c] + problem[4]);
                    }
                }
            }
        }

        return times[maxAlp][maxCop];
    }
	public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        // �ܼ�ȭ�ϱ� 
        // 1.������ Ǯ�� �ִٸ� Ǯ�� Ǯ�� ������ Ǯ�� ������ ���� �ɷ�ġ�� ä���.(�Ѱ��� �ɷ¸� up ����)
        // 2.�������� Ǯ�� ���ٸ� ���߿� �ϳ��� �����Ѵ�.(���� ������ �ʿ��� �ɷ�ġ�� ��ٷ��� ä���� ������ Ǯ� ä���� ȿ������ üũ�ؾ��Ѵ�.) cost * rwd 
        // queue + class? 
        /*
		function ����(){
	        if(����Ǯ���ֳ�?){
	    		����Ǯ�� skill up >>>> ��������
	    		
	        }else{ Ǯ������! skill up �ؾߵ�..
	        	
	        	if(���������� �ִ� ���){
	        		if(���������� �� Ǫ�°� ȿ����){
	        		
	        		}else{
	        			��޷��� ��޷��� skill up
	        		}
	        	}else{���������� ���� ���
	        	
	        		��޷��� ��޷��� skill up
	        	}
	        }
        }
        */
        
     
        Queue<Problem> que = new LinkedList<>();
        for (int i = 0; i < problems.length; i++) {
        	que.add(new Problem(problems[i][0], problems[i][1], problems[i][2], problems[i][3], problems[i][4]));
        }
        List<Problem> list = new ArrayList<>();
        
        int success = 0;
        while (!que.isEmpty()) {
        	Problem problem = que.poll();
        	
        	// ����Ǯ���ֳ�?
        	if(alp >= problem.alp_rep && cop >= problem.cop_rep) {// ����Ǯ�� skill up >>>> ��������
        		//�ɷ�ġ �÷��ְ� �ð�++
        		alp += problem.alp_rwd;
        		cop += problem.cop_rwd;
        		answer += problem.cost;
        		
        		// Ǭ list
        		success++;
        		list.add(problem);

        		
        	}else {
        		int short_alp = (problem.alp_rep - alp);
        		int short_cop = (problem.cop_rep - cop);
        		
        		if(short_alp > 0 && short_cop > 0 && list.size() > 0) {
        			Problem re_problem = list.get(success);
        			
        			System.out.println("�ٽ� Ǭ��.");
            		//�ɷ�ġ �÷��ְ� �ð�++
            		alp += re_problem.alp_rwd;
            		cop += re_problem.cop_rwd;
            		answer += re_problem.cost;
        			
        		}else if(short_alp > 0 && list.size() == 0) {
        			answer 	+= short_alp;
        			alp 	+= short_alp;
        		}else if(short_cop > 0 && list.size() == 0) {
        			answer 	+= short_cop;
        			cop		+= short_cop;
        		}
        	}
		}
        	
        			
        return answer;
    }

	class Problem {
		int alp_rep, cop_rep, alp_rwd, cop_rwd, cost;

		public Problem(int alp_rep, int cop_rep, int alp_rwd, int cop_rwd, int cost) {
			this.alp_rep = alp_rep;
			this.cop_rep = cop_rep;
			this.alp_rwd = alp_rwd;
			this.cop_rwd = cop_rwd;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) {
		Solution3todo sol = new Solution3todo();
		
		int alp = 10;//���ڷ�
		int cop = 10;//�ڵ���
		int[][] problems = 
			{{10,15,2,1,2},{20,20,3,3,4}};
//		{{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}};
		
		
		System.out.println(sol.solution2(alp, cop, problems));
	}

}
