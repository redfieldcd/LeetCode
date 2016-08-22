public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (s == null || len == 0 || s.charAt(0) == '0') return 0;
        
        int[] dp = new int[len+1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) == 0 ? 0:1;
        
        for(int i = 2; i <= len; i++) {
            int num = Integer.parseInt(s.substring(i-2, i));
            if(num >= 10 && num <= 26) dp[i] += dp[i-2];
            if(s.charAt(i-1) != '0') dp[i] += dp[i-1];
        }
        
        return dp[len];
    }
}