public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList();
        if(candidates == null || candidates.length == 0) return res;
        List<Integer> path = new LinkedList();
        // 必须要sort
        Arrays.sort(candidates);
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
            // 这边的i > index 非常重要, 既保证了116的情况,又remove duplicate
            if(i > index && candidates[i] == candidates[i-1]) continue;
            path.add(candidates[i]);
            search(res, path, i + 1, candidates, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}