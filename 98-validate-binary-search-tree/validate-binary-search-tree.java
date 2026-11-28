/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     List<Integer> l = new ArrayList<>();
    public boolean isValidBST(TreeNode root) 
    {
        BST(root);
        for(int i = 0; i < l.size() - 1; i++)
        {
            if(l.get(i) >= l.get(i+1))
            {
                return false;
            }
        }
        return true;

    }
    public TreeNode BST(TreeNode root)
    {
        if(root == null)
        {
            return root;
        }
        if(root != null)
        {
            BST(root.left);
            l.add(root.val);
            BST(root.right);
        }
        return root;
    }
}