//=====Space Optimization Approach=====//
// Time Complexity: O(n^2) | Space Complexity: O(n)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[] dp = matrix[0].clone();

        for (int i = 1; i < n; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                int downLeft = Integer.MAX_VALUE;
                if (j != 0)
                    downLeft = dp[j - 1];
                int down = dp[j];
                int downRight = Integer.MAX_VALUE;
                if (j != n - 1)
                    downRight = dp[j + 1];

                curr[j] = Math.min(down, Math.min(downLeft, downRight)) + matrix[i][j];
            }
            dp = curr;
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[j]);
        }

        return minSum;
    }
}

/*
//=====Tabulation Approach=====//
// Time Complexity: O(n^2) | Space Complexity: O(n^2)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0)
                    dp[i][j] = matrix[i][j];
                else {
                    int downLeft = Integer.MAX_VALUE;
                    if (j != 0)
                        downLeft = dp[i - 1][j - 1];
                    int down = dp[i - 1][j];
                    int downRight = Integer.MAX_VALUE;
                    if (j != n - 1)
                        downRight = dp[i - 1][j + 1];

                    dp[i][j] = Math.min(down, Math.min(downLeft, downRight)) + matrix[i][j];
                }
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }

        return minSum;
    }
}
*/

/*
//=====Memoization + recursive Approach=====//
// Time Complexity: O(n^2) | Space Complexity: O(n^2)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            minSum = Math.min(minSum, solve(n-1, i, n, matrix, dp));
        }

        return minSum;
    }

    private int solve(int row, int col, int n, int[][] matrix, int[][] dp) {
        if (row == 0)
            return matrix[0][col];

            if(dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int downLeft = Integer.MAX_VALUE;
        if (col != 0)
            downLeft = solve(row - 1, col - 1, n, matrix, dp);
        int down = solve(row - 1, col, n, matrix, dp);
        int downRight = Integer.MAX_VALUE;
        if (col != n - 1)
            downRight = solve(row - 1, col + 1, n, matrix, dp);

        return dp[row][col] =  Math.min(down, Math.min(downLeft, downRight)) + matrix[row][col];

    }
}
*/

/*
//=====Recursive Approach=====//
// Time Complexity: O(3^n) | Space Complexity: O(n)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            minSum = Math.min(minSum, solve(n-1, i, n, matrix));
        }

        return minSum;
    }

    private int solve(int row, int col, int n, int[][] matrix) {
        if (row == 0)
            return matrix[0][col];

        int downLeft = Integer.MAX_VALUE;
        if (col != 0)
            downLeft = solve(row - 1, col - 1, n, matrix);
        int down = solve(row - 1, col, n, matrix);
        int downRight = Integer.MAX_VALUE;
        if (col != n - 1)
            downRight = solve(row - 1, col + 1, n, matrix);

        return Math.min(down, Math.min(downLeft, downRight)) + matrix[row][col];

    }
}
*/
