public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList();
        if(nums == null || nums.length < 4) return res;
        
        Arrays.sort(nums);
        int len = nums.length;
        
        for(int i = 0; i <= len - 4; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j <= len - 3; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if(sum == target) {
                        List<Integer> temp = new LinkedList();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        left++;
                        right--;
                        while(left < right && nums[left - 1] == nums[left]) left++;
                        while(left < right && nums[right + 1] == nums[right]) right--;
                    } else if(sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}