// ===== Approach 4: Optimal — Space Optimized (1D Array) =====
// Time Complexity: O(n × m) | Space Complexity: O(m)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m+1];

        //base cases
        for (int idx2 = 0; idx2 <= m; idx2++)
            prev[idx2] = 0;

        for (int idx1 = 1; idx1 <= n; idx1++) {
            int[] curr = new int[m+1];
            for (int idx2 = 1; idx2 <= m; idx2++) {
                if (text1.charAt(idx1-1) == text2.charAt(idx2-1))
                   curr[idx2] = 1 + prev[idx2 - 1];
                else
                    curr[idx2] = Math.max(prev[idx2], curr[idx2 - 1]);
            }
            prev = curr;
        }

        return prev[m];
    }
}

/*
// ===== Approach 3: Better — Tabulation =====
// Time Complexity: O(n × m) | Space Complexity: O(n × m)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];

        //base cases
        for (int idx2 = 0; idx2 <= m; idx2++)
            dp[0][idx2] = 0;
        for (int idx1 = 0; idx1 <= n; idx1++)
            dp[idx1][0] = 0;

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= m; idx2++) {
                if (text1.charAt(idx1-1) == text2.charAt(idx2-1))
                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                else
                    dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);
            }
        }

        return dp[n][m];
    }
}
*/

/*
// ===== Approach 2: Better — Memoization =====
// Time Complexity: O(n × m) | Space Complexity: O(n × m) — DP table + O(n + m) recursion stack
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();

        int[][] dp = new int[l1][l2];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return solve(l1 - 1, text1, l2 - 1, text2, dp);
    }

    private int solve(int idx1, String text1, int idx2, String text2, int[][] dp) {
        if(idx1 < 0 || idx2 < 0) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];


        if(text1.charAt(idx1) == text2.charAt(idx2)) return dp[idx1][idx2] =  1 + solve(idx1-1, text1, idx2-1, text2, dp);
        else return dp[idx1][idx2] = Math.max(solve(idx1-1, text1, idx2, text2, dp), solve(idx1, text1, idx2-1, text2, dp));
    }
}
*/

/*
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(2^(n+m)) | Space Complexity: O(n + m) — recursion stack
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        return solve(text1.length() - 1, text1, text2.length() - 1, text2);
    }

    private int solve(int idx1, String text1, int idx2, String text2) {
        if(idx1 < 0 || idx2 < 0) return 0;


        if(text1.charAt(idx1) == text2.charAt(idx2)) return 1 + solve(idx1-1, text1, idx2-1, text2);
        else return Math.max(solve(idx1-1, text1, idx2, text2), solve(idx1, text1, idx2-1, text2));
    }
}
*/
