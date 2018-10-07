# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None
import sys
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        from heapq import heapify, heappop, heappush, heapreplace
        dummy = cur = ListNode(0)
        h = [(n.val, n) for n in lists if n]
        heapify(h)
        while h:
            v,no = h[0]
            if no.next is None:
                heappop(h)
            else:
                heapreplace(h,(no.next.val, no.next))
            cur.next = no
            cur = cur.next
        return dummy.next