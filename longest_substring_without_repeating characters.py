class Solution(object):
    def lengthOfLongestSubstring(self, s):
        start=0
        char={}
        maxlength=0
        for i in range(len(s)):
            if s[i] in char and start<=char[s[i]]:
                start=char[s[i]]+1
            else:
                maxlength=max(maxlength,i-start+1)
            char[s[i]]=i
        return maxlength
