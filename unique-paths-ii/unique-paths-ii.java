//===== Tabulation + Dp =====//
// Time Complexity: O(m * n) | Space Complexity: O(m * n)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        if(obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    int up = 0;
                    if (i != 0)
                        up = dp[i - 1][j];
                    int left = 0;
                    if (j != 0)
                        left = dp[i][j - 1];

                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}

/*
//=====Memoization + Recursive Approach=====//
// Time Complexity: O(m * n) | Space Complexity: O(m * n)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(m - 1, n - 1, obstacleGrid, dp);
    }

    private int solve(int row, int col, int[][] obstacleGrid, int[][] dp) {
        if (row < 0 || col < 0)
            return 0;
        if (obstacleGrid[row][col] == 1)
            return 0;

        if (row == 0 && col == 0)
            return 1;

        if (dp[row][col] != -1)
            return dp[row][col];

        int up = solve(row - 1, col, obstacleGrid, dp);
        int left = solve(row, col - 1, obstacleGrid, dp);
        return dp[row][col] = up + left;
    }
}
*/

/*
//=====Recursive Approach=====//
// Time Complexity: O(2^(m + n)) | Space Complexity: O(m + n)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        return solve(m-1, n-1, obstacleGrid);
    }

    private int solve(int row, int col, int[][] obstacleGrid ) {
        if(row < 0 || col < 0) return 0;
        if(obstacleGrid[row][col] == 1) return 0;

        if(row == 0 && col == 0) return 1;

        int up = solve(row-1, col, obstacleGrid);
        int left = solve(row, col-1, obstacleGrid);
        return up + left;
    }
}
*/
