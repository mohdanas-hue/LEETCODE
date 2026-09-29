class Solution {
    int m, n;
    char[][] grid;
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        dp = new Boolean[m][n][m + n + 1];

        return dfs(0, 0, 0);
    }

    boolean dfs(int i, int j, int balance) {
        if (grid[i][j] == '(')
            balance++;
        else
            balance--;

        if (balance < 0)
            return false;

        if (balance > m + n)
            return false;

        if (dp[i][j][balance] != null)
            return dp[i][j][balance];

        if (i == m - 1 && j == n - 1)
            return dp[i][j][balance] = (balance == 0);

        boolean ans = false;

        if (i + 1 < m)
            ans = dfs(i + 1, j, balance);

        if (!ans && j + 1 < n)
            ans = dfs(i, j + 1, balance);

        return dp[i][j][balance] = ans;
    }
}