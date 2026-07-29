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
    public void postorderTraverse(List<Integer> list,TreeNode root)
    {
        if (root == null) {
            return;
        }

        postorderTraverse(list, root.left);
        postorderTraverse(list, root.right);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        postorderTraverse(list, root);

        return list;
    }
}
