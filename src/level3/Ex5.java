package level3;

import java.util.Arrays;

// 단속카메라 (greedy)
/*
 * 2차원배열 종료구간에 그리디하게 배치 
 * 2차원배열 정렬이 핵심
 */
public class Ex5 {

    public int solution(int[][] routes) {
        int answer = 0;
        
        // 2차원배열의 정렬
//        Arrays.sort(routes, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[1] - o2[1]; // 도착지점 오름차순 정렬
//			}
//		});
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        // [[-20, -15], [-18, -13], [-14, -5], [-5, -3]]
        int point = Integer.MIN_VALUE;
        
        for (int[] is : routes) {
			if(point < is[0]) { // 구간 시작보다 작다면 설치 
				point = is[1];
				answer++;				
			}
		}
        //|-20|   |   |   |   |-15|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   	설치(-15)
        //|   |   |-18|   |   |   |   |-13|   |   |   |   |   |   |   |   |   |   |   |   |		패스
        //|   |   |   |   |   |   |   |   |-14|   |   |   |   |   |   |   |   | -5|   |   |		설치(-5)
        //|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   | -5|   | -3|		패스
        
        return answer;
    }
    
	public static void main(String[] args) {
		Ex5 sol = new Ex5();
		
//		 int[][] routes = { {-20, 15}, {-14, -5}, {-18, -13}, {-5, -3} }; //2
		 int[][] routes = { {-2, -1}, {1, 2}, {-3, 0} };//2
		// int[][] routes = { {0, 0}, };//1
		// int[][] routes = { {0, 1}, {0, 1}, {1, 2} };//1
		// int[][] routes = { {0, 1}, {2, 3}, {4, 5}, {6, 7} };//4
		// int[][] routes = { {-20, -15}, {-14, -5}, {-18, -13}, {-5, -3} };//2
		// int[][] routes = { {-20, 15}, {-20, -15}, {-14, -5}, {-18, -13}, {-5, -3} };//2
		// int[][] routes = { {2,2},{0,1},{-10,9} };//2
		// int[][] routes = { {-7, 0}, {-6, -4}, {-5, -3}, {-3, -1}, {-1, 4}, {1, 2}, {3, 4} };//4
		// int[][] routes = { {-5, -3}, {-4, 0}, {-4, -2}, {-1, 2}, {0, 3}, {1, 5}, {2, 4} };//2
		// int[][] routes = { {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15} };//8
		// int[][] routes = { {0, 12}, {1, 12}, {2, 12}, {3, 12}, {5, 6}, {6, 12}, {10, 12} };//2
		// int[][] routes = { {-191, -107}, { -184,-151 }, { -150,-102 }, { -171,-124 }, { -120,-114 } }; // 2
		
		System.out.println(sol.solution(routes)); 

	}

}
