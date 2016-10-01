public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int i = nums.length - 2;
        // 找到第一个下降点，我们要把这个下降点的值增加一点点
        // 对于511这种情况，要把前面两个1都跳过，所以要包含等于
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        // 如果这个下降点还在数组内，我们找到一个比它稍微大一点的数替换
        // 如果在之外，说明整个数组是降序的，是全局最大了
        if(i >= 0){
            int j = nums.length - 1;
            // 对于151，这种情况，要把最后面那个1跳过，所以要包含等于
            while(j > i && nums[j] <= nums[i]){
                j--;
            }
            swap(nums, i, j);
        }
        // 将下降点之前的部分倒序构成一个最小序列
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