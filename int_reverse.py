class Solution(object):
    def reverse(self, x):
        rev=0
        flag=False
        if x<0:
            x=abs(x)
            flag=True
        while x!=0:
            rev=rev*10+x%10
            x=x/10
        if rev>1<<31:
            return 0
        elif flag:
            return -rev
        else:
            return rev
            