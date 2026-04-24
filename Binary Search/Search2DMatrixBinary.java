public class Search2DMatrixBinary {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / n;
            int col = mid % n;

            int val = matrix[row][col];

            if (val == target) {
                return true;
            } else if (val < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrixBinary obj = new Search2DMatrixBinary();

        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        System.out.println(obj.searchMatrix(matrix, 3));   // true
        System.out.println(obj.searchMatrix(matrix, 13));  // false
    }
}