public class Solution {
    public int maxSubArray(int[] nums) {
       int len = nums.length;
       System.out.println(len);
       if (len < 0) {
           return Integer.MIN_VALUE;
       }
       int[] val = new int[len];
    
       val[0] = nums[0];
       
       long max = (long)val[0];
       for(int i = 1; i < len; i++) {
           val[i] = Math.max((val[i-1] + nums[i]), nums[i]);
           max = Math.max(max, val[i]);
       }
       
       return (int)max;
    }
}