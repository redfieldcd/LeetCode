public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder s = new StringBuilder();
        int carry = 0;
        
        while(i >= 0 || j >= 0) {
            int m = i >= 0 ? a.charAt(i) - '0': 0;
            int n = j >= 0 ? b.charAt(j) - '0': 0;
            
            int num = m + n + carry;
            
            s.insert(0, String.valueOf(num % 2));
            
            i--;
            j--;
            carry = num / 2;
        }
        
        if(carry == 1) s.insert(0, String.valueOf(carry));
        
        return s.toString();
    }
}