// public class Solution {
//     public boolean exist(char[][] board, String word) {
//         if(board.length == 0) return false;
//         for(int i = 0; i < board.length; i++){
//             for(int j = 0; j < board[0].length; j++){
//                 // 从i,j点作为起点开始搜索
//                 boolean isExisted = search(board, i, j, word, 0);
//                 if(isExisted) return true;
//             }
//         }
//         return false;
//     }
    
//     private boolean search(char[][] board, int i, int j, String word, int idx){
//         if(idx >= word.length()) return true;
//         if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) return false;
//         // 将已经搜索过的字母标记一下，防止循环。只要变成另外一个字符，就不会再有循环了。
//         board[i][j] ^= 255;
//         boolean res = search(board, i-1, j, word, idx+1) || search(board, i+1, j, word, idx+1) || search(board, i, j-1, word, idx+1) || search(board, i, j+1, word, idx+1);
//         // 再次异或255就能恢复成原来的字母
//         board[i][j] ^= 255;
//         return res;
//     }
// }


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