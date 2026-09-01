class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> nestedlist = new ArrayList<>();

        dfs(root, nestedlist, targetSum, list);

        return list;
    }

    public void dfs(TreeNode root, List<Integer> nestedlist,
                    int targetSum, List<List<Integer>> list) {

        if (root == null) {
            return;
        }

        nestedlist.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null) {

            if (targetSum == 0) {
                list.add(new ArrayList<>(nestedlist));
            }

            nestedlist.remove(nestedlist.size() - 1);
            return;
        }

        dfs(root.left, nestedlist, targetSum, list);
        dfs(root.right, nestedlist, targetSum, list);

        nestedlist.remove(nestedlist.size() - 1);
    }
}
