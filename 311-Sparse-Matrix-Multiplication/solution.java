//暴力搜索法，时间过不了，O(n^3)
//稍微修改一下，判断某个元素是否为0然后再进行内层循环 时间复杂度减少到0(N^2)
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A.length == 0 || B.length == 0) return null;
        //A，B same
        int len1 = A[0].length;
        int len2 = A.length;
        int len3 = B[0].length;
        
        int[][] res = new int[len2][len3];
        
        for(int i = 0; i < len2; i++) {
            for(int k = 0; k < len1; k++) {
                if(A[i][k] != 0) {
                    for(int j = 0; j < len3; j++) {
                        res[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        
        return res;
    }
}