public class Solution {
    public String minWindow(String s, String t) {
        int[] src = new int[255];
        int[] des = new int[255];
        for(int i = 0; i < t.length(); i++) {
            src[t.charAt(i)]++;
        }
        
        int min_len = s.length();
        int start = 0, end = s.length();
        int begin = -1;
        int found = 0;
        int i = 0;
        for(start = i = 0; i < s.length(); i++) {
           des[s.charAt(i)]++;
           
           if(des[s.charAt(i)] <= src[s.charAt(i)]) {
               found++;
           }
           
           if(found == t.length()) {
               while(start < i && des[s.charAt(start)] > src[s.charAt(start)]) {
                   des[s.charAt(start)]--;
                   start++;
               }
               
               if(i - start < min_len){
                   min_len = i - start;
                   begin = start;
                   end = i;
                }
                des[s.charAt(start)]--;
                start++;
                found--;
           }
           
        }
        
        return begin == -1 ? "": s.substring(begin, end+1);
    }
}