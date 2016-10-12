//Design Test Cases
// 1. aa aa  test matched character
// 2. a. aa  test .
// 3. a aa 
// 4. a. a
// 5. a* a
// 6. aa aa*
// 7. ab aa*
// 8. ba bab*
// public class Solution {
//     public boolean isMatch(String s, String p) {
//       if(p.length() == 0) {
//           return s.length() == 0;
//       }
       
//       if(p.length() > 1 && p.charAt(1) == '*') {
//           if(isMatch(s, p.substring(2))){
//               return true;
//           }
           
//           if(s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
//               if(isMatch(s.substring(1), p)) {
//                   return true;
//               }
//           }
           
//           return false;
//       } else {
//           if(s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
//               return isMatch(s.substring(1), p.substring(1));
//           }
           
//           return false;
//       }
//     }
// }

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        
        for(int i = 1; i < p.length(); i++) {
            if(p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < p.length(); j++) {
                if(p.charAt(j) == '*') {
                    if(p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.') {
                        dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }
                } else {
                    dp[i+1][j+1] = ((s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dp[i][j]);
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}

// public class Solution {
//     public boolean isMatch(String s, String p) {
//       boolean[][] dp = new boolean[s.length()+1][p.length()+1];
//       dp[0][0] = true;
       
//       for(int i = 0; i < p.length(); i++) {
//           if(p.charAt(i) == '*' && dp[0][i-1]) {
//               dp[0][i+1] = true;
//           } 
//       }
       
//       for(int i = 0; i < s.length(); i++) {
//           for(int j = 0; j < p.length(); j++) {
//               if(p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
//                   dp[i+1][j+1] = dp[i][j];
//               } 
               
//               if(p.charAt(j) == '*') {
//                   if(s.charAt(i) != p.charAt(j-1) && p.charAt(j-1) != '.') {
//                       dp[i+1][j+1] = dp[i+1][j-1];
//                   } else {
//                       dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1];
//                   }
//               }
//           }
//       }
       
       
//       return dp[s.length()][p.length()];
//     }
// }