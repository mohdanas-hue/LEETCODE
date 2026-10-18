class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode startNode = null;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.val == start) {
                startNode = curr;
            }

            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.add(curr.left);
            }

            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.add(curr.right);
            }
        }

        Set<TreeNode> visited = new HashSet<>();
        q.add(startNode);
        visited.add(startNode);

        int time = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            while (size-- > 0) {
                TreeNode curr = q.poll();

                if (curr.left != null && visited.add(curr.left)) {
                    q.add(curr.left);
                }

                if (curr.right != null && visited.add(curr.right)) {
                    q.add(curr.right);
                }

                TreeNode par = parent.get(curr);
                if (par != null && visited.add(par)) {
                    q.add(par);
                }
            }
        }

        return time;
    }
}