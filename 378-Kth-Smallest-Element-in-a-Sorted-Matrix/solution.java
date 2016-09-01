public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
          PriorityQueue<Integer> q = new PriorityQueue(k, Collections.reverseOrder());
          
          for(int i = 0; i < matrix.length; i++) {
              for(int j = 0; j < matrix[0].length; j++) {
                  if(q.size() < k) {
                    q.offer(matrix[i][j]);
                  } else {
                    int temp = q.peek();
                    if(matrix[i][j] < temp) {
                        q.poll();
                        q.offer(matrix[i][j]);
                    }
                  }
              }
          }
          
          return q.poll();
    }
}