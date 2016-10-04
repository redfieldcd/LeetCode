public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int end = 0;
        
        while(i < nums.length) {
            int cur = nums[i];
            int count = 0;
            while(i < nums.length && nums[i] == cur) {
                count++;
                i++;
            }
            
            // Follow up if only print out unduplicated elements
            if(count == 1) {
              nums[end++] = cur; 
            } else {
              nums[end++] = cur;
              nums[end++] = cur;
            }
        }
        return end;
    }
}