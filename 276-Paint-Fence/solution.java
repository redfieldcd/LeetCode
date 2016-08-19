public class Solution {
    public int numWays(int n, int k) {
        int[] res = new int[n];
        
        res[0] = k;
        //这个地方比较容易出错
        res[1] = k*k;
        
        for(int i = 2; i < n; i++) {
            res[i] = res[i-2]*(k-1) + res[i-1]*(k-1);
        }
        
        return res[n-1];
    }
}