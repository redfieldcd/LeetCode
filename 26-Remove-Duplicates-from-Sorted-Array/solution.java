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
            
            nums[end++] = cur;
        }
        
        return end;
    }
}