// ===== Approach 4: Optimal — Space Optimized (1D Array) =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] prev = new int[2];

        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    curr[buy] = Math.max(-prices[i] + prev[0], prev[1]);
                } else {
                    curr[buy] = Math.max(prices[i] + prev[1], prev[0]);
                }
            }
            prev = curr;
        }

        return prev[1];
    }
}

/*
// ===== Approach 3: Better — Tabulation =====
// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        dp[n][0] = dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[i][buy] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                } else {
                    dp[i][buy] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
                }
            }
        }

        return dp[0][1];
    }
}
*/

/*
// ===== Approach 2: Better — Memoization =====
// Time Complexity: O(n) | Space Complexity: O(n) — DP table + O(n) recursion stack
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return solve(0, prices.length, prices, 1, dp);
    }

    private int solve(int i, int n, int[] prices, int buy, int[][] dp) {
        if (i == n)
            return 0;

        if (dp[i][buy] != Integer.MIN_VALUE)
            return dp[i][buy];

            if (buy == 1) {
                int take = -prices[i] + solve(i + 1, n, prices, 0, dp);
                int skip = solve(i + 1, n, prices, 1, dp);
                return dp[i][buy] = Math.max(take, skip);
            } else {
                int sell = prices[i] + solve(i + 1, n, prices, 1, dp);
                int notSell = solve(i + 1, n, prices, 0, dp);
                return dp[i][buy] = Math.max(sell, notSell);
        }
    }
}
*/

/*
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(2^n) | Space Complexity: O(n) — recursion stack
class Solution {
    public int maxProfit(int[] prices) {
        return solve(0, prices.length, prices, true);
    }
    private int solve(int i, int n, int[] prices, boolean buy) {
        if(i == n) return 0;

        if(buy == true) {
            int take = -prices[i] + solve(i+1, n, prices, false);
            int skip = solve(i+1, n, prices, true);
            return Math.max(take, skip);
        }else {
            int sell = prices[i] + solve(i+1, n, prices, true);
            int notSell = solve(i+1, n, prices, false);
            return Math.max(sell, notSell);
        }
    }
}
*/
