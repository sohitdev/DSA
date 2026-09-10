// ===== Approach 3: Optimal — Tabulation =====
// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        // Base case:
        // dp[n][0] = dp[n][1] = 0
        // dp[n + 1][0] = dp[n + 1][1] = 0

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {

                if (buy == 1) {
                    int take = -prices[i] + dp[i + 1][0];
                    int skip = dp[i + 1][1];

                    dp[i][buy] = Math.max(take, skip);

                } else {
                    int sell = prices[i] + dp[i + 2][1];
                    int skip = dp[i + 1][0];

                    dp[i][buy] = Math.max(sell, skip);
                }
            }
        }

        return dp[0][1];
    }
}

/*
// ===== Approach 2: Better — Memoization =====
// Time Complexity: O(n) | Space Complexity: O(n) — DP table + O(n) recursion stack
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, prices, 1, dp);
    }

    private int solve(int i, int prices[], int buy, int[][] dp) {
        if (i >= prices.length)
            return 0;

        if(dp[i][buy] != -1) return dp[i][buy];


        if (buy == 1) {
            int take = -prices[i] + solve(i + 1, prices, 0, dp);
            int skip = solve(i + 1, prices, 1, dp);
            return dp[i][buy] = Math.max(take, skip);
        } else {
            int sell = prices[i] + solve(i + 2, prices, 1, dp);
            int skip = solve(i + 1, prices, 0, dp);
            return dp[i][buy] = Math.max(sell, skip);
        }
    }
}
*/

/*
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(2^n) | Space Complexity: O(n) — recursion stack
class Solution {
    public int maxProfit(int[] prices) {

        return solve(0, prices, 1);
    }

    private int solve(int i, int prices[], int buy) {
        if (i == prices.length)
            return 0;

        if (buy == 1) {
            int take = -prices[i] + solve(i + 1, prices, 0);
            int skip = solve(i + 1, prices, 1);
            return Math.max(take, skip);
        } else {
            int sell = prices[i] + solve(i + 2, prices, 1);
            int skip = solve(i + 1, prices, 0);
            return Math.max(sell, skip);
        }
    }
}
*/
