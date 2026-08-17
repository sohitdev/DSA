//======Tabulation======//
// Time Complexity: O(n * m^2) | Space Complexity: O(n * m^2)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                dp[n-1][i][j] = (i == j) ? grid[n-1][i] : grid[n-1][i] + grid[n-1][j];
            }
        }

        int[] dc = {-1, 0, 1};

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int cherries = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                    int max = Integer.MIN_VALUE;
                    for (int dj1 : dc) {
                        for (int dj2 : dc) {
                            int nj1 = j1 + dj1;
                            int nj2 = j2 + dj2;
                            if (nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m)
                                max = Math.max(max, cherries + dp[i+1][nj1][nj2]);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }

        return dp[0][0][m-1];
    }
}


//======Recursive + memoization======//
/*
// Time Complexity: O(n * m^2) | Space Complexity: O(n * m^2)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for (int[][] mat : dp)
            for (int[] row : mat)
                Arrays.fill(row, -1);

        return solve(0, 0, m - 1, n, m, grid, dp);
    }

    private int solve(int row, int col1, int col2, int n, int m, int[][] grid, int[][][] dp) {
        if (row > n - 1 || col1 < 0 || col1 > m - 1 || col2 < 0 || col2 > m - 1)
            return Integer.MIN_VALUE;

        if (row == n - 1) {
            if (col1 == col2)
                return grid[row][col1];
            else
                return grid[row][col1] + grid[row][col2];
        }

          if (dp[row][col1][col2] != -1)
            return dp[row][col1][col2];

        int[] dc = { -1, 0, 1 };

        int cherries = col1 == col2 ? grid[row][col1] : grid[row][col1] + grid[row][col2];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int next = solve(row + 1, col1 + dc[i], col2 + dc[j], n, m, grid, dp);

                if (next != Integer.MIN_VALUE) {
                    max = Math.max(max, cherries + next);
                }
            }
        }

        return dp[row][col1][col2] = max;
    }
}
*/

/*
//=====Recursivce solution=====//
// Time Complexity: O(9^n) | Space Complexity: O(n)
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return solve(0, 0, m - 1, n, m, grid);
    }

    private int solve(int row, int col1, int col2, int n, int m, int[][] grid) {
        if (row > n - 1 || col1 < 0 || col1 > m - 1 || col2 < 0 || col2 > m - 1)
            return Integer.MIN_VALUE;
        if (row == n - 1) {
            if (col1 == col2)
                return grid[row][col1];
            else
                return grid[row][col1] + grid[row][col2];
        }

        int[] dc = { -1, 0, 1 };

        int max = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (col1 == col2)
                    max = Math.max(max, grid[row][col1] + solve(row + 1, col1 + dc[i], col2 + dc[j], n, m, grid));
                else
                    max = Math.max(max, grid[row][col1] + grid[row][col2] + solve(row + 1, col1 + dc[i], col2 + dc[j], n, m, grid));
            }
        }

        return max;
    }
}
*/
