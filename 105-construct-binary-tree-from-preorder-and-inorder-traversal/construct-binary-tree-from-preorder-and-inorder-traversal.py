# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: list[int], inorder: list[int]) -> TreeNode | None:
        if len(preorder) == 0 or len(inorder) == 0:
            return None

        root_val = preorder[0]
        root = TreeNode(root_val)
        m = inorder.index(root_val)

        root.left = self.buildTree(preorder[1:m+1],inorder[:m])
        root.right = self.buildTree(preorder[m+1:],inorder[m+1:])
        return root
        