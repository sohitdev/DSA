// ===== Approach 1: Optimal — DP (LIS Left + LIS Right) =====
// Time Complexity: O(n²) | Space Complexity: O(n)
class Solution {
	public static int longestBitonicSequence(int n, int[] nums) {
		// code here
		int[] dp1 = new int[n];
		Arrays.fill(dp1, 1);
		
		for (int i = 1; i<n; i++) {
			for (int prev = 0; prev<i; prev++) {
				if (nums[i] > nums[prev] && 1 + dp1[prev]> dp1[i]) {
					dp1[i] = 1 + dp1[prev];
				}
			}
		}
		
		int[] dp2 = new int[n];
		Arrays.fill(dp2, 1);
		
		for (int i = n - 2; i>= 0; i--) {
			for (int prev = n - 1; prev>i; prev--) {
				if (nums[i] > nums[prev] && 1 + dp2[prev] > dp2[i]) {
					dp2[i] = 1 + dp2[prev];
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i<n; i++) {
		    if (dp1[i] > 1 && dp2[i] > 1)
			max = Math.max(max, dp1[i] + dp2[i] - 1);
		}
		
		return max;
	}
}
