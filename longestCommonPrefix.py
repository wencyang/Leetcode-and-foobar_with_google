#find the longest common prefix, given a list of strings
class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs)==0:
            return ""
        if len(strs)==1:
            return strs[0]
        shortest=min(strs,key=len)

        if shortest=="":
            return ""
        for i in range(len(strs)):
            while(strs[i].find(shortest)!=0):
                shortest=shortest[:-1]
        return shortest