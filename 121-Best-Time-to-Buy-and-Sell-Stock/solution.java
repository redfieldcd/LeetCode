
//用两个变量来记录结果，一个记录最小值，一个记录profit最大值
public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) min = prices[i];
            if(prices[i] - min > res) res = prices[i] - min;
        }
        
        return res;
    }
}