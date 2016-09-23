public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return 1;
        PriorityQueue<Integer> q = new PriorityQueue();
        
        for(int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
        }
        
        int max = 1;
        int count = 1;
        int pre = q.poll();
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur - pre == 1) {
                count++;
                max = Math.max(max, count);
            } else if(cur == pre) {
                continue;
            }else {
                count = 1;
            }
            pre = cur;
        }
        
        return max;
    }
}