public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int preF = 0, preS = 0, preIdx = -1;
        
        for(int i = 0; i < costs.length; i++) {
            int curF = Integer.MAX_VALUE, curS = Integer.MAX_VALUE, curIdx = -1;
            for(int j = 0; j < costs[0].length; j++) {
               costs[i][j] = costs[i][j] + (j == preIdx ? preS : preF);
               
               if(costs[i][j] < curF) {
                 curS = curF;
                 curF = costs[i][j];
                 curIdx = j;
               } else if(costs[i][j] < curS) {
                   curS = costs[i][j];
               }
            }
            
            preF = curF;
            preS = curS;
            preIdx = curIdx;
        }
        
        return preF;
    }
}