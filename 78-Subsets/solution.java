public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList();
        List<Integer> temp = new LinkedList();
        
        helper(nums, 0, temp, res);
        
        return res;
    }
    
    public void helper(int[] nums, int idx, List<Integer> temp, List<List<Integer>> res) {
        if(idx == nums.length) {
            res.add(new LinkedList(temp));
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