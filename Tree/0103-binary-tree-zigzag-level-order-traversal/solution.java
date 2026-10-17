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
    private int i;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
         List<List<Integer>> list1 = new ArrayList<>();
        if(root == null)
        {
            return list1;
        }
      
       Queue<TreeNode> queue = new LinkedList<>();

        int j = 0;
        queue.add(root);
        while(!queue.isEmpty())
        {
            List<Integer> list2 = new ArrayList<>();
            int size = queue.size();
            for(int i = 0 ; i < size; i++)
            {
                TreeNode node = queue.poll();
                list2.add(node.val);
                if(node.left != null)
                {
                queue.offer(node.left);
                }
                if(node.right != null)
                {
                    queue.offer(node.right);
                }
            }
            if(j%2 != 0)
            {
                Collections.reverse(list2);
            }
            j++;
            list1.add(list2);
        }
        return list1;

    }
}
