class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root is None:
            return None

        # If the root is one of p or q, then it is the LCA
        if root == p or root == q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        # If both TreeNodes lie in left or right then their LCA is in left or right,
        # Otherwise root is their LCA
        if left is not None and right is not None:
            return root

        return left if left is not None else right


c = TreeNode(1)
f = TreeNode(9)
g = TreeNode(5)
a = TreeNode(3, c)
b = TreeNode(8, g, f)
root = TreeNode(4, a, b)
print(Solution().lowestCommonAncestor(root, f, g).val)
