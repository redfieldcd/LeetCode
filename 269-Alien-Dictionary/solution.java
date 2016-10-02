public class Solution {
    public String alienOrder(String[] words) {
        int[] inDegree = new int[26];
        // Arrays.fill(inDegree, -1);
        
        Queue<Character> q = new LinkedList();
        List<char[]> list = new LinkedList();
        
        Set<Character> set = new HashSet();
        String res = "";
        
        if(words.length == 1) {
            for(int i = 0; i < words[0].length(); i++) {
                set.add(words[0].charAt(i));
            }
        }
        
        for(int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];
            
            int a = 0, b = 0;
            boolean isFound = false;
            while(a < s1.length() && b < s2.length()) {
                set.add(s1.charAt(a));
                set.add(s2.charAt(b));
                if(s1.charAt(a) != s2.charAt(b)) {
                    inDegree[s2.charAt(b) - 'a']++;
                    list.add(new char[]{s1.charAt(a), s2.charAt(b)});
                    isFound = true;
                    break;
                }
                a++;
                b++;
            }
            
            // System.out.println(s1.length() + " " + a);
            if(!isFound && a != s1.length()) {
                return "";
            }
            
            while(a < s1.length()) {
                set.add(s1.charAt(a));
                a++;
            }
            
            while(b < s2.length()) {
                set.add(s2.charAt(b));
                b++;
            }
        }
        
        
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0 && set.contains((char)(i + 'a'))) {
                // System.out.println((char)(i + 'a'));
                q.offer((char)('a' + i));
            }
        }
        
        while(!q.isEmpty()) {
            Character c = q.poll();
            res += c;
            for(char[] l : list) {
                if(l[0] == c) {
                    inDegree[l[1] - 'a']--;
                    if(inDegree[l[1] - 'a'] == 0) q.offer(l[1]);
                }
            }
        }
        
        // System.out.println(res.length() +" " + set.size());
        return res.length() == set.size() ? res : "";
        
    }
}