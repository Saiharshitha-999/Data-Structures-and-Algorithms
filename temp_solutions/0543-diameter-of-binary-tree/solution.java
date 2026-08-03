class Solution {
    
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0; 
        }

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

