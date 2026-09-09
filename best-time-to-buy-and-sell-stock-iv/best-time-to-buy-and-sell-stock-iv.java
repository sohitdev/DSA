// ===== Approach 2: Optimal — Space Optimized (2D Array) =====
// Time Complexity: O(n × k) | Space Complexity: O(k)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] next = new int[2][k+1];

        for (int i = n - 1; i >= 0; i--) {
            int[][] curr = new int[2][k+1];
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 0; cap < k; cap++) {
                    if (buy == 1) {
                        int take = -prices[i] + next[0][cap];
                        int skip = next[1][cap];
                        curr[buy][cap] = Math.max(take, skip);
                    } else {
                        int sell = +prices[i] + next[1][cap + 1];
                        int skip = next[0][cap];
                        curr[buy][cap] = Math.max(sell, skip);
                    }
                }
            }
            next = curr;
        }

        return next[1][0];

    }
}

/*
// ===== Approach 1: Better — Tabulation =====
// Time Complexity: O(n × k) | Space Complexity: O(n × k)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k+1]; //two option either buy or sell and 3 option cap can be 0, 1, 2;

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 0; cap < k; cap++) {
                    if (buy == 1) {
                        int take = -prices[i] + dp[i + 1][0][cap];
                        int skip = dp[i + 1][1][cap];
                        dp[i][buy][cap] = Math.max(take, skip);
                    } else {
                        int sell = +prices[i] + dp[i + 1][1][cap + 1];
                        int skip = dp[i + 1][0][cap];
                        dp[i][buy][cap] = Math.max(sell, skip);
                    }
                }
            }
        }

        return dp[0][1][0];
    }
}
*/
