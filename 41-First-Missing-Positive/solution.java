public class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] != i + 1) {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(i+1 != nums[i]) {
                return i + 1;
            }
        }
        return nums.length+1;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}