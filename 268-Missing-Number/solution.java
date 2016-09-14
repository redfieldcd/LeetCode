public class Solution {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(i != nums[i]) {
                swap(nums, i, nums[i]);
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}