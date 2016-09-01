public class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < nums[mid + 1]) low = mid;
            else high = mid;
        }
        
        return nums[high] > nums[low] ? high:low;
    }
}