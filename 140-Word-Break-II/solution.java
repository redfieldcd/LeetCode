public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new LinkedList();
        search(s, wordDict, 0, "", res);
        return res;
    }
    
    public void search(String s, Set<String> wordDict, int index, String path, List<String> res) {
        if(index == s.length()) {
            res.add(path.trim());
            return;
        }
        
        for(int i = index + 1; i <= s.length(); i++) {
            String subStr = s.substring(index, i);
            if(wordDict.contains(subStr)) {
                search(s, wordDict, i, path + subStr + " ", res);
            } 
        }
    }
}


// public class Solution {
//     public List<String> wordBreak(String s, Set<String> wordDict) {
//         Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        
//         List<String> l = new LinkedList();
//         l.add("");
//         map.put(s.length(), l);
        
//         for(int i = s.length() - 1; i >= 0; i--) {
//             List<String> values = new LinkedList();
//             for(int j = i + 1; j <= s.length(); j++) {
//                 String subStr = s.substring(i, j);
//                 if(wordDict.contains(subStr)) {
//                     for(String word : map.get(j)) {
//                         values.add(subStr + (word.isEmpty() ? "": " ") + word);
//                     }
//                 }
//             }
//             map.put(i, values);
//         }
        
//         return map.get(0);
//     }
// }







