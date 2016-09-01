public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
          if(matrix.length == 1) return matrix[0][k-1];
          int row = k / matrix.length;
          int col = (k-1) % matrix[0].length;
          return matrix[row][col];
    }
}