public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList();
        res.add(0);
        if(n == 0) return res;
        
        for(int i = 0; i < n; i++) {
            List<Integer> temp = new LinkedList();
            temp.addAll(res);
            
            for(int j = temp.size() - 1; j >= 0; j--) {
                res.add((1<<i) + temp.get(j));
            }
        }
        
        return res;
    }
}