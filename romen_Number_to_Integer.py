#change a Rome number to int, when we have 4 identical letters, like IIII, it becaomes IV
class Solution(object):
    def romanToInt(self, s):
        l=list(s)
        dic={'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
        sum=0
        for rn in l:
            sum=sum+dic[rn]
        for i in range(len(l)-1):
            if dic[l[i]]<dic[l[i+1]]:
                sum=sum-2*dic[l[i]]
        return sum
            
