public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int max = nums[0];
        int min = nums[0];
        int reuslt = nums[0];
        for(int i = 1; i < n; i++) {
            int temp = max;
            max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            min = Math.min(Math.min(temp*nums[i], min*nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        
        return max;
    }
}