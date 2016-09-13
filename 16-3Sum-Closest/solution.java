public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return -1;
        Arrays.sort(nums);
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int close_sum = -1;
        
        for(int i = 0; i <= len - 3; i++) {
            int left = i + 1;
            int right = len - 1;
            
            if(i != 0 && nums[i-1] == nums[i]) continue;
            
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < min) {
                    min = Math.abs(target - sum);
                    close_sum = sum;
                }
                if(sum == target) return target;
                else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return close_sum;
    }
}