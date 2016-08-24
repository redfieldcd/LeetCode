public class Solution {
    public int romanToInt(String s) {
        int total = charToInt(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++) {
            int pre = charToInt(s.charAt(i-1));
            int cur = charToInt(s.charAt(i));
            
            if(cur <= pre) {
                total += cur;
            } else {
                total = total - 2 * pre + cur;
            }
        }
        
        return total;
    }
    
    public int charToInt(char c) {
        int data = 0;
        switch(c) {
            case('I'):
                data = 1;
                break;
            case('V'):
                data = 5;
                break;
            case('X'):
                data = 10;
                break;
            case('L'):
                data = 50;
                break;
            case('C'):
                data = 100;
                break;
            case('D'):
                data = 500;
                break;
            case('M'):
                data = 1000;
                break;
        }
        
        return data;
    }
}