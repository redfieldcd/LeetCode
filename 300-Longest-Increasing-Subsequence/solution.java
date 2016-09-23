// O(n^2)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            int locMax = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && dp[j] > locMax) {
                    locMax = dp[j];
                }
            }
            
            dp[i] = locMax + 1;
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}