public class RowWithMaxOnes {

    public int rowWithMax1s(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int maxRowIndex = -1;
        int j = n - 1; // start from top-right

        for (int i = 0; i < m; i++) {
            while (j >= 0 && mat[i][j] == 1) {
                j--;              // move left
                maxRowIndex = i; // update row index
            }
        }

        return maxRowIndex;
    }

    public static void main(String[] args) {
        RowWithMaxOnes obj = new RowWithMaxOnes();

        int[][] mat1 = {
            {1, 1, 1},
            {0, 0, 1},
            {0, 0, 0}
        };
        System.out.println(obj.rowWithMax1s(mat1)); // 0

        int[][] mat2 = {
            {0, 0},
            {0, 0}
        };
        System.out.println(obj.rowWithMax1s(mat2)); // -1
    }
}