public class WordSearch {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {

        // Base case: all chars matched
        if (index == word.length()) return true;

        // Boundary + mismatch check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore 4 directions
        boolean found =
                dfs(board, word, i + 1, j, index + 1) || // down
                dfs(board, word, i - 1, j, index + 1) || // up
                dfs(board, word, i, j + 1, index + 1) || // right
                dfs(board, word, i, j - 1, index + 1);   // left

        // Backtrack (restore)
        board[i][j] = temp;

        return found;
    }

    public static void main(String[] args) {

        WordSearch obj = new WordSearch();

        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        System.out.println(obj.exist(board, "ABCCED")); // true
    }
}