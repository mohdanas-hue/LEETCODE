class Solution {
    public void flatten(TreeNode root) {

        while (root != null) {

            if (root.left != null) {

                // Find the rightmost node of left subtree
                TreeNode temp = root.left;

                while (temp.right != null) {
                    temp = temp.right;
                }

                // Connect right subtree after left subtree
                temp.right = root.right;

                // Move left subtree to right
                root.right = root.left;

                // Remove left pointer
                root.left = null;
            }

            // Move to next node
            root = root.right;
        }
    }
}