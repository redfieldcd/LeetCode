public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> interval = new HashSet<Integer>();
        
        for(int i = 0; i < nums1.length; i++) {
            if(!set.contains(nums1[i])) {
                set.add(nums1[i]);
            }
        }
        
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains[nums2[i]]) {
                interval.add(nums[i]);
            }
        }
        
        int[] res = new int[interval.size()];
        int i = 0;
        for(Integer e : interval) {
            res[i++] = e;
        }
        
        return res;
    }
}