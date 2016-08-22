public class Solution {
    //倒着存数组元素
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int all = n + m - 1;
        int i = m-1;
        int j = n-1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[all] = nums1[i];
                i--;
            } else {
                nums1[all] = nums2[j];
                j--;
            }
            
            all--;
        }
        
        while(j >= 0) nums1[all--] = nums2[j--]; 
    }
}