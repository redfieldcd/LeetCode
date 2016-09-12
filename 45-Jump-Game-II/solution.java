//greedy algorithm 用low and high来分块搜索
public class Solution {
    public int jump(int[] nums) {
        int preHigh = 0, high = 0, low = 0, step = 0;
        while(high < nums.length - 1) {
            step++;
            preHigh = high;
            for(int i = low; i <= preHigh; i++) {
                high = Math.max(high, i + nums[i]);
            }
            low = preHigh + 1;
        }
        
        return step;
    }
}