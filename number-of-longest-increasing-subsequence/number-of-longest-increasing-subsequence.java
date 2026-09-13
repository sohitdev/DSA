// ===== Approach 1: Optimal — DP + Count Array =====
// Time Complexity: O(n²) | Space Complexity: O(n)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] count_arr = new int[n];
        Arrays.fill(count_arr, 1);

        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    count_arr[i] = count_arr[j];
                }else if(nums[i] > nums[j] && 1 + dp[j] == dp[i]){
                    count_arr[i] += count_arr[j];
                }
            }
            max = Math.max(max, dp[i]);
        }

        int nos = 0;
        for(int i=0;i<n;i++) {
            if(max == dp[i]) nos += count_arr[i];
        }

        return nos;
    }
}
