public class Solution {
    int res = 0;
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i <= target; i++) {
            for(int num : nums) {
                if(i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];
    }
}


//targer 如果比较大的话会超时间
// public class Solution {
//     int res = 0;
//     public int combinationSum4(int[] nums, int target) {
//         helper(nums, target);
//         return res;
//     }
    
//     public void helper(int[] nums, int target) {
//         if(target < 0) return;
//         if(target == 0) res++;
//         for(int i = 0; i < nums.length; i++) {
//             helper(nums, target - nums[i]);
//         }
//     }
// }