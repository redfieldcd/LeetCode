// 从下往上的递归，最后结果就在顶点，适合画图理清楚逻辑的题目
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size()-2; i>=0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j, triangle.get(i).get(j)+ min);
            }
        }
        
        return triangle.get(0).get(0);
    }
}