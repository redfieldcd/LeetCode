public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolean isExisted = search(board, word, i, j, 0);
                if(isExisted) return true;
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, String word, int i, int j, int index) {
        if(index >= word.length()) return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) return false;
        
        board[i][j] ^= 255;
        boolean res = search(board, word, i-1, j, index+1) || search(board, word, i, j-1, index+1) || search(board, word, i+1, j, index+1) || search(board, word, i, j+1, index+1);
        board[i][j] ^= 255;
        return res;
    }
}