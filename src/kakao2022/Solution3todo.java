package kakao2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 코딩 테스트 공부 행렬문제..?

/*
problems의 원소는 [alp_req, cop_req, alp_rwd, cop_rwd, cost]의 형태로 이루어져 있습니다.
alp_req는 문제를 푸는데 필요한 알고력입니다.
0 ≤ alp_req ≤ 150

cop_req는 문제를 푸는데 필요한 코딩력입니다.
0 ≤ cop_req ≤ 150

alp_rwd는 문제를 풀었을 때 증가하는 알고력입니다.
0 ≤ alp_rwd ≤ 30

cop_rwd는 문제를 풀었을 때 증가하는 코딩력입니다.
0 ≤ cop_rwd ≤ 30

cost는 문제를 푸는데 드는 시간입니다.
1 ≤ cost ≤ 100

 */
public class Solution3todo {
	
	public int solution2(int alp, int cop, int[][] problems) {
        // 모든 문제를 풀기 위해 요구되는 최대 알고력, 최대 코딩력
        int maxAlp = 0, maxCop = 0;
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        System.out.println(maxAlp);
        System.out.println(maxCop);
        
        // times[i][j]: 알고력 i, 코딩력 j를 만들기 위한 최소 시간
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
            	
                // 알고력 1 증가
                times[a + 1][c] = Math.min(times[a + 1][c], times[a][c] + 1);//?
                
                // 코딩력 1 증가
                times[a][c + 1] = Math.min(times[a][c + 1], times[a][c] + 1);//?
                
                // 문제 풀이
                for (int[] problem : problems) {
                    // 이번 문제 풀이가 가능할 경우
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
        // 단순화하기 
        // 1.문제를 풀수 있다면 풀고 풀수 없으면 풀수 있을때 까지 능력치를 채운다.(한가지 능력만 up 가능)
        // 2.다음문제 풀수 없다면 둘중에 하나를 선택한다.(다음 문제에 필요한 능력치를 기다려서 채울지 문제를 풀어서 채울지 효율성을 체크해야한다.) cost * rwd 
        // queue + class? 
        /*
		function 선택(){
	        if(문제풀수있냐?){
	    		문제풀고 skill up >>>> 다음문제
	    		
	        }else{ 풀수없다! skill up 해야됨..
	        	
	        	if(이전문제가 있는 경우){
	        		if(이전문제를 또 푸는게 효율적){
	        		
	        		}else{
	        			기달려서 기달려서 skill up
	        		}
	        	}else{이전문제가 없는 경우
	        	
	        		기달려서 기달려서 skill up
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
        	
        	// 문제풀수있냐?
        	if(alp >= problem.alp_rep && cop >= problem.cop_rep) {// 문제풀고 skill up >>>> 다음문제
        		//능력치 올려주고 시간++
        		alp += problem.alp_rwd;
        		cop += problem.cop_rwd;
        		answer += problem.cost;
        		
        		// 푼 list
        		success++;
        		list.add(problem);

        		
        	}else {
        		int short_alp = (problem.alp_rep - alp);
        		int short_cop = (problem.cop_rep - cop);
        		
        		if(short_alp > 0 && short_cop > 0 && list.size() > 0) {
        			Problem re_problem = list.get(success);
        			
        			System.out.println("다시 푼다.");
            		//능력치 올려주고 시간++
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
		
		int alp = 10;//알코력
		int cop = 10;//코딩력
		int[][] problems = 
			{{10,15,2,1,2},{20,20,3,3,4}};
//		{{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}};
		
		
		System.out.println(sol.solution2(alp, cop, problems));
	}

}
