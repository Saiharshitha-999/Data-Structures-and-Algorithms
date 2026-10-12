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
       
        int row;
        int val;

        Pair(int row,int val)
        {
            this.row = row;
            this.val = val;
        }
    }
    class BFSPair
    {
        TreeNode node;
        int row;
        int col;
        BFSPair(TreeNode node,int row,int col)
        {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root)  
    {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
        {
            return list;
        }
        TreeMap<Integer,PriorityQueue<Pair>> tree = new TreeMap<>();
        Queue<BFSPair> queue = new LinkedList<>();
        queue.offer(new BFSPair(root,0,0));
        while(!queue.isEmpty())
        {
             BFSPair current = queue.poll();
             tree.putIfAbsent(current.col,new PriorityQueue<>((a,b)->
             {
                if (a.row == b.row) 
                   return a.val - b.val; 
                return a.row - b.row; 
            })
             );

            tree.get(current.col).offer(new Pair(current.row,current.node.val));
            if (current.node.left != null) 
            { 
                queue.offer(new BFSPair( current.node.left, current.row + 1, current.col - 1)); 
            } 
            if (current.node.right != null) 
            { 
                queue.offer(new BFSPair( current.node.right, current.row + 1, current.col + 1)); 
            }

        }
        for (PriorityQueue<Pair> pq : tree.values()) 
        { 
            List<Integer> temp = new ArrayList<>(); 
            while (!pq.isEmpty()) 
            { 
                temp.add(pq.poll().val); 
            } 
            list.add(temp);
        }
        return list;

    }
    
}
