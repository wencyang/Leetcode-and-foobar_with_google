#Definition for singly-linked list.
#class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        p=l1
        q=l2
        head=ListNode(0)
        curr=head
        carry=0
        while p!=None or q!=None or carry!=0:
            x=0
            y=0
            if p!=None:
                x=p.val
            if q!=None:
                y=q.val
            sum=x+y+carry
            carry=(x+y+carry)/10
            curr.next=ListNode(sum%10)
            curr=curr.next
            if p!=None:
                p=p.next
            if q!=None:
                q=q.next
        return head.next
    
