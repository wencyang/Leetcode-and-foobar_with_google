'''
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.
'''
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        r=[]
        l=len(nums)
        nums.sort()
        if nums==[]:
            return []
        if nums[0]==nums[-1]:
            if nums[0]==0 and l>2:
                return [[0,0,0]]
            else:
                return []

        for i in range(l):
            lo=0
            hi=l-1
            while lo<i and hi>i:
                if nums[lo]+nums[hi]+nums[i]==0:
                    r.append([nums[lo],nums[i],nums[hi]])
                    lo+=1
                elif nums[lo]+nums[hi]+nums[i]<0:
                    lo+=1
                else:
                    hi-=1
        b_set = set(map(tuple,r))
        r = map(list,b_set)
        return r