// Two pointers Running time O(n)
public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int leftMax = 0;
        int rightMax = 0;
    
        int a = 0;
        int b = height.length - 1;
        
        int max = 0;
        
        while(a  < b) {
            leftMax = Math.max(leftMax, height[a]);
            rightMax = Math.max(rightMax, height[b]);
            
            if(leftMax < rightMax) {
                max += leftMax - height[a];
                a++;
            } else {
                max += rightMax - height[b];
                b--;
            }
        }
        
        return max;
    }
}