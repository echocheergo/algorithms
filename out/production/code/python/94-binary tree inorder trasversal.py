# recursively:
def inorderTrasversal1(self,root):
    res = []
    self.helper(root,res)
    return res
def helper(self,root,res):
    if root:
        self.helper(root.left,res)
        res.append(root)
        self.helper(root.right,res)

# iterative:
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result, stack = [], [(root, False)]
        while stack:
            cur, visited = stack.pop()
            if cur:
                if visited:
                    result.append(cur.val)
                else:
                    stack.append((cur.right, False))
                    stack.append((cur, True))
                    stack.append((cur.left, False))
        return result
        