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
    class Pair
    {
        TreeNode node;
        int sum;
        Pair(TreeNode node,int sum)
        {
            this.node = node;
            this.sum = sum;
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) 
    {
        if(root == null)
        {
            return false;
        }
       Stack<Pair> st = new Stack<>();
       st.push(new Pair(root,root.val));
    
       while(!st.isEmpty())
       {
           Pair current = st.pop();
           TreeNode node = current.node;
           int sum = current.sum;
           if(node.left == null && node.right == null && sum == targetSum)
           {
             return true;
           }
           if(node.right != null)
           {
             st.push(new Pair(node.right,sum+node.right.val));
           }
           if(node.left != null)
           {
             st.push(new Pair(node.left,sum+node.left.val));
           }


       }
       return false;
    }
}
