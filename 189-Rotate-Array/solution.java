public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        System.arraycopy(nums, k + 1, res, 0, n - k - 1);
        System.arraycopy(nums, 0, res, n - k - 1, k + 1);
        System.arraycopy(res, 0, nums, 0, n);
     }
}