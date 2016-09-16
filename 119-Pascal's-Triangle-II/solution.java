public class Solution {
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> all = new ArrayList<List<Integer>>();
        
        for(int i = 0; i <= numRows; i++){
            List<Integer> row = new ArrayList<Integer>();
            
            for(int j = 0; j < i+1; j++){
                if(j == 0 || j == i) row.add(1);
                else row.add(all.get(i-1).get(j-1)+all.get(i-1).get(j));
            }
            all.add(row);
        }
        return all.get(numRows);
     }
}