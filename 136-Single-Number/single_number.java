public class Solution {
    // xor
    // public int singleNumber(int[] nums) {
    //     int result = 0;
    //     for(int i = 0; i < nums.length; i++) {
    //         result ^= nums[i];
    //     }
    //     return result;
    // }
    
    // hashset
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
          if(!set.add(nums[i])) {
              set.remove(nums[i]);
          } 
        }
        return set.iterator().next();
    }
}