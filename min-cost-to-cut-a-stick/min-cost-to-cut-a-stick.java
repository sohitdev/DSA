// ===== Approach 1: Optimal — DP + Memoization =====
// Time Complexity: O(c^3) | Space Complexity: O(c^2)

import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] cost = new int[c + 2];
        cost[0] = 0;
        cost[c + 1] = n;
        for (int i = 0; i < c; i++) {
            cost[i + 1] = cuts[i];
        }
        Arrays.sort(cost);
        int[][] dp = new int[c + 2][c + 2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(1, c, cost, dp);
    }
    private int solve(int i, int j, int[] cost, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int min_cost = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cur = cost[j + 1] - cost[i - 1] + solve(i, k - 1, cost, dp) + solve(k + 1, j, cost, dp);
            min_cost = Math.min(cur, min_cost);
        }
        return dp[i][j] = min_cost;
    }
}

/*
//===== Recursive solution =====
class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] cost = new int[c + 2];
        cost[0] = 0;
        cost[c + 1] = n;
        for (int i = 0; i < cuts.length; i++) {
            cost[i + 1] = cuts[i];
        }
        Arrays.sort(cost);
        return solve(1, c, cost);
    }
    private int solve(int i, int j, int[] cost) {
        if (i > j) return 0;
        int min_cost = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cal = cost[j + 1] - cost[i - 1] + solve(i, k - 1, cost) + solve(k + 1, j, cost);
            min_cost = Math.min(cal, min_cost);
        }
        return min_cost;
    }
}
*/
