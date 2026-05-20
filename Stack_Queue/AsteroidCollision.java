import java.util.*;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {

                int top = stack.peek();

                if (Math.abs(top) < Math.abs(ast)) {
                    stack.pop(); // top explodes
                    continue;
                } else if (Math.abs(top) == Math.abs(ast)) {
                    stack.pop(); // both explode
                }

                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.push(ast);
            }
        }

        // Convert stack to array
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
    }
}