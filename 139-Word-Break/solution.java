public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        Arrays.fill(dp, false);
        
        dp[s.length()] = true;
        
        for(int i = s.length()-1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
                String sub = s.substring(i,j+1);
                if(wordDict.contains(sub) && dp[j+1] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}