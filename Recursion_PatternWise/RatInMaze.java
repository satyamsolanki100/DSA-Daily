import java.util.*;

public class RatInMaze {

    public List<String> findPath(int[][] grid, int n) {

        List<String> result = new ArrayList<>();

        if (grid[0][0] == 0) return result;

        boolean[][] visited = new boolean[n][n];

        solve(0, 0, grid, n, "", result, visited);

        return result;
    }

    private void solve(int i, int j, int[][] grid, int n,
                       String path, List<String> result,
                       boolean[][] visited) {

        // Destination reached
        if (i == n - 1 && j == n - 1) {
            result.add(path);
            return;
        }

        // Mark visited
        visited[i][j] = true;

        // Down
        if (i + 1 < n && grid[i + 1][j] == 1 && !visited[i + 1][j]) {
            solve(i + 1, j, grid, n, path + "D", result, visited);
        }

        // Left
        if (j - 1 >= 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {
            solve(i, j - 1, grid, n, path + "L", result, visited);
        }

        // Right
        if (j + 1 < n && grid[i][j + 1] == 1 && !visited[i][j + 1]) {
            solve(i, j + 1, grid, n, path + "R", result, visited);
        }

        // Up
        if (i - 1 >= 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {
            solve(i - 1, j, grid, n, path + "U", result, visited);
        }

        // Backtrack
        visited[i][j] = false;
    }

    public static void main(String[] args) {

        RatInMaze obj = new RatInMaze();

        int[][] grid = {
            {1,0,0,0},
            {1,1,0,1},
            {1,1,0,0},
            {0,1,1,1}
        };

        System.out.println(obj.findPath(grid, 4));
        // ["DDRDRR", "DRDDRR"]
    }
}