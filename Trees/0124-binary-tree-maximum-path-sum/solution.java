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
    private int pathsum;
    public int maxPathSum(TreeNode root) 
    {   pathsum = Integer.MIN_VALUE;
        TotalpathSum(root);
        return pathsum;
    }
    public int TotalpathSum(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int leftvalue = Math.max(0,TotalpathSum(root.left));
        int rightvalue = Math.max(0,TotalpathSum(root.right));
        int temp = leftvalue + rightvalue + root.val;
        pathsum = Math.max(temp,pathsum);
        return root.val + Math.max(leftvalue,rightvalue);
    }
}
