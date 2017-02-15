##search insert position
##Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        i=0
        if len(nums)==0:
            return 0
        elif target in nums:
            return nums.index(target)
        elif nums[-1]<target:
            return len(nums)
        else:
            while nums[i]<target:
                i+=1
            return i
