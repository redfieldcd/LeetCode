public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        int count = 0;
        if(nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        
        for(int i = 0; i <= len - 3; i++) {
            int left = i + 1;
            int right = len - 1;
            
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < target) {
                    //最重要的是这一步+这个问题重复也算进去
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}