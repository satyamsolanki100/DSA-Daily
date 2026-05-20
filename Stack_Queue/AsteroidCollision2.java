// File: AsteroidCollision.java

import java.util.*;

public class AsteroidCollision2 {

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int curr : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty() && curr < 0 && stack.peek() > 0) {

                int top = stack.peek();

                if (Math.abs(top) < Math.abs(curr)) {
                    stack.pop(); // top explodes
                    continue;
                } 
                else if (Math.abs(top) == Math.abs(curr)) {
                    stack.pop(); // both explode
                }

                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.push(curr);
            }
        }

        // Convert stack to result array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr1 = {5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(arr1))); // [5,10]

        int[] arr2 = {8,-8};
        System.out.println(Arrays.toString(asteroidCollision(arr2))); // []

        int[] arr3 = {10,2,-5};
        System.out.println(Arrays.toString(asteroidCollision(arr3))); // [10]

        int[] arr4 = {3,5,-6,2,-1,4};
        System.out.println(Arrays.toString(asteroidCollision(arr4))); // [-6,2,4]
    }
}