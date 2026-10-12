/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        makeParentMap(root, parent);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            if (distance == k) {
                List<Integer> ans = new ArrayList<>();

                while (!queue.isEmpty()) {
                    ans.add(queue.poll().val);
                }

                return ans;
            }

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                if (current.left != null && !visited.contains(current.left)) {
                    visited.add(current.left);
                    queue.offer(current.left);
                }

                if (current.right != null && !visited.contains(current.right)) {
                    visited.add(current.right);
                    queue.offer(current.right);
                }

                if (parent.containsKey(current) &&
                    !visited.contains(parent.get(current))) {

                    visited.add(parent.get(current));
                    queue.offer(parent.get(current));
                }
            }

            distance++;
        }

        return new ArrayList<>();
    }

    public void makeParentMap(
        TreeNode root,
        Map<TreeNode, TreeNode> parent) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current.left != null) {
                parent.put(current.left, current);
                queue.offer(current.left);
            }

            if (current.right != null) {
                parent.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }
}
