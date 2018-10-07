# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
        res = []
        self.helpFind(root,res)
        i, j = 0, len(res) - 1
        while i <= j - 1:
            if res[i].val + res[j].val < k:
                i += 1
            elif res[i].val + res[j].val > k:
                j -= 1
            else:
                return True
        return False
        
    def helpFind(self,root,res):
        if root:
            self.helpFind(root.left, res)
            res.append(root)
            self.helpFind(root.right,res)
## solution 2: since no path is required, found one is true. BFS
class Solution(object):
    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
        bfs,s = [root],set()
        for i in bfs:
            if i.val in s:
                return True
            s.add(i.val)
            if i.left:
                bfs.append(i.left)
            if i.right:
                bfs.append(i.right)
        return False
