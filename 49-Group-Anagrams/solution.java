public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> res = new LinkedList();
         Map<String, List<String>> map = new HashMap<String, List<String>>();
         
         for(int i = 0; i < strs.length; i++) {
             char[] s = strs[i].toCharArray();
             Arrays.sort(s);
             //一定要new 一个string
             String key = new String(s);
             List<String> list = map.get(key);
             if(list == null) {
                list = new LinkedList();
             }
             
             list.add(strs[i]);
             map.put(key, list);
         }
         
         for(String i : map.keySet()) {
             List<String> cur = map.get(i);
            //  Collections.sort(cur);
             res.add(cur);
         }
         
         return res;
    }
}