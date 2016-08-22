public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        if(nums == null || nums.length < 3) return res; 
        Arrays.sort(nums);
        int len = nums.length; 
        for(int i = 0; i < len; i++) {
            int m = i+1;
            int n = len-1;
            if(i != 0 && nums[i] == nums[i-1]) continue;
            while(m < n) {
                int sum = nums[i] + nums[m] + nums[n];
                if(sum == 0) {
                    List<Integer> temp = new LinkedList();
                    temp.add(nums[i]);
                    temp.add(nums[m]);
                    temp.add(nums[n]);
                    res.add(temp);
                    m++;
                    n--;
                    while(nums[m+1] == nums[m]) m++;
                    while(nums[n] == nums[n-1]) n--;
                } else if(sum > 0) {
                    n--;
                } else {
                    m++;
                }
            }
        }
        
        return res;
    }
}