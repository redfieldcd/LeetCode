public class Solution {
    public int findMin(int[] nums) {
       int low = 0, high = nums.length - 1;
       if(nums[low] < nums[high]) return nums[low];
       
       while(low + 1 < high) {
           int mid = low + (high - low) / 2;
           if(nums[mid] > nums[low]) {
               low = mid;
           } else {
               high = mid;
           }
       }
       
       return Math.min(nums[low], nums[high]);
    }
}