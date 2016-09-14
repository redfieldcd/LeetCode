public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new LinkedList();
        if(nums == null) return list;
        if(nums.length == 0) {
            if(upper == lower) {
                list.add(""+lower);
            } else {
                list.add("" + lower + "->" + upper);
            }
            return list;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                if(nums[0] - lower == 1) {
                    list.add("" + lower);
                } else if(nums[0] - lower > 1) {
                    int a = lower;
                    int b = nums[0] - 1;
                    list.add(""+ a + "->" + b);
                }
            } else {
                if(nums[i] - nums[i-1] == 2) {
                    int num = nums[i] - 1;
                    list.add("" + num);
                } else if ( nums[i] - nums[i-1] > 2) {
                    int a = nums[i-1] + 1;
                    int b = nums[i] - 1;
                    list.add("" + a + "->" + b);
                }
            }
        }
        
        if(upper - nums[nums.length - 1] == 1) {
            list.add("" + upper);
        } else if(upper - nums[nums.length - 1] > 1) {
            int a = nums[nums.length - 1] + 1;
            int b = upper;
            list.add("" + a + "->" + b);
        }
        return list;
    }
}