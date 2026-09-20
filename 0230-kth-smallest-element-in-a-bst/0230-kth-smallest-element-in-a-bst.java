class Solution {
    int count = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        // Left
        inorder(root.left, k);

        // Node
        count++;

        if (count == k) {
            result = root.val;
            return;
        }

        // Right
        inorder(root.right, k);
    }
}