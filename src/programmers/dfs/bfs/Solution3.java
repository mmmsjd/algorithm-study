package programmers.dfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

// BFS 3.���� �� �ִܰŸ�(ť)
public class Solution3 {
	
	public int solution(int[][] maps) {
		// ���̵��(ť+�迭)
		
		// maps�� ������ ũ��� -1�� �ʱ�ȭ�� visited
		// boolean�� �ƴ� int[][]�� ����ϴ� ������ �������� ĭ ������ visited�� ����ϱ� ���ؼ��Դϴ�.
		// ���� ��ġ�� 0,0���� ť�� �־��ָ鼭 bfs ������ �ݴϴ�.(visit) 
		// bfs �����ϸ鼭 visited�� ���� ���̿� +1 ���ָ� �������� ĭ�� ������ ������ �ݴϴ�. 

		int n = maps.length; 
		int m = maps[0].length;
        int[][] visited = new int[n][m];
        
        // ���� -1
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = -1;
            }
        }
        //ť ���
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {0,0});
        visited[0][0] = 1;// ù�湮 ������ 1

        //��������(�׷����� �˰ڳ�..)
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            
            for(int i=0; i<4; i++){
            
                int nx = node[0] + dx[i];//0,1,0,-1
                int ny = node[1] + dy[i];//1,0,-1,0

                
                if(0 <= nx 			//0 <=
                		&& nx < n 	//map.length ���� ���� �۾ƾ���.
                		&& 0 <= ny 	//0 <= 
                		&& ny < m){ //map[0].length ���� ���� �۾ƾ���.
                	
                	//debug
//                	System.out.print(nx);
//                	System.out.print(",");
//                    System.out.print(ny);
//                    System.out.println();
                    
                    if(maps[nx][ny] == 1 && visited[nx][ny] == -1){// 1�̸鼭 �湮���߾��ٸ� 
                    	
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
		
		// ���̵��(ť+Ŭ����)
		// �̰� �� �������̳� 
		// �޸𸮸� ���� ����ϱ� ������ �� ������
		
    	int n = maps.length;
    	int m = maps[0].length;
    	Queue<MapPoint> queue = new LinkedList<>();
    	
    	queue.add(new MapPoint(0, 0, 1));
    	
    	maps[0][0] = 0;
    	
    	while(!queue.isEmpty()) {
    		MapPoint cur = queue.poll();
//    		System.out.println(cur.x+","+cur.y);
    		
    		if(cur.x == n-1 && cur.y == m-1) { // ������ ����
    			answer = cur.level;
    			break;
    		}
    		
    		if(cur.x > 0 && maps[cur.x-1][cur.y] == 1) { //����
    			maps[cur.x-1][cur.y] = 0;
    			queue.add(new MapPoint(cur.x-1, cur.y, cur.level+1));
    		}
    		
    		if(cur.x < n-1 && maps[cur.x+1][cur.y] == 1) {//������
    			maps[cur.x+1][cur.y] = 0;
    			queue.add(new MapPoint(cur.x+1, cur.y, cur.level+1));
    		}
    		
    		if(cur.y > 0 && maps[cur.x][cur.y-1] == 1) {//��
    			maps[cur.x][cur.y-1] = 0;
    			queue.add(new MapPoint(cur.x, cur.y-1, cur.level+1));
    		}
    		
    		if(cur.y < m-1 && maps[cur.x][cur.y+1] == 1) {//�Ʒ�
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
