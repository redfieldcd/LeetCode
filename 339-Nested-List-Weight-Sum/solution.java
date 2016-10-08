/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 //design a class of NestedInteger
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> q = new LinkedList();
        
        int res = 0;
        int level = 1;
        for(NestedInteger NI: nestedList) {
            q.offer(NI);
        }
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                NestedInteger NI = q.poll();
                if(NI.isInteger()) {
                    res += NI.getInteger() * level;
                } else {
                    for(NestedInteger ni : NI.getList()) {
                        q.offer(ni);
                    }
                }
            }
            
            level++;
        }
        
        return res;
    }
}