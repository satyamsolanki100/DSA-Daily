public class FindPeakElementII {

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0, high = n - 1;

        while (low <= high) {
            int midCol = (low + high) / 2;

            // find max element row in mid column
            int maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            int left = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
            int right = (midCol + 1 < n) ? mat[maxRow][midCol + 1] : -1;

            // check peak
            if (mat[maxRow][midCol] > left && mat[maxRow][midCol] > right) {
                return new int[]{maxRow, midCol};
            } 
            else if (left > mat[maxRow][midCol]) {
                high = midCol - 1; // move left
            } 
            else {
                low = midCol + 1; // move right
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        FindPeakElementII obj = new FindPeakElementII();

        int[][] mat1 = {
            {1, 4},
            {3, 2}
        };
        int[] res1 = obj.findPeakGrid(mat1);
        System.out.println(res1[0] + " " + res1[1]); // [0,1] or [1,0]

        int[][] mat2 = {
            {10,20,15},
            {21,30,14},
            {7,16,32}
        };
        int[] res2 = obj.findPeakGrid(mat2);
        System.out.println(res2[0] + " " + res2[1]); // [1,1] or [2,2]
    }
}