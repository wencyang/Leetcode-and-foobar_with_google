class Solution(object):
    def addBinary(self, a, b):
        """
            :type a: str
            :type b: str
            :rtype: str
            """
        c = int(a,2) + int(b,2)
        binary = lambda n: '' if n==0 else binary(n/2) + str(n%2)
        c=binary(c)
        if c=='':
            c='0'
        return c