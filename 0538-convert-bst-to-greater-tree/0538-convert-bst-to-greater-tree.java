class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root);
        return root;
    }

    void reverseInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        // Right
        reverseInorder(root.right);

        // Root
        sum += root.val;
        root.val = sum;

        // Left
        reverseInorder(root.left);
    }
}