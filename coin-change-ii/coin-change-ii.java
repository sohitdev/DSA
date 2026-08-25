//=====Space optimization=====//
// ===== Approach 4: Optimal — Space-Optimized Tabulation =====
// Time Complexity: O(n * amount) | Space Complexity: O(amount)
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0)
                prev[t] = 1;
        }

        for (int i = 1; i < n; i++) {
            int curr[] = new int[amount + 1];
            for (int t = 0; t <= amount; t++) {

                int skip = prev[t];

                int take = 0;
                if (coins[i] <= t)
                    take = curr[t - coins[i]];

                curr[t] = skip + take;
            }
            prev = curr;
        }

        return prev[amount];
    }
}

/*
//=====tabualtion=====//
// ===== Approach 3: Better — Tabulation =====
// Time Complexity: O(n * amount) | Space Complexity: O(n * amount)
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0)
                dp[0][t] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= amount; t++) {

                int skip = dp[i - 1][t];

                int take = 0;
                if (coins[i] <= t)
                    take = dp[i][t - coins[i]];

                    dp[i][t] = skip +take;
            }
        }

        return dp[n-1][amount];
    }
}
*/

/*
//=====Memoization=====//
// ===== Approach 2: Better — Memoization =====
// Time Complexity: O(n * amount) | Space Complexity: O(n * amount)
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, amount, coins, dp);
    }

    private int solve(int idx, int target, int[] coins, int[][] dp) {
        if (idx == 0) {
            if (target % coins[idx] == 0)
                return 1;
            return 0;
        }

        if (dp[idx][target] != -1)
            return dp[idx][target];

        int skip = solve(idx - 1, target, coins, dp);

        int take = 0;
        if (coins[idx] <= target)
            take = solve(idx, target - coins[idx], coins, dp);

        return dp[idx][target] = skip + take;
    }
}
*/

/*
//=====Recursice solution=====//
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(2^(n + amount)) | Space Complexity: O(n + amount)
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        return solve(n-1, amount, coins);
    }

    private int solve(int idx, int target, int[] coins) {
        if(idx == 0) {
            if(target % coins[idx] == 0) return 1;
            return 0;
        }

        int skip = solve(idx-1, target, coins);

        int take = 0;
        if(coins[idx] <= target) take = solve(idx, target - coins[idx], coins);

        return skip + take ;
    }
}
*/
