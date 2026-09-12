// ===== Approach 1: Optimal — Sort + DP with Backtracking Hash Array =====
// Time Complexity: O(n²) | Space Complexity: O(n)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        for (int i = 0; i < n; i++)
            hash[i] = i;

        int max = 1;
        int last_idx = 0;
        for (int idx = 0; idx < n; idx++) {
            for (int prev = 0; prev < idx; prev++) {
                if (nums[idx] % nums[prev] == 0 && 1 + dp[prev] > dp[idx]) {
                    dp[idx] = Math.max(dp[idx], 1 + dp[prev]);
                    hash[idx] = prev;
                }
            }
            if (dp[idx] > max) {
                max = dp[idx];
                last_idx = idx;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (hash[last_idx] != last_idx) {
            list.add(nums[last_idx]);
            last_idx = hash[last_idx];
        }
        list.add(nums[last_idx]);
        Collections.reverse(list);
        return list;
    }
}
