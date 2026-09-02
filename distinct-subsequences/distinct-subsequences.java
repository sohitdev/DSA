// ===== Approach 3: Optimal — Tabulation =====
// Time Complexity: O(n × m) | Space Complexity: O(n × m)
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        // empty t matches every prefix of s exactly once
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        // empty s can never match non-empty t
        for (int j = 1; j <= m; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][m];
    }

}

/*
// ===== Approach 2: Better — Memoization =====
// Time Complexity: O(n × m) | Space Complexity: O(n × m) — DP table + O(n) recursion stack
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int row[]: dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, s, m - 1, t, dp);
    }

    private int solve(int i, String s, int j, String t, int[][] dp) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = solve(i - 1, s, j - 1, t, dp) + solve(i - 1, s, j, t, dp);
        } else {
            dp[i][j] = solve(i - 1, s, j, t, dp);
        }

        return dp[i][j];
    }
}
*/

/*
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(2^n) | Space Complexity: O(n) — recursion stack
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        return solve(n - 1, s, m - 1, t);
    }

    private int solve(int i, String s, int j, String t) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;

        if (s.charAt(i) == t.charAt(j)) {
            return solve(i - 1, s, j - 1, t) + solve(i - 1, s, j, t);
        } else {
            return solve(i - 1, s, j, t);
        }
    }
}
*/
