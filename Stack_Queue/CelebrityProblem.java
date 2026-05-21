// File: CelebrityProblem.java

public class CelebrityProblem {

    public static int findCelebrity(int[][] M, int n) {

        int candidate = 0;

        // Step 1: Find potential candidate
        for (int i = 1; i < n; i++) {
            if (M[candidate][i] == 1) {
                candidate = i;
            }
        }

        // Step 2: Verify candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (M[candidate][i] == 1 || M[i][candidate] == 0) {
                    return -1;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        int[][] M1 = {
            {0,1,1,0},
            {0,0,0,0},
            {1,1,0,0},
            {0,1,1,0}
        };

        System.out.println(findCelebrity(M1, 4)); // 1

        int[][] M2 = {
            {0,1},
            {1,0}
        };

        System.out.println(findCelebrity(M2, 2)); // -1
    }
}