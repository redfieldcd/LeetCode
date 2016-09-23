// O(nlog(n))
// public class Solution {
//     public int longestConsecutive(int[] nums) {
//         if(nums.length == 0 || nums.length == 1) return 1;
//         PriorityQueue<Integer> q = new PriorityQueue();
        
//         for(int i = 0; i < nums.length; i++) {
//             q.offer(nums[i]);
//         }
        
//         int max = 1;
//         int count = 1;
//         int pre = q.poll();
//         while(!q.isEmpty()) {
//             int cur = q.poll();
//             if(cur - pre == 1) {
//                 count++;
//                 max = Math.max(max, count);
//             } else if(cur == pre) {
//                 continue;
//             }else {
//                 count = 1;
//             }
//             pre = cur;
//         }
        
//         return max;
//     }
// }

// test cast [1,3,4,2,100]
public class Solution {
    public int longestConsecutive(int[] nums) {
        int maxlen = 0;
        Set<Integer> set = new HashSet<Integer>();
        // 先将所有数字加入数组中
        for(int n : nums){
            set.add(n);
        }
        // 对于每个数我们都在集合中一一检查它的上下边界
        for(int n : nums){
            // 暂存n，供检查下边界时使用
            int curr = n, len = 0;
            // 一个一个检查上边界
            while(set.contains(curr)){
                curr++;
                len++;
                set.remove(curr-1);
            }
            // 一个一个检查下边界
            curr = n - 1;
            while(set.contains(curr)){
                curr--;
                len++;
                set.remove(curr + 1);
            }
            maxlen = Math.max(len, maxlen);
        }
        return maxlen;
    }
}