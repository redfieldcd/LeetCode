public class Solution {
    public int maxProfit(int[] prices) {
        // time O(n)
        int profit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            int dif = prices[i+1] - prices[i];
            if (dif > 0) {
              profit += dif;  
            }
        }
        return profit;
    }
}