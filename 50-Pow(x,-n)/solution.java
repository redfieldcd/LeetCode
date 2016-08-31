public class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            return 1/pow(x, -n);
        } else {
            return pow(x, n);
        }
    }
    
    public double pow(double x, int n) {
        if(n == 0) {
            return 1.0;
        } else if(n == 1) {
            return x;
        } else {
            double val = pow(x, n/2);
            if(n % 2 == 0) {
                return val * val;
            } else {
                return val * val * x;
            }
        }
    }
}