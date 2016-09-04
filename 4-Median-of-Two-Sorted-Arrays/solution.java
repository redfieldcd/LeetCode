// time O(k)
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return 0.0;
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int mid = (len1 + len2) / 2;
        
        //如果总长度是奇数，中位数就是单个数字/如果总长度是偶数，中位数就是两个数字的均数
        if((len1 + len2) % 2 == 1) {
           return findk(nums1, 0, nums2, 0, mid + 1); 
        } else {
           return (findk(nums1, 0, nums2, 0, mid) + findk(nums1, 0, nums2, 0, mid+1)) / 2;
        }
    }
    
    public double findk(int[] nums1, int a, int[] nums2, int b, int k) {
        if(a == nums1.length || (b < nums2.length && nums2[b] < nums1[a])) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int t = a;
            a = b;
            b = t;
        }
        //nums1[a] 总是当前最小    
        if(k == 1) return nums1[a];
        
        return findk(nums1, ++a, nums2, b, --k);
    }
}