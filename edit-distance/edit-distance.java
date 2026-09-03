// ===== Approach 4: Optimal — Space Optimized (2 Rows) =====
// Time Complexity: O(n × m) | Space Complexity: O(m)
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        // Base case: prev row = dp[0][j] = j
        for (int j = 0; j <= m; j++)
            prev[j] = j;

        for (int i = 1; i <= n; i++) {
            curr[0] = i; // Base case: dp[i][0] = i

            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int insert  = 1 + curr[j - 1]; 
                    int delete  = 1 + prev[j];      
                    int replace = 1 + prev[j - 1];  

                    curr[j] = Math.min(insert, Math.min(delete, replace));
                }
            }

            prev = curr.clone();
        }

        return prev[m];
    }
}

/*
// ===== Approach 3: Better — Tabulation =====
// Time Complexity: O(n × m) | Space Complexity: O(n × m)
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
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
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1]; 

        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return solve(n, word1, m, word2, dp);
    }

    private int solve(int i, String word1, int j, String word2, int[][] dp) {
        if (j == 0)
            return i;
        if (i == 0)
            return j;

        if(dp[i][j] != -1) return dp[i][j];

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return dp[i][j] = solve(i - 1, word1, j - 1, word2, dp);
        } else {
            int insert = 1 + solve(i, word1, j - 1, word2, dp);
            int delete = 1 + solve(i - 1, word1, j, word2, dp);
            int replace = 1 + solve(i-1, word1, j-1, word2, dp);

            return dp[i][j] =  Math.min(insert, Math.min(delete, replace));
        }
    }
}
*/

/*
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(3^(n+m)) | Space Complexity: O(n + m) — recursion stack
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        return solve(n, word1, m, word2);
    }

    private int solve(int i, String word1, int j, String word2) {
        if (j == 0)
            return i;
        if (i == 0)
            return j;

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return solve(i - 1, word1, j - 1, word2);
        } else {
            int insert = 1 + solve(i, word1, j - 1, word2);
            int delete = 1 + solve(i - 1, word1, j, word2);
            int replace = 1 + solve(i-1, word1, j-1, word2);

            return Math.min(insert, Math.min(delete, replace));
        }
    }
}
*/
