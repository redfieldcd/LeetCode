public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int max = 0;
        while(left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            if(temp > max) {
                max = temp;
            } 
            
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return max;
    }
}