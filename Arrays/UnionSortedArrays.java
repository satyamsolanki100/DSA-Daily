// package Arrays;

import java.util.ArrayList;

public class UnionSortedArrays {

    // Problem: Union of two sorted arrays
    // Platform: TUF
    // Approach: Two pointers + avoid duplicates
    // Time Complexity: O(n + m)
    // Space Complexity: O(n + m)

    public static ArrayList<Integer> union(int[] nums1, int[] nums2) {

        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] <= nums2[j]) {

                if (result.size() == 0 || result.get(result.size() - 1) != nums1[i]) {
                    result.add(nums1[i]);
                }
                i++;

            } else {

                if (result.size() == 0 || result.get(result.size() - 1) != nums2[j]) {
                    result.add(nums2[j]);
                }
                j++;
            }
        }

        // remaining elements of nums1
        while (i < nums1.length) {
            if (result.size() == 0 || result.get(result.size() - 1) != nums1[i]) {
                result.add(nums1[i]);
            }
            i++;
        }

        // remaining elements of nums2
        while (j < nums2.length) {
            if (result.size() == 0 || result.get(result.size() - 1) != nums2[j]) {
                result.add(nums2[j]);
            }
            j++;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 4, 6, 7, 9, 9};
        int[] nums2 = {1, 5, 7, 8, 8};

        ArrayList<Integer> result = union(nums1, nums2);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}