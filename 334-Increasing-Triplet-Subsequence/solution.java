public class Solution {
    public boolean increasingTriplet(int[] nums) {
         int small = Integer.MAX_VALUE;
         int large = Integer.MAX_VALUE;
         
         for(int n : nums) {
             if(n <= small) small = n;
             else if(n <= large) large = n;
             else return true;
         }
         
         return false;
    }
}