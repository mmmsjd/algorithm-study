package programmers.dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

// BFS 3.게임 맵 최단거리(큐)
public class Solution3 {
	
	public int solution(int[][] maps) {
		// 아이디어(큐+배열)
		
		// maps와 동일한 크기로 -1로 초기화한 visited
		// boolean이 아닌 int[][]를 사용하는 이유는 지나가는 칸 개수를 visited에 기록하기 위해서입니다.
		// 시작 위치인 0,0부터 큐에 넣어주면서 bfs 수행해 줍니다.(visit) 
		// bfs 수행하면서 visited에 이전 길이에 +1 해주며 지나가는 칸의 개수를 갱신해 줍니다. 

		int n = maps.length; 
		int m = maps[0].length;
        int[][] visited = new int[n][m];
        
        // 전부 -1
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = -1;
            }
        }
        //큐 사용
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {0,0});
        visited[0][0] = 1;// 첫방문 무조건 1

        //동서남북(그려봐야 알겠네..)
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            
            for(int i=0; i<4; i++){
            
                int nx = node[0] + dx[i];//0,1,0,-1
                int ny = node[1] + dy[i];//1,0,-1,0

                
                if(0 <= nx 			//0 <=
                		&& nx < n 	//map.length 길이 보다 작아야함.
                		&& 0 <= ny 	//0 <= 
                		&& ny < m){ //map[0].length 길이 보다 작아야함.
                	
                	//debug
//                	System.out.print(nx);
//                	System.out.print(",");
//                    System.out.print(ny);
//                    System.out.println();
                    
                    if(maps[nx][ny] == 1 && visited[nx][ny] == -1){// 1이면서 방문안했었다면 
                    	
                        visited[nx][ny] = visited[node[0]][node[1]] +1; // (0,0)+1=1, (0,1)+1=2
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        } 
        
		return visited[n-1][m-1];
    }
	
	public int solution2(int[][] maps) {
		int answer = -1;
		
		// 아이디어(큐+클래스)
		// 이게 더 직관적이네 
		// 메모리를 좀더 사용하긴 하지만 더 직관적
		
    	int n = maps.length;
    	int m = maps[0].length;
    	Queue<MapPoint> queue = new LinkedList<>();
    	
    	queue.add(new MapPoint(0, 0, 1));
    	
    	maps[0][0] = 0;
    	
    	while(!queue.isEmpty()) {
    		MapPoint cur = queue.poll();
//    		System.out.println(cur.x+","+cur.y);
    		
    		if(cur.x == n-1 && cur.y == m-1) { // 마지막 리턴
    			answer = cur.level;
    			break;
    		}
    		
    		if(cur.x > 0 && maps[cur.x-1][cur.y] == 1) { //왼쪽
    			maps[cur.x-1][cur.y] = 0;
    			queue.add(new MapPoint(cur.x-1, cur.y, cur.level+1));
    		}
    		
    		if(cur.x < n-1 && maps[cur.x+1][cur.y] == 1) {//오른쪽
    			maps[cur.x+1][cur.y] = 0;
    			queue.add(new MapPoint(cur.x+1, cur.y, cur.level+1));
    		}
    		
    		if(cur.y > 0 && maps[cur.x][cur.y-1] == 1) {//위
    			maps[cur.x][cur.y-1] = 0;
    			queue.add(new MapPoint(cur.x, cur.y-1, cur.level+1));
    		}
    		
    		if(cur.y < m-1 && maps[cur.x][cur.y+1] == 1) {//아래
    			maps[cur.x][cur.y+1] = 0;
    			queue.add(new MapPoint(cur.x, cur.y+1, cur.level+1));
    		}
    	}
    	
		return answer;
    }
    
	class MapPoint{
    	int x;
    	int y;
    	int level;
    	
    	MapPoint(int x, int y, int level) {
    		this.x = x;
    		this.y = y;
    		this.level = level;
    	}
    }



	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		
		int[][] maps= {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		
		System.out.println(sol.solution2(maps));

	}

}
