#remove the duplicate of an array without extra place, return the new length 
#it doesn't matter what left beyound the new length
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        j=0
        if len(nums)==0:
            return 0
        for i in range(1,len(nums)):
            if nums[i]!=nums[j]:
                j+=1
                nums[j]=nums[i]
        return j+1
            