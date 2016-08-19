public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] res = new int[m+1][n+1];
        
        for(int i = 1; i <= n; i++) {
            res[0][i] = i;
        }
        
        for(int i = 1; i <= m; i++) {
            res[i][0] = i;
        }
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; i <= n; j++) {
                int insertion = res[i][j-1] + 1;
                int deletion = res[i-1][j] + 1;
                int replace = res[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1);
                res[i][j] = Math.min(Math.min(insertion, deletion), replace);
            }
        }
        
        return res[m][n];
    }
}