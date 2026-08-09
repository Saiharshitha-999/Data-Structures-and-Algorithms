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
        int rows;
        TreeNode node;
        Pair(int rows, TreeNode node)
        {
            this.rows = rows;
            this.node = node;
        }
    }
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> list = new ArrayList<>();
        if(root == null)
        {
            return list;
        }

        TreeMap<Integer,Integer> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,root));
        while(!queue.isEmpty())
        {
            Pair node = queue.poll();
            map.put(node.rows,node.node.val);
            if(node.node.left != null)
            {
                queue.offer(new Pair(node.rows+1,node.node.left));
            }
            if(node.node.right != null)
            {
                queue.offer(new Pair(node.rows+1 ,node.node.right));
            }
        }
        list.addAll(map.values());
        return list;
        
    }
}
