class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int start, int end) {

        if (start > end) {
            return null;
        }

        // First element is root
        TreeNode root = new TreeNode(preorder[start]);

        // Find first element greater than root
        int i = start + 1;

        while (i <= end && preorder[i] < root.val) {
            i++;
        }

        // Left subtree
        root.left = build(preorder, start + 1, i - 1);

        // Right subtree
        root.right = build(preorder, i, end);

        return root;
    }
}