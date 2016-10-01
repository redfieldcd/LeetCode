public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
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
        
        helper(nums, idx+1, temp, res);
        temp.add(nums[idx]);
        helper(nums, idx+1, temp, res);
        temp.remove(temp.size() - 1);
    }
    
    // public void helper(int[] nums, int idx, List<Integer> temp, List<List<Integer>> res) {
    //     if(idx >= nums.length) return;
    //     //不包含这个元素的
    //     helper(nums, idx+1, temp, res);
    //     //新的集合要new一个新的list，防止修改引用。
    //     List<Integer> temp2 = new LinkedList(temp);
    //     temp2.add(nums[idx]);
    //     res.add(temp2);
    //     //包含这个元素的
    //     helper(nums, idx+1, temp2, res);
    // }
}