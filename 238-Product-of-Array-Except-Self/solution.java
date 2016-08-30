// brute force
// public class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] res = new int[nums.length];
//         for(int i = 0; i < nums.length; i++) {
//             res[i] = 1;
//         }
//         for(int i = 0; i < nums.length; i++) {
//             for(int j = 0; j < nums.length; j++) {
//                 if(i != j) {
//                     res[i] *= nums[j];
//                 }
//             }
//         }
        
//         return res;
//     }
// }

//O(n)
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <= 1) return nums;
        
        int left = 1, right = 1;
        int[] res = new int[nums.length];
        res[0] = 1;
        
        //计算左边的
        for(int i = 1; i < nums.length; i++) {
            left = left * nums[i-1];
            res[i] = left;
        }
        
        //计算右边的
        for(int i = nums.length - 2; i >= 0; i--) {
            right = right * nums[i+1];
            res[i] *= right;
        }
        
        return res;
    }
}






