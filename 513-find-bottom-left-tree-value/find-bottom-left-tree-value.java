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
    public int findBottomLeftValue(TreeNode root) {
        if(root ==  null)
        {
            return -1;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int k = 0;

        while(!q.isEmpty())
        {
            int n = q.size();
            for(int i = 0; i < n; i++)
            {
                TreeNode node = q.poll();
                if(i == 0)
                {
                    k = node.val;
                }
                if(node.left != null)
                {
                    q.offer(node.left);
                }
                if(node.right != null)
                {
                    q.offer(node.right);
                }
            }

        }
        return k;
    }
}