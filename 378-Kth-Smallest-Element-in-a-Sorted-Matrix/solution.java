public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
          int row = k / matrix.length;
          int col = (k-1) % matrix[0].length;
          return matrix[row][col];
    }
}