public class Solution {
    List<String> res = new LinkedList();
    
    public List<String> letterCombinations(String digits) {
        String[] table = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder temp = new StringBuilder();
        if(digits == null) return res;
        
        helper(table, 0, digits, temp);
        return res;
    }
    
    public void helper(String[] table, int idx, String digits, StringBuilder temp) {
        if(idx == digits.length()) {
            if(temp.length() != 0) res.add(temp.toString());
        } else {
            String all = table[digits.charAt(idx) - '0'];
        
            for(int i = 0; i < all.length(); i++) {
                temp.append(all.charAt(i));
                helper(table, idx+1, digits, temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}