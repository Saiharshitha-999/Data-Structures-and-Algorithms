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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
       List<Integer> list = new ArrayList<>();
       Stack<TreeNode> st = new Stack<>();
       TreeNode current = root;
       while(!st.isEmpty() || current != null)
       {
          while(current != null)
          {
            st.push(current);
            current = current.left;
          }
          TreeNode node = st.pop();
          list.add(node.val);
          current = node.right;
       }
        return list;
    }
}

