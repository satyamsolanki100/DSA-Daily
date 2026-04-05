
// package Arrays;

public class SecondLargestElement {

    // Problem: Find the second largest element in an array
    // Platform: TUF
    // Approach: Keep track of largest and second largest in one pass
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static int findSecondLargest(int[] nums) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {

            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } 
            else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    public static void main(String[] args) {

        int[] nums = {8, 8, 7, 6, 5};

        int result = findSecondLargest(nums);

        System.out.println(result);
    }
}