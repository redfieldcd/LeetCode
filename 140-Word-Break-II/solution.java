// public class Solution {
//     public List<String> wordBreak(String s, Set<String> wordDict) {
//         List<String> res = new LinkedList();
//         search(s, wordDict, 0, "", res);
//         return res;
//     }
    
//     public void search(String s, Set<String> wordDict, int index, String path, List<String> res) {
//         if(index == s.length()) {
//             res.add(path.trim());
//             return;
//         }
        
//         for(int i = index + 1; i <= s.length(); i++) {
//             String subStr = s.substring(index, i);
//             if(wordDict.contains(subStr)) {
//                 path += subStr + " ";
//                 search(s, wordDict, i, path, res);
//                 path = path.substring(0, path.length() - subStr.length() - 1);
//             } 
//         }
//     }
// }
public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        Map<Integer, List<String>> validMap = new HashMap<Integer, List<String>>();

        // initialize the valid values
        List<String> l = new ArrayList<String>();
        l.add("");
        validMap.put(s.length(), l);

        // generate solutions from the end
        for(int i = s.length() - 1; i >= 0; i--) {
            List<String> values = new ArrayList<String>();
            for(int j = i + 1; j <= s.length(); j++) {
                if (dict.contains(s.substring(i, j))) {
                    for(String word : validMap.get(j)) {
                        values.add(s.substring(i, j) + (word.isEmpty() ? "" : " ") + word);
                    }
                }
            }
            validMap.put(i, values);
        }
        return validMap.get(0);
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







