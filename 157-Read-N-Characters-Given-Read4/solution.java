/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        for(int i = 0; i < n; i += 4) {
            char[] temp = new char[4];
            int len = read4(temp);
            
            System.arraycopy(temp, 0, buf, i, Math.min(len, n - i));
            
            if(len < 4) return Math.min(i+len, n);
        }
        
        return n;
    }
}