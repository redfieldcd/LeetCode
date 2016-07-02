public class Solution {
    public int maxSubArray(int[] nums) {
       int len = nums.length;
       if (len < 0) {
           return 0;
       }
       int[] val = new int[len];
    
       val[0] = nums[0];
       
       int max = Long.MIN_VALUE;
       for(int i = 1; i < len; i++) {
           val[i] = Math.max((val[i-1] + nums[i]), nums[i]);
           max = Math.max(max, val[i]);
       }
       
       return max;
    }
}