// package Arrays;

public class BestTimeToBuySellStock {

    // Problem: Best Time to Buy and Sell Stock (1 transaction)
    // Platform: LeetCode
    // Approach: Track minimum price and max profit
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = maxProfit(prices);

        System.out.println(result);
    }
}