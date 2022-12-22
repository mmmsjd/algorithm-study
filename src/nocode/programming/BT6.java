package nocode.programming;

// 79. Word Search 

/*
// matrix: 2차원 문자 배열
// word : 찾는 단어
// matrix[x][y]를 시작 위치로 하여 word가 있는지
find(matrix, x, y, word):
	// 경계 체크
    if(x, y 이미 방문) return false
    if(matrix[x][y]와 word의 첫 번째 문자가 같지 않다면) return false
    ans = false
	x, y 방문 체크
    for(nx, ny = 상, 하, 좌, 우 이동한 좌표):
    	ans |= find(matrix, nx, ny, word[1..])
    return ans
    
main:
    for(i = 0..N):
        for(j = 0..M):
            ans |= find(board, i, j, word);
            
시간복잡도는 O(배열크기 ^ 2)인 것 같은 느낌적인 느낌.
 */

/**
 * algorithm : DFS
 * Runtime : 916ms
 * Memory : 432.3 MB
 */
// board: 문자열 배열
//bool find(vector<vector<char>> board, int x,int y, int wordInd) {
//	if (wordInd >= word.size()) return true;
//	if (x < 0 || x >= board.size() || y < 0 || y >= board[0].size()) return false; 
//	if (board[x][y] != word[wordInd]) return false;
//
//	board[x][y] = ' '; // 방문 표시
//	bool ans = false;
//	for (int i = 0; i < 4; i++) {
//		int nx = x + dx[i];
//		int ny = y + dy[i];
//		ans |= find(board, nx, ny, wordInd+1);
//		if (ans) break;
//	}
//	return ans;
//}

/**
 * algorithm : DFS, Backtracking
 * Runtime : 20ms
 * Memory : 9.1 MB
 */
// board: 문자열 배열 참조
//bool find(vector<vector<char>>& board, int x,int y, int wordInd) {
//	// 생략
//
//	char tmp = board[x][y]; // 현재 방문하고 있는 칸의 문자를 임시 저장
//	board[x][y] = ' '; // 방문 여부 표시
//	bool ans = false;
//	for (int i = 0; i < 4; i++) {
//		int nx = x + dx[i];
//		int ny = y + dy[i];
//		ans |= find(board, nx, ny, wordInd+1);
//		if (ans) break;
//	}
//	board[x][y] = tmp; // 방문 표시 제거. 문자 복원
//	return ans;
//}


public class BT6 {
		

    // 단어가 존재하는지 여부를 확인하는 배열
	static private boolean[][] visited;
    // 단어가 존재하는지 여부
    static private boolean exists = false;
    
	public static void main(String[] args) {
				
		char[][] matrix = 
			{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//			{
//			{'A','B','D'},
//			{'B','D','C'},
//			{'S','A','B'}
//			};
		String word = "ABCB";//false
//		String word = "SBDCB";//true
		System.out.println(wordSearch(matrix, word));
		
	}

	private static boolean wordSearch(char[][] board, String word) {
		
	   // 글자가 존재하는 위치를 찾은 다음, 그 위치를 출발점으로 주어진 단어가 존재하는지 확인하는 방법을 사용합니다.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[board.length][board[0].length];
                    dfs(board, word, i, j, 0);
                }
            }
        }

        return exists;
		
	}
	
	private static void dfs(char[][] board, String word, int i, int j, int idx) {

        // 글자의 위치가 범위를 벗어난 경우
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        // 이미 방문한 글자인 경우
        if (visited[i][j]) {
            return;
        }

        // 현재 글자가 일치하지 않는 경우
        if (board[i][j] != word.charAt(idx)) {
            return;
        }

        // 글자의 위치를 방문했음을 표시
        visited[i][j] = true;
        idx++;

        // 단어의 마지막 글자까지 일치하는 경우
        if (idx == word.length()) {
            exists = true;
            return;
        }

        // 상하좌우로 이동하는 경우를 모두 검사
        dfs(board, word, i - 1, j, idx);
        dfs(board, word, i + 1, j, idx);
        dfs(board, word, i, j - 1, idx);
        dfs(board, word, i, j + 1, idx);

        // 글자의 위치를 방문하지 않았음을 표시
        visited[i][j] = false;
    }
}
