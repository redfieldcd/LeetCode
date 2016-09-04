public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        List<Integer> path = new LinkedList();
        search(nums, res, path);
        
        return res;
    }
    
    public void search(int[] nums, List<List<Integer>> res, List<Integer> path) {
        if(path.size() == nums.length) {
            List<Integer> temp = new LinkedList(path);
            res.add(temp);
        }
        for(int i = 0; i < nums.length; i++) {
            if(path.contains(nums[i])) {
                continue;
            }
            
            path.add(nums[i]);
            search(nums, res, path);
            path.remove(path.size() - 1);
        }
    }
}