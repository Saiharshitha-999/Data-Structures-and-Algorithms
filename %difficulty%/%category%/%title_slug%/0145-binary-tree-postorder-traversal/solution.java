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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Stack<TreeNode> st1 = new Stack<>();

        TreeNode lastVisited = null;
        TreeNode current = root;

        while(current != null || !st1.isEmpty())
        {
            while(current != null)
            {
                st1.push(current);
                current = current.left;
                
            }

            TreeNode node = st1.peek();
            if(node.right == null || lastVisited == node.right)
            {
                st1.pop();
                ans.add(node.val);
                lastVisited = node;
            }
            else
            {
                current = node.right;
            }
            

        }
        return ans;
    
    }
}
