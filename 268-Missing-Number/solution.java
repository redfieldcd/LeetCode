//先求出总和，再逐个减
public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (1 + n) * n / 2;
        
        for(int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        
        return sum;
    }
}