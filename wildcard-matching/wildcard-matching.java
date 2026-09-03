// ===== Approach 3: Optimal — Tabulation =====
// Time Complexity: O(n × m) | Space Complexity: O(n × m)
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}

/*
// ===== Approach 2: Better — Memoization =====
// Time Complexity: O(n × m) | Space Complexity: O(n × m) — DP table + O(n + m) recursion stack
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        Boolean[][] dp = new Boolean[n+1][m+1];

        return solve(n, s, m, p, dp);
    }

    private boolean solve(int i, String s, int j, String p, Boolean[][] dp) {
        if (i == 0 && j == 0) {
            return true;
        }
        if (j == 0 && i > 0)
            return false;

        if (i == 0 && j>0){
            while(j != 0) {
                if(p.charAt(j-1) != '*') return false;
                j--;
            }
            return true;
        }
            

        if(dp[i][j] != null) return dp[i][j];


        if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
            return dp[i][j] = solve(i - 1, s, j - 1, p, dp);
        }
        if (p.charAt(j - 1) == '*') {
            return dp[i][j] = solve(i, s, j - 1, p, dp) || solve(i - 1, s, j, p, dp);
        }

        return dp[i][j] = false;
    }
}
*/

/*
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(2^(n+m)) | Space Complexity: O(n + m) — recursion stack
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        return solve(n, s, m, p);
    }

    private boolean solve(int i, String s, int j, String p) {
        if (i == 0 && j == 0) {
            return true;
        }
        if (j == 0 && i > 0)
            return false;
        if (i == 0 && p.charAt(j - 1) == '*')
            return solve(i, s, j-1, p);

        if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
            return solve(i - 1, s, j - 1, p);
        }
        if (p.charAt(j - 1) == '*') {
            return solve(i, s, j - 1, p) || solve(i - 1, s, j, p);
        }

        return false;
    }
}
*/
