// =====Tabulation=====//
// Time Complexity: O(n * target) | Space Complexity: O(n * target)
class Solution {
	static int perfectSum(int[] arr, int target) {
		// code here
		int n = arr.length;
		int[][] dp = new int[n][target + 1];
		
		for (int i = 0; i<n; i++) {
			dp[i][0] = 1;
			
		}
		
		if (arr[0] == 0)
			dp[0][0] = 2; // take or skip the zero
		else if (arr[0] <= target)
			dp[0][arr[0]] = 1;
		
		for (int i = 1; i<n; i++) {
			for (int s = 0; s <= target; s++) {
				int skip = dp[i - 1][s];
				int take = 0;
				if (arr[i] <= s)
					take = dp[i - 1][s - arr[i]];
				
				dp[i][s] = take + skip;
			}
		}
		return dp[n - 1][target];
	}
}

/*
 /= == == Memoization == == = //
// Time Complexity: O(n * target) | Space Complexity: O(n * target)
class Solution {
	static int perfectSum(int[] arr, int target) {
		// code here
		int n = arr.length;
		int[][] dp = new int[n][target + 1];
		for (int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		return solve(arr, target, n - 1, dp);
	}
	private static int solve(int[] arr, int sum, int idx, int[][] dp) {
		if (idx < 0) {
			return sum == 0 ? 1 : 0;
		}
		if (dp[idx][sum] != -1)
			return dp[idx][sum];
		
		int skip = solve(arr, sum, idx - 1, dp);
		int take = 0;
		if (arr[idx] <= sum)
			take = solve(arr, sum - arr[idx], idx - 1, dp);
		
		return dp[idx][sum] = skip + take;
	}
}
*/

/*
// =====Recursive Approach=====//
// Time Complexity: O(2^n) | Space Complexity: O(n)
class Solution {
	static int perfectSum(int[] arr, int target) {
		// code here
		int n = arr.length;
		
		return solve(arr, target, n - 1);
	}
	private static int solve(int[] arr, int sum, int idx) {
		if (sum == 0)
			return 1;
		if (idx == 0) {
			if (arr[idx] == sum)
				return 1;
			return 0;
		}
		
		int skip = solve(arr, sum, idx - 1);
		int take = 0;
		if (arr[idx] <= sum)
			take = solve(arr, sum - arr[idx], idx - 1);
		
		return skip + take;
	}
}
*/
