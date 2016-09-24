public class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap();
        map.put('9','6');
        map.put('6','9');
        map.put('8','8');
        map.put('1','1');
        map.put('0','0');
        int j;
        int len = num.length();
        for(int i = 0; i <= len/2; i++) {
            j = len - 1 - i;
            if(!map.containsKey(num.charAt(i))) return false;
            if(map.containsKey(num.charAt(i)) && map.get(num.charAt(i)) != num.charAt(j)) return false;  
        }
        
        return true;
    }
}