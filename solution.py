class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        pass

    def invertTree(self, root):
        if root is not None:
            temp = root.right
            root.right = root.left
            root.left = temp
            self.invertTree(root.right)
            self.invertTree(root.left)
        return root

    def printTree(self, root):  # helper method to print tree in order
        if root is None:
            return
        self.printTree(root.left)
        print(root.val, end=' ')
        self.printTree(root.right)


a = TreeNode(2, TreeNode(3), TreeNode(4))  # create left subtree
b = TreeNode(8, TreeNode(5), TreeNode(6))  # create right subtree
rootNode = TreeNode(1, a, b)
helper = Solution()
helper.printTree(rootNode)
print()
helper.printTree(helper.invertTree(rootNode))
print()
helper.printTree(helper.invertTree(rootNode))
