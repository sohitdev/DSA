// ===== tabulation =====
// Time Complexity: O(m * n) | Space Complexity: O(m * n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i == 0 && j == 0) continue;
                else {
                    int up = 0;
                    if(i != 0) up = dp[i-1][j];
                    int left = 0;
                    if(j != 0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];   
    }
}
/*
// ===== Memoization =====
// Time Complexity: O(m * n) | Space Complexity: O(m * n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m+1;i++) {
            for(int j=0;j<n+1;j++) {
                dp[i][j] = -1;
            }
        }
        return solve(m - 1, n - 1, dp);
    }

    private int solve(int row, int col, int[][] dp) {
        if (row < 0 || col < 0)
            return 0;

        if (row == 0 && col == 0)
            return 1;

        if(dp[row][col] != -1) return dp[row][col];

        int up = solve(row - 1, col, dp);
        int left = solve(row, col - 1, dp);

        return dp[row][col] = up + left;
    }
}
*/

/*
//====== Recursive solution ======
// Time Complexity: O(2^(m + n)) | Space Complexity: O(m + n)
class Solution {
    public int uniquePaths(int m, int n) {
        return solve(m-1, n-1);
    }

    private int solve(int row, int col) {
        if(row <0 || col <0) return 0;

        if(row == 0 && col == 0) {
            return 1;
        }

        int up = solve(row-1, col);
        int left = solve(row, col-1);

        return up + left;
    }
}

*/
