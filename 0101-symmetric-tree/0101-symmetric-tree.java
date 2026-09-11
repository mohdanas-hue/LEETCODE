class Solution {
    public boolean isSymmetric(TreeNode root) {
        return checkMirror(root.left, root.right);
    }

    private boolean checkMirror(TreeNode left, TreeNode right) {

        // Both are null
        if (left == null && right == null) {
            return true;
        }

        // One is null
        if (left == null || right == null) {
            return false;
        }

        // Values are different
        if (left.val != right.val) {
            return false;
        }

        // Check mirror children
        return checkMirror(left.left, right.right)
            && checkMirror(left.right, right.left);
    }
}