public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[]{-1,-1};
        //search for left
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if(nums[left] == target){
            res[0] = left;
        } else if(nums[right] == target) {
            res[0] = right;
        }
        
        left = 0;
        right = nums.length - 1;
        
        while(left  + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if(nums[right] == target) {
            res[1] = right;
        } else if (nums[left] == target) {
            res[1] = left;
        }
        
        return res;
    }
}