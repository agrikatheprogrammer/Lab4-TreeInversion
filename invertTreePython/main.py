class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class TreeInversion:
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

    def printTree(self, root): #helper method to print tree in order
        if root is None:
            return
        self.printTree(root.left)
        print(root.val, end=' ')
        self.printTree(root.right)


if __name__ == "__main__":
    a = TreeNode(2, TreeNode(3), TreeNode(4))
    b = TreeNode(8, TreeNode(5), TreeNode(6))
    rootNode = TreeNode(1, a, b)
    helper = TreeInversion()
    helper.printTree(rootNode)
    print()
    helper.printTree(helper.invertTree(rootNode))
    print()
    helper.printTree(helper.invertTree(rootNode))