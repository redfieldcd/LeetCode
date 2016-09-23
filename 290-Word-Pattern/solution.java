public class Solution {
    // public boolean wordPattern(String pattern, String str) {
    //     String[] strs = str.split(" ");
        
    //     if(pattern.length() != strs.length) return false;
    //     //map can be used for multiple type
    //     Map map = new HashMap(); 
    //     for(Integer i = 0; i < strs.length; ++i) {
    //         // put object into map
    //         if(map.put(pattern.charAt(i), i) != map.put(strs[i], i)) 
    //             return false;
    //     }
        
    //     return true;
    // }
    
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        
        if(pattern.length() != strs.length) return false;
        Map<Character, String> map = new HashMap(); 
        
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)) {
                if(!map.get(c).equals(strs[i])) return false;
            } else {
                if(map.containsValue(strs[i])) return false;
                map.put(c, strs[i]);
            }
        }
       
        return true;
    }
}