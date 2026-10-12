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
    public int sumNumbers(TreeNode root) 
    {
        int sum = 0;
        List<Integer> list = new ArrayList<>();

        dfs(root,sum,list);
        int total = 0;
        for(int i = 0 ;i < list.size() ; i++)
        {
            total += list.get(i);
        }
        return total;
    }
    public void dfs(TreeNode root,int sum,List<Integer> list)
    {
        if(root == null)
        {
            return;
        }
        sum = sum * 10 + root.val;
        if(root.right == null && root.left == null)
        {
            list.add(sum);
            sum = sum/10;
            return;
        }  
        dfs(root.left,sum,list);
        dfs(root.right,sum,list);
    }

}
