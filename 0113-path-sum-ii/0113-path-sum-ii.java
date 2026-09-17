class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();

        solve(root, targetSum, new ArrayList<>(), result);

        return result;
    }

    public void solve(TreeNode root, int target,
                       List<Integer> path,
                       List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        path.add(root.val);

        // Check leaf node
        if (root.left == null && root.right == null) {

            if (target == root.val) {
                result.add(new ArrayList<>(path));
            }

        } else {

            solve(root.left, target - root.val, path, result);

            solve(root.right, target - root.val, path, result);
        }

        // Backtracking
        path.remove(path.size() - 1);
    }
}