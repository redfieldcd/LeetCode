// public class Solution {
//     int max = 0;
//     public int maxSubArrayLen(int[] nums, int k) {
//         List<Integer> path = new LinkedList();
//         if(nums == null || nums.length == 0) return 0;
        
//         search(nums, k, 0, path);
//         return max;
//     }
    
//     public void search(int[] nums, int k, int pos, List<Integer> path) {
//         if(k == 0) {
//             System.out.println(path);
//             max = Math.max(max, path.size());
//             return;
//         }
        
//         // if(k < 0) return;
        
//         for(int i = pos; i < nums.length; i++) {
//             path.add(nums[i]);
//             search(nums, k - nums[i], i+1, path);
//             path.remove(path.size() - 1);
//         }
//     }
// }

// 暴力的O(n^2)
// public class Solution {
//     public int maxSubArrayLen(int[] nums, int k) {
//         int max = 0;
//         for(int i = 0; i < nums.length; i++) {
//             int sum = 0;
//             for(int j = i; j < nums.length; j++) {
//                 sum += nums[j];
//                 if(sum == k) {
//                     int len = j - i + 1;
//                     if(len > max) max = len;
//                 }
//             }
//         }
//         return max;
//     }
// }

// O(n) time, O(n) space
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int max = 0;
        if(nums == null || nums.length == 0) return 0;
        
        map.put(0, -1);
        
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i] - k)) {
                max = Math.max(max, i - map.get(nums[i] - k));
            }
            
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        
        return max;
    }
}




