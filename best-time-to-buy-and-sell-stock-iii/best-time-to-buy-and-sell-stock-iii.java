// ===== Approach 4: Optimal — Space Optimized (2D Array) =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] next = new int[2][3];

        for (int i = n - 1; i >= 0; i--) {
            int[][] curr = new int[2][3];
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 0; cap <= 1; cap++) {
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
// ===== Approach 3: Better — Tabulation =====
// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3]; //two option either buy or sell and 3 option cap can be 0, 1, 2;

        // for (int buy = 0; buy <= 1; buy++) {
        //     for (int cap = 0; cap <= 2; cap++) {
        //         dp[n][buy][cap] = 0;
        //     }
        // }

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 0; cap <= 1; cap++) {
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

/*
// ===== Approach 2: Better — Memoization =====
// Time Complexity: O(n) | Space Complexity: O(n) — DP table + O(n) recursion stack
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int [n][2][3]; //two option either buy or sell and 3 option cap can be 0, 1, 2;

        for (int i = 0; i < n; i++) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 0; cap < 3; cap++) {
                    dp[i][buy][cap] = -1;
                }
            }
        }

        return solve(0, prices, 1, 0, dp);
    }
    private int solve(int i, int[] prices, int buy, int cap, int[][][] dp) {
        if(i == prices.length || cap == 2){
            return 0;
        }

        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];

        if(buy == 1) {
            int take = -prices[i] + solve(i+1, prices, 0, cap, dp);
            int skip = solve(i+1, prices, 1, cap, dp);
            return dp[i][buy][cap] = Math.max(take, skip);
        }else {
            int sell = +prices[i] + solve(i+1, prices, 1, cap + 1, dp);
            int skip = solve(i+1, prices, 0, cap, dp);
            return dp[i][buy][cap] = Math.max(sell, skip);
        }
    }
}
*/

/*
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(2^n) | Space Complexity: O(n) — recursion stack
class Solution {
    public int maxProfit(int[] prices) {
        return solve(0, prices, true, 0);
    }
    private int solve(int i, int[] prices, boolean buy, int cap) {
        if(i == prices.length || cap == 2){
            return 0;
        }

        if(buy == true) {
            int take = -prices[i] + solve(i+1, prices, false, cap);
            int skip = solve(i+1, prices, true, cap);
            return Math.max(take, skip);
        }else {
            int sell = +prices[i] + solve(i+1, prices, true, cap + 1);
            int skip = solve(i+1, prices, false, cap);
            return Math.max(sell, skip);
        }
    }
}
*/
