//分成两种情况考虑，然后取最大值
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        int[] res1 = new int[n+1];
        int[] res2 = new int[n+1];
        //抢第一间
        res1[1] = nums[0];
        res1[2] = nums[0];
        
        //不抢第一间
        res2[1] = 0;
        res2[2] = nums[1];
        
        for(int i = 3; i <= n - 1; i++) {
            res1[i] = Math.max(res1[i-1], nums[i-1] + res1[i-2]);
            res2[i] = Math.max(res2[i-1], nums[i-1] + res2[i-2]);
        }
        //抢过第一间就肯定不能抢最后一间
        res1[n] = res1[n-1];
        
        //不抢第一间的话，最后一间是随便的
        res2[n] = Math.max(res2[n-1], nums[n-1] + res2[n-2]);
        
        return Math.max(res1[n], res2[n]);
        
    }
}