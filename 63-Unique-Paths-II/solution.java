public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int a = obstacleGrid.length;
        int b = obstacleGrid[0].length;
        int[][] dp = new int[a][b];
        
        for(int i = 0; i < a; i++) {
            if(obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        
        for(int i = 0; i < b; i++) {
            if(obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        
        for(int i = 1; i < a; i++) {
            for(int j = 1; j < b; j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
                }
            }
        }
        
        return dp[a-1][b-1];
    }
}