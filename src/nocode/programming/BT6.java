package nocode.programming;

// 79. Word Search 

/*
// matrix: 2���� ���� �迭
// word : ã�� �ܾ�
// matrix[x][y]�� ���� ��ġ�� �Ͽ� word�� �ִ���
find(matrix, x, y, word):
	// ��� üũ
    if(x, y �̹� �湮) return false
    if(matrix[x][y]�� word�� ù ��° ���ڰ� ���� �ʴٸ�) return false
    ans = false
	x, y �湮 üũ
    for(nx, ny = ��, ��, ��, �� �̵��� ��ǥ):
    	ans |= find(matrix, nx, ny, word[1..])
    return ans
    
main:
    for(i = 0..N):
        for(j = 0..M):
            ans |= find(board, i, j, word);
            
�ð����⵵�� O(�迭ũ�� ^ 2)�� �� ���� �������� ����.
 */

/**
 * algorithm : DFS
 * Runtime : 916ms
 * Memory : 432.3 MB
 */
// board: ���ڿ� �迭
//bool find(vector<vector<char>> board, int x,int y, int wordInd) {
//	if (wordInd >= word.size()) return true;
//	if (x < 0 || x >= board.size() || y < 0 || y >= board[0].size()) return false; 
//	if (board[x][y] != word[wordInd]) return false;
//
//	board[x][y] = ' '; // �湮 ǥ��
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
// board: ���ڿ� �迭 ����
//bool find(vector<vector<char>>& board, int x,int y, int wordInd) {
//	// ����
//
//	char tmp = board[x][y]; // ���� �湮�ϰ� �ִ� ĭ�� ���ڸ� �ӽ� ����
//	board[x][y] = ' '; // �湮 ���� ǥ��
//	bool ans = false;
//	for (int i = 0; i < 4; i++) {
//		int nx = x + dx[i];
//		int ny = y + dy[i];
//		ans |= find(board, nx, ny, wordInd+1);
//		if (ans) break;
//	}
//	board[x][y] = tmp; // �湮 ǥ�� ����. ���� ����
//	return ans;
//}


public class BT6 {
		

    // �ܾ �����ϴ��� ���θ� Ȯ���ϴ� �迭
	static private boolean[][] visited;
    // �ܾ �����ϴ��� ����
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
		
	   // ���ڰ� �����ϴ� ��ġ�� ã�� ����, �� ��ġ�� ��������� �־��� �ܾ �����ϴ��� Ȯ���ϴ� ����� ����մϴ�.
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

        // ������ ��ġ�� ������ ��� ���
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        // �̹� �湮�� ������ ���
        if (visited[i][j]) {
            return;
        }

        // ���� ���ڰ� ��ġ���� �ʴ� ���
        if (board[i][j] != word.charAt(idx)) {
            return;
        }

        // ������ ��ġ�� �湮������ ǥ��
        visited[i][j] = true;
        idx++;

        // �ܾ��� ������ ���ڱ��� ��ġ�ϴ� ���
        if (idx == word.length()) {
            exists = true;
            return;
        }

        // �����¿�� �̵��ϴ� ��츦 ��� �˻�
        dfs(board, word, i - 1, j, idx);
        dfs(board, word, i + 1, j, idx);
        dfs(board, word, i, j - 1, idx);
        dfs(board, word, i, j + 1, idx);

        // ������ ��ġ�� �湮���� �ʾ����� ǥ��
        visited[i][j] = false;
    }
}
