//强盗每次都有两种选择，抢上上家+当前这家，或者是抢上家
public class Solution {
    public int rob(int[] nums) {
        //corner case
        if(nums == null || nums.length == 0) return 0; 
        if(nums.length == 1) return nums[0];
        
        //记录数组
        int[] res = new int[nums.length];
        
        //base case
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        
        //递进公式
        for(int i = 2; i < nums.length; i++) {
            res[i] = Math.max((res[i-2] + nums[i]),res[i-1]);
        }
        return res[nums.length-1];
        
    }
}