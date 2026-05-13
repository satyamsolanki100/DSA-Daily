import java.util.*;

public class MColoringProblem {

    public boolean graphColoring(int n, int[][] edges, int m) {

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] color = new int[n]; // 0 means no color assigned

        return solve(0, graph, color, m, n);
    }

    private boolean solve(int node, List<List<Integer>> graph,
                          int[] color, int m, int n) {

        // All nodes colored
        if (node == n) return true;

        for (int c = 1; c <= m; c++) {

            if (isSafe(node, graph, color, c)) {

                color[node] = c;

                if (solve(node + 1, graph, color, m, n))
                    return true;

                // Backtrack
                color[node] = 0;
            }
        }

        return false;
    }

    private boolean isSafe(int node, List<List<Integer>> graph,
                           int[] color, int c) {

        for (int neighbor : graph.get(node)) {
            if (color[neighbor] == c)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        MColoringProblem obj = new MColoringProblem();

        int n = 4;
        int m = 3;

        int[][] edges = {
            {0,1},{1,2},{2,3},{3,0},{0,2}
        };

        System.out.println(obj.graphColoring(n, edges, m)); // true
    }
}
