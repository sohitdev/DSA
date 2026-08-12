//=====Space Optimization=====//
// Time Complexity: O(m * n) | Space Complexity: O(n)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        dp[0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;

                int up = Integer.MAX_VALUE;
                if (i != 0)
                   up = dp[j] + grid[i][j];
                int left = Integer.MAX_VALUE;
                if (j != 0)
                    left = dp[j - 1] + grid[i][j];

                dp[j] = Math.min(up, left);
            }
        }

        return dp[n - 1];
    }
}

/*
//=====Tabulation=====//
// Time Complexity: O(m * n) | Space Complexity: O(m * n)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;

                int up = Integer.MAX_VALUE;
                if (i != 0)
                    up = grid[i][j] + dp[i - 1][j];
                int left = Integer.MAX_VALUE;
                if (j != 0)
                    left = grid[i][j] + dp[i][j - 1];

                dp[i][j] = Math.min(up, left);
            }
        }

        return dp[m - 1][n - 1];
    }
}
*/

/*
//=====Memoization + Recurive Approach=====//
// Time Complexity: O(m * n) | Space Complexity: O(m * n)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        
        return solve(m-1, n-1, grid, dp);
    }

    private int solve (int row, int col, int[][] grid, int[][] dp) {
        if(row == 0 && col == 0) return grid[0][0];

        if(dp[row][col] != -1) return dp[row][col];

        int up = Integer.MAX_VALUE;
        if(row != 0) up = grid[row][col] + solve(row -1, col, grid, dp);
        int left = Integer.MAX_VALUE;
        if(col != 0) left = grid[row][col] + solve(row, col-1, grid, dp);

        return dp[row][col] = Math.min(up, left);
    }
} 
*/

/*
//=====Recurive Approach=====//
// Time Complexity: O(2^(m + n)) | Space Complexity: O(m + n)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        return solve(m-1, n-1, grid);
    }

    private int solve (int row, int col, int[][] grid) {
        if(row == 0 && col == 0) return grid[0][0];


        int up = Integer.MAX_VALUE;
        if(row != 0) up = grid[row][col] + solve(row -1, col, grid);
        int left = Integer.MAX_VALUE;
        if(col != 0) left = grid[row][col] + solve(row, col-1, grid);

        return Math.min(up, left);
    }
} 
*/
