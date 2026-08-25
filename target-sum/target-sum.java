

// ===== Approach 2: Better — Memoization =====
// Time Complexity: O(n * sum) | Space Complexity: O(n * sum)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        int rem = sum - target;
        if (rem < 0 || rem % 2 != 0)
            return 0;

        int newTarget = rem / 2;
        int dp[][] = new int[nums.length][newTarget+1];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums.length - 1, nums, newTarget, dp);
    }

    private int solve(int idx, int[] nums, int target, int[][] dp) {
        if (idx == 0) {
            if (nums[0] == 0 && target == 0)
                return 2;
            if (nums[0] == target)
                return 1; // take it
            if (target == 0)
                return 1; // don't take it
            return 0;
        }
        if(dp[idx][target] != -1) return dp[idx][target];

        int skip = solve(idx - 1, nums, target, dp);

        int take = 0;
        if (nums[idx] <= target)
            take = solve(idx - 1, nums, target - nums[idx], dp);

        return dp[idx][target] = skip + take;
    }
}

/*
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(2^n) | Space Complexity: O(n)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        int rem = sum - target;
        if (rem < 0 || rem % 2 != 0)
            return 0;

        int newTarget = rem / 2;
        return solve(nums.length - 1, nums, newTarget);
    }

    private int solve(int idx, int[] nums, int target) {
        if (idx == 0) {
            if (nums[0] == 0 && target == 0)
                return 2;
            if (nums[0] == target)
                return 1; // take it
            if (target == 0)
                return 1; // don't take it
            return 0;
        }

        int skip = solve(idx - 1, nums, target);

        int take = 0;
        if (nums[idx] <= target)
            take = solve(idx - 1, nums, target - nums[idx]);

        return skip + take;
    }
}
*/
