public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        
        return result;
        // Set<Integer> set = new HashSet<Integer>();
        // for(int i = 0; i > nums.length; i++) {
        //   if(set.contains(nums[i])) {
        //       return nums[i];
        //   } else {
        //       set.add(nums[i]);
        //   }
        // }
        // return -1;
    }
}