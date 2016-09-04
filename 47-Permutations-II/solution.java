public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        List<Integer> path = new LinkedList();
        //要对原数组进行sort O(nlogn)
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        search(res, path, nums, visited);
        return res;
    }
    
    public void search(List<List<Integer>> res, List<Integer> path, int[] nums, int[] visited) {
        if(path.size() == nums.length) {
            List<Integer> list = new LinkedList(path);
            res.add(list);
        } 
        
        for(int i = 0; i < nums.length; i++) {
            //被访问过或者是1,2,2这样的第二个2开始的情况
            if(visited[i] == 1 || (i != 0 && nums[i] == nums[i-1] && visited[i - 1] == 0)) continue;
            
            visited[i] = 1;
            path.add(nums[i]);
            search(res, path, nums, visited);
            path.remove(path.size()-1);
            visited[i] = 0;
        }
    }
}
