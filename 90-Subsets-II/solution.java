public class Solution {
    Set<List<Integer>> set = new HashSet();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 对于没有重复的元素来说，sort无所谓
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList();
        List<Integer> temp = new LinkedList();
        
        helper(nums, 0, temp, res);
        
        return res;
    }
    
    public void helper(int[] nums, int idx, List<Integer> temp, List<List<Integer>> res) {
        if(idx == nums.length) {
            if(!set.contains(temp)) {
                res.add(new LinkedList(temp));
                set.add(temp);
            }
            
            return;
        }
        //skip 
        helper(nums, idx+1, temp, res);
        //add
        temp.add(nums[idx]);
        helper(nums, idx+1, temp, res);
        temp.remove(temp.size() - 1);
    }
}