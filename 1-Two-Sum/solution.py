# class Solution(object):
#     def twoSum(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: List[int]
#         """
#         if len(nums) <= 1:
#           return False
#         buff_dict = {}
#         for i in range(len(nums)):
#             if nums[i] in buff_dict:
#                 return [buff_dict[nums[i]], i]
#             else: 
#                 buff_dict[target - nums[i]] = i
                
                
class Solution(object):
    def twoSum(self, nums, target):
        nums.sort()
        i, j = 0, len(nums)-1
        while i < j:
            sum = nums[i] + nums[j]
            print i
            print j
            print sum
            if sum == target:
                return [i+1,j+1];
            elif sum < target:
                i = i+1
            else:
                j = j-1
            
            
            
            