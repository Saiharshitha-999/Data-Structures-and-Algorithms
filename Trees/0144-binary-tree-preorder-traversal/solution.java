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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
        {
            return list;
        }
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty())
        {
            TreeNode data =  st.pop();
            list.add(data.val);

            if (data.right != null)
                st.push(data.right);

            if (data.left != null)
                st.push(data.left);
        }
        return list;
    }
}
