import java.util.*;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (char[] row : board)
            Arrays.fill(row, '.');

        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2 * n];       // row + col
        boolean[] antiDiag = new boolean[2 * n];   // row - col + n

        backtrack(0, n, board, result, col, diag, antiDiag);

        return result;
    }

    private void backtrack(int row, int n, char[][] board,
                           List<List<String>> result,
                           boolean[] col,
                           boolean[] diag,
                           boolean[] antiDiag) {

        // ✅ Found solution
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int c = 0; c < n; c++) {

            if (col[c] || diag[row + c] || antiDiag[row - c + n])
                continue;

            // Place queen
            board[row][c] = 'Q';
            col[c] = diag[row + c] = antiDiag[row - c + n] = true;

            // Recurse
            backtrack(row + 1, n, board, result, col, diag, antiDiag);

            // Backtrack
            board[row][c] = '.';
            col[c] = diag[row + c] = antiDiag[row - c + n] = false;
        }
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }

    public static void main(String[] args) {
        NQueens obj = new NQueens();
        System.out.println(obj.solveNQueens(4));
    }
}