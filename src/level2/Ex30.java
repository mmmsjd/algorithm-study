package level2;

// 땅따먹기 최대값구하기(완전탐색?그리디,DP?) -> DP!!!

/*
 * n행 4열
| 1 | 2 | 3 | 5 |

| 5 | 6 | 7 | 8 |

| 4 | 3 | 2 | 1 |

단, 땅따먹기 게임에는 한 행씩 내려올 때, 
같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
 */

public class Ex30 {
	// 이풀이는 어떤 패스로 실행하던 최고값을 획득한다.
	
	int solution2(int[][] land) {
		int answer = 0;

		for (int i = 1; i < land.length; i++) {

			land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
			land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
			land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
			land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
		}
		answer = Math.max(land[land.length - 1][0],
				Math.max(land[land.length - 1][1], Math.max(land[land.length - 1][2], land[land.length - 1][3])));

		return answer;
	}

	// 이게 제대로임
	int solution1(int[][] land) {
		int answer = 0;
		for (int i = 1; i < land.length; i++) {			
			for (int j = 0; j < 4; j++) {
				
				int max = 0;
				
				for (int k = 0; k < 4; k++) {
					// 이전열과 현재열이 같으면 패스 
					if(j==k)
						continue;
					
					//가장큰수 구하기 
					max = Math.max(land[i -1][k], max);
					
				}
				land[i][j] += max;
			}
		}
		answer = Math.max(land[land.length - 1][0], Math.max(land[land.length - 1][1], Math.max(land[land.length - 1][2], land[land.length - 1][3])));

		return answer;
	}
	
	// 내풀이 실패 
    int solution(int[][] land) {
        int answer = 0;     

		int[] MAXS = new int[land.length+1];
		
        for (int i = 0; i < land.length; i++) {
			int max = 0;
			
        	for (int j = 0; j < land[0].length; j++) {
        		if(MAXS[i] == j) {
        			continue;
        		}else {
        			if(max <= land[i][j]) {
    					max = land[i][j];
    					MAXS[i+1] = j;
    				}
        		}
			}

        	answer += max;
		}

        return answer;
    }
    
	public static void main(String[] args) {
		Ex30 sol = new Ex30();
		
//		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		int[][] land = {{9, 5, 2, 3}, 
						{9, 8, 6, 7}, 
						{8, 9, 7, 1}, 
						{100, 9, 8, 1}};//125 이 맞는데 나는 123이 나옴.. ㅠ 
		
		System.out.println(sol.solution1(land)); 

	}

}
