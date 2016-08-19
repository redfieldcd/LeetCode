public class Solution {
    public String countAndSay(int n) {
        StringBuffer pre = new StringBuffer();
        StringBuffer cur = new StringBuffer("1");
        
        int count = 0;
        char say;
        int j;
        for(int i = 0; i < n; i++) {
            pre = cur;
            cur = new StringBuffer();
            j = 0;
            
            while(j < pre.length()) {
                say = pre.charAt(j);
                j++;
                count = 1;
                while(j < pre.length() && pre.charAt(j) == say) {
                    j++;
                    count++;
                }
                
                cur.append(count).append(say);
            }
        }
        
        return pre.toString();
    }
}


