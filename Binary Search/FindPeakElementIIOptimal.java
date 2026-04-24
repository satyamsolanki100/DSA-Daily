public class FindPeakElementIIOptimal {

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0, high = n - 1;

        while (low <= high) {
            int midCol = low + (high - low) / 2;

            // Find row index of max element in this column
            int maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            int left = (midCol > 0) ? mat[maxRow][midCol - 1] : -1;
            int right = (midCol < n - 1) ? mat[maxRow][midCol + 1] : -1;

            // Check if it's a peak
            if (mat[maxRow][midCol] > left && mat[maxRow][midCol] > right) {
                return new int[]{maxRow, midCol};
            }
            // Move to left half
            else if (left > mat[maxRow][midCol]) {
                high = midCol - 1;
            }
            // Move to right half
            else {
                low = midCol + 1;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        FindPeakElementIIOptimal obj = new FindPeakElementIIOptimal();

        int[][] mat1 = {
            {1, 4},
            {3, 2}
        };
        int[] res1 = obj.findPeakGrid(mat1);
        System.out.println(res1[0] + " " + res1[1]);

        int[][] mat2 = {
            {10,20,15},
            {21,30,14},
            {7,16,32}
        };
        int[] res2 = obj.findPeakGrid(mat2);
        System.out.println(res2[0] + " " + res2[1]);
    }
}