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
                path += subStr + " ";
                search(s, wordDict, i, path, res);
                path = path.substring(0, path.length() - subStr.length() - 1);
            } 
        }
    }
}