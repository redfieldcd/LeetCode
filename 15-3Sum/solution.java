public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        
        
        for(int i = 0; i <= nums.length - 3; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            if(i != 0 && nums[i] == nums[i-1]) continue;
            while(left < right) {
                int sum = nums[i] + nums[left]  +nums[right];
                if(sum == 0) {
                    List<Integer> temp = new LinkedList();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    left++;
                    right--;
                    while(left < right && nums[left - 1] == nums[left]) left++;
                    while(left < right && nums[right + 1] == nums[right]) right--;
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}





