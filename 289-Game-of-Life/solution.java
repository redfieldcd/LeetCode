public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int lives = search(board, i, j, n, m);
                if(board[i][j] == 1 && lives >= 2 && lives <= 3) {  
                    board[i][j] = 3; 
                }
                
                if(board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; 
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
        
    }
    
    
    public int search(int[][] board, int x, int y, int n, int m) {
        int lives = 0;
        for(int i = Math.max(0, x - 1) ; i <= Math.min(x + 1, n - 1); i++) {
            for(int j = Math.max(0, y - 1); j <= Math.min(y + 1, m - 1); j++) {
                lives += board[i][j] & 1;
            }
        }
        
        lives -= board[x][y]&1;
        return lives;
    }
    
    
    

}