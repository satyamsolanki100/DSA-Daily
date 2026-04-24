public class Search2DMatrixIIOptimal {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1; // start from top-right corner

        while (row < m && col >= 0) {
            int val = matrix[row][col];

            if (val == target) {
                return true;
            } 
            else if (val > target) {
                col--; // move left
            } 
            else {
                row++; // move down
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrixIIOptimal obj = new Search2DMatrixIIOptimal();

        int[][] matrix = {
            {1,4,7,11,15},
            {2,5,8,12,19},
            {3,6,9,16,22},
            {10,13,14,17,24},
            {18,21,23,26,30}
        };

        System.out.println(obj.searchMatrix(matrix, 5));   // true
        System.out.println(obj.searchMatrix(matrix, 20));  // false
    }
}