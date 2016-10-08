public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int i = nums.length - 2;
        for(; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                for(int j = nums.length - 1; j > i; j--) {
                    if(nums[j] > nums[i]) {
                        swap(nums, i, j);
                        break;
                    }
                }
                break;
            }
        }
        reverse(nums, i + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    
    private void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}