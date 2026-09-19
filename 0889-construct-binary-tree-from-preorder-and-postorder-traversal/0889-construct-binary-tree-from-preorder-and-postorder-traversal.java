class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;

        return buildconstructFromPrePost(
            0, n - 1,
            0, n - 1,
            preorder, postorder
        );
    }

    public TreeNode buildconstructFromPrePost(
        int ilo, int ihi,
        int plo, int phi,
        int[] preorder, int[] postorder
    ) {

        if (ilo > ihi) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[ilo]);

        // Only one node
        if (ilo == ihi) {
            return root;
        }

        // Root of left subtree
        int leftRoot = preorder[ilo + 1];

        // Find leftRoot in postorder
        int r = plo;

        while (postorder[r] != leftRoot) {
            r++;
        }

        // Length of left subtree
        int leftSize = r - plo + 1;

        // Left subtree
        root.left = buildconstructFromPrePost(
            ilo + 1,
            ilo + leftSize,
            plo,
            r,
            preorder,
            postorder
        );

        // Right subtree
        root.right = buildconstructFromPrePost(
            ilo + leftSize + 1,
            ihi,
            r + 1,
            phi - 1,
            preorder,
            postorder
        );

        return root;
    }
}