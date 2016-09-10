public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList();
        
        if(candidates == null || candidates.length == 0) return res;
        List<Integer> path = new LinkedList();
        
        search(res, path, 0, candidates, target);
        return res;
    }
    
    public void search(List<List<Integer>> res, List<Integer> path, int index, int[] candidates, int target) {
        if(target < 0) return;
        if(target == 0) {
            List<Integer> temp = new LinkedList(path);
            res.add(temp);
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            search(res, path, i, candidates, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    } 
}