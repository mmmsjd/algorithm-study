package programmers.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 그래프 1. 가장먼노드
public class Solution1todo {
	
	public int solution2(int n, int[][] edge) {
	 	int answer = 0;
	 	
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit_edge = new boolean[edge.length];//7
        boolean[] visit_vertex = new boolean[n+1];//7
        int[] length = new int[n+1];
        
        q.add(1);
        
        while(!q.isEmpty()){
            int vertex = q.poll();//1
            visit_vertex[vertex] = true;
            
            for(int i = 0 ; i < edge.length ; i++){
                if(visit_edge[i] == true)   // 방문한 edge 배열 처리
                    continue;
                else{
                    int next = -1 ;
                    if(vertex == edge[i][0])
                        next = edge[i][1];
                    else if(vertex == edge[i][1])
                        next = edge[i][0];
                    if(next == -1)
                        continue;
                    else{
                        visit_edge[i] = true;
                        if(visit_vertex[next] == true)  // 방문한 vertex 처리
                            continue;
                        else{
                            q.add(next);
                            visit_vertex[next] = true;
                            if(length[next] == 0)
                                length[next] = length[vertex]+1;    // 거리 계산
                        }
                    }
                }
            }
        }
        
        Arrays.sort(length);        
        int max = length[length.length-1];
        
        for(int i = length.length-1; i >= 0  ; i--){
            if(max == length[i])
                answer++;
            else{
                break;
            }
        }
        
        
        return answer;
	}
	
	// 1.이해가 잘안가..
	public int solution(int n, int[][] edge) {
		// hint BFS
		
		int[] distance = new int[n+1];
        boolean [][] map = new boolean[n+1][n+1];
        
        for (int i = 0; i < edge.length; i++) {
//        	System.out.print("("+edge[i][0]+","+edge[i][1]+")");
//        	System.out.print("("+edge[i][1]+","+edge[i][0]+")");
//        	System.out.println();        	
            map[edge[i][0]][edge[i][1]] = true;
            map[edge[i][1]][edge[i][0]] = true;
        }
//        (3,6)(6,3)
//        (4,3)(3,4)
//        (3,2)(2,3)
//        (1,3)(3,1)
//        (1,2)(2,1)
//        (2,4)(4,2)
//        (5,2)(2,5)
        
//             0      1      2      3      4      5      6
//           0[false, false, false, false, false, false, false],
//           1[false, false, true,  true,  false, false, false],
//           2[false, true,  false, true,  true,  true,  false],
//           3[false, true,  true,  false, true,  false, true ],
//           4[false, false, true,  true,  false, false, false],
//           5[false, false, true,  false, false, false, false],
//           6[false, false, false, true,  false, false, false]
        		   
        Queue<Integer> queue = new LinkedList<>();        
        queue.add(1);
        
        // BFS 탐색
        int max = 0;
        while(!queue.isEmpty()) {
            int i = queue.poll();

            for (int j = 2; j <= n; j++) { //이해가 안가..
                if( distance[j] == 0 && map[i][j] ) {             	
                 	distance[j] = distance[i] + 1;          	
                    queue.add(j);
                    
                    max = Math.max(max,distance[j]);
                }
            }
        }
        
        // 가장 멀리 있는 노드가 몇 개인지 계산
        int answer = 0;
        for (int d : distance) {
        	
            if(max == d)
            	answer++;
        }
        return answer;
    }

	public static void main(String[] args) {
		Solution1todo sol = new Solution1todo();
		
		int n = 6;
		int[][] edge= {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		
		System.out.println(sol.solution2(n, edge));

	}

}
