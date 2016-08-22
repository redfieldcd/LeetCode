public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int dup = nums[0];
        int end = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != dup) {
                nums[end] = nums[i];
                end++;
                dup = nums[i];
            }
        }
        
        return end;
    }
}