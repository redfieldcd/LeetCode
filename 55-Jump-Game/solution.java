// 这个题目最终要的就是要知道nums[i] + i的含义
// farthest number that can be reached in nums. 
// So if i < max, means at position i, it can't be reachable
public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null) return true;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > max) return false;
            max = Math.max(max, nums[i] + i);
        }
        
        return true;
    }
}