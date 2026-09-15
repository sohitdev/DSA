// ===== Approach 3: Optimal — Tabulation =====
// Time Complexity: O(n^3) | Space Complexity: O(n^2)

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                int max_coins = 0;
                for (int k = i; k <= j; k++) {
                    int coins = arr[i - 1] * arr[k] * arr[j + 1] + dp[i][k - 1] + dp[k + 1][j];
                    max_coins = Math.max(max_coins, coins);
                }

               dp[i][j] = max_coins;
            }
        }

        return dp[1][n];
    }
}

/*
// ===== Approach 2: Better — Memoization =====
// Time Complexity: O(n^3) | Space Complexity: O(n^2)
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i=0;i<n;i++) {
            arr[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(1, n, arr, dp); 
    }

    private int solve(int i, int j, int[] arr, int[][] dp) {
        if(i>j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int max_coins = 0;
        for(int k = i;k<=j;k++) {
            int coins = arr[i-1] * arr[k] * arr[j+1] + solve(i, k-1, arr, dp) + solve(k+1, j, arr, dp); 
            max_coins = Math.max(max_coins, coins);
        }

        return dp[i][j] = max_coins;
    }
}*/

/*
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(n! * n) | Space Complexity: O(n)
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i=0;i<n;i++) {
            arr[i+1] = nums[i];
        }

        return solve(1, n, arr); 
    }

    private int solve(int i, int j, int[] arr) {
        if(i>j) return 0;

        int max_coins = Integer.MIN_VALUE;
        for(int k = i;k<=j;k++) {
            int coins = arr[i-1] * arr[k] * arr[j+1] + solve(i, k-1, arr) + solve(k+1, j, arr); 
            max_coins = Math.max(max_coins, coins);
        }

        return max_coins;
    }
}*/
