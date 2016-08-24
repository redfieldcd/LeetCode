public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();
        res.add(temp);
        // if(nums == null) return res;
        
        helper(res, temp, 0, nums);
        
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> temp, int index, int[] nums) {
        if (index >= nums.length) return;
        int old = index;
        while(index < nums.length-1 && nums[index + 1] == nums[index]) index++;
        helper(res, temp, index+1, nums);
        for(int i = old; i <= index; i++) {
            List<Integer> temp2 = new ArrayList<Integer>(temp);
            for(int j = i; j <= index; j++) {
               temp2.add(nums[index]); 
            }
            res.add(temp2);
            helper(res, temp2, index+1, nums);
        }
       
    }
}