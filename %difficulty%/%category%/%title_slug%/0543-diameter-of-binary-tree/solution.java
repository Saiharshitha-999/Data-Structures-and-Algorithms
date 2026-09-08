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
    private int maxDiameter;
    public int diameterOfBinaryTree(TreeNode root) 
    {
        maxDiameter = 0;
        dfs(root);
        return maxDiameter;
    }
    public int dfs(TreeNode root)
    {
        if(root == null)
        {
            return -1;
        }
       
        int left = dfs(root.left);
        int right = dfs(root.right);

        int currentDiameter = left + right + 2;

        maxDiameter = Math.max(maxDiameter, currentDiameter);

        return Math.max(left,right) + 1;
    }
}
