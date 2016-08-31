public class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            
            if(nums[mid] > nums[low]) {
                if(target < nums[mid] && target >= nums[low]) {
                    high = mid;
                } else {
                    low = mid;
                }
            } else {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
        }
        
        if(nums[low] == target) return low;
        if(nums[high] == target) return high;
        return -1;
    }
}