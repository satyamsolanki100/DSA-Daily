public class MatrixMedian {

    // Function to find median in row-wise sorted matrix
    public int findMedian(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find min and max in matrix
        for (int i = 0; i < m; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n - 1]);
        }

        int desired = (m * n) / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int count = 0;

            // Count elements <= mid
            for (int i = 0; i < m; i++) {
                count += upperBound(matrix[i], mid);
            }

            if (count <= desired) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    // Upper bound: first index where element > target
    private int upperBound(int[] row, int target) {
        int low = 0, high = row.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        MatrixMedian obj = new MatrixMedian();

        int[][] matrix1 = {
            {1, 4, 9},
            {2, 5, 6},
            {3, 7, 8}
        };
        System.out.println(obj.findMedian(matrix1)); // 5

        int[][] matrix2 = {
            {1, 3, 8},
            {2, 3, 4},
            {1, 2, 5}
        };
        System.out.println(obj.findMedian(matrix2)); // 3
    }
}