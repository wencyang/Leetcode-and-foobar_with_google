#return the length of the last word of a string, if None, return 0 
import re
class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        if re.match(r".*\w+.*",s)==None:
            return 0
        else:
            print s.split()[-1]
            return len(s.split()[-1])
