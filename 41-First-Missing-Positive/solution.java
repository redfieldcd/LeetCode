//under bounding condition, kept swap until find suitable position
public class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            //nums[i] != nums[nums[i] - 1] duplicate 
            while(nums[i] > 0 && nums[i] - 1 < nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
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