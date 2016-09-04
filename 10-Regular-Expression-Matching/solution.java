// public class Solution {
//     public boolean isMatch(String s, String p) {
//         bolean[] res = new boolean[s.length() + 1];
//         res[s.length()] = true;
//         for (int i = p.length(); i >= 0; i--) {
//             if (p.charAt(i) == "*") {
//                 for (int j = s.length() - 1; j >= 0; j--) {
//                     res[j] = res[j] || (res[j+1] && (p.charAt(i - 1) == '.' || p.charAt(i-1) == s.chatAt(j)));
//                 } 
//                 i--;
//             } else {
//                 for(int j = 0; j < s.length(); j++) {
//                     res[j] = res[j+1] && (p.charAt(i) == '.' || p.charAt(i) == p.charAt(j));
//                 }
//                 match[s.length()] = false;
//             }
//         }
//         return res;
//     }
// }

public class Solution {
    public boolean isMatch(String s, String p) {
       boolean[][] dp = new boolean[s.length()+1][p.length()+1];
       dp[0][0] = true;
       
       for(int i = 0; i < p.length(); i++) {
           if(p.charAt(i) == '*' && dp[0][i-1]) {
               dp[0][i+1] = true;
           } 
       }
       
       for(int i = 0; i < s.length(); i++) {
           for(int j = 0; j < p.length(); j++) {
               if(p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                   dp[i+1][j+1] = dp[i][j];
               } 
               
               if(p.charAt(j) == '*') {
                   if(s.charAt(i) != p.charAt(j-1) && p.charAt(j-1) != '.') {
                       dp[i+1][j+1] = dp[i+1][j-1];
                   } else {
                       dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1];
                   }
               }
           }
       }
       
       return dp[s.length()][p.length()];
    }
}