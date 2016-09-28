public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new LinkedList();
        
        Map<String, List<String>> map = new HashMap();
        
        for(String tr : strings) {
            int shift = tr.charAt(0) - 'a';
            String key = "";
                
            for(char c : tr.toCharArray()) {
                char ch = (char)(c - shift);
                if (ch < 'a') {
                   ch += 26;
                }
                key += ch;
            }
            if(!map.containsKey(key)) {
                List<String> list = new LinkedList();
                map.put(key, list);
            }
            map.get(key).add(tr);
        }
        
        for(String key : map.keySet()) {
            List<String> list = map.get(key);
            res.add(list);
        }
        
        return res;
        
    }
}