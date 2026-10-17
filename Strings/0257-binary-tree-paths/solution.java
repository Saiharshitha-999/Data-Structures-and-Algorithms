class Solution {
    class Pair {
        TreeNode node;
        String path;

        Pair(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, String.valueOf(root.val)));

        while (!stack.isEmpty()) {

            Pair current = stack.pop();

            TreeNode node = current.node;
            String path = current.path;

            if (node.left == null && node.right == null) {
                ans.add(path);
                continue;
            }

            if (node.right != null) {
                stack.push(new Pair(
                    node.right,
                    path + "->" + node.right.val
                ));
            }

            if (node.left != null) {
                stack.push(new Pair(
                    node.left,
                    path + "->" + node.left.val
                ));
            }
        }

        return ans;
    }
}
