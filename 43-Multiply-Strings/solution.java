public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] p = new int[n1+n2];
        for(int i = n1 - 1; i >= 0; i--) {
            for(int j = n1 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                p[i+j+1] = d1 * d2;
            }
        }
        
        int carry = 0;
        for(int i = n1 + n2 - 1; i >= 0; i--) {
            int temp = (p[i] + carry) % 10;
            carry = (p[i] + carry) / 10;
            p[i] = temp;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int s: p) sb.append(s);
        while(sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0": sb.toString();
    }
}