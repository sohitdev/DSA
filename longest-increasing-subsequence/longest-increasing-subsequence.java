// ===== Approach 5: Optimal — Tabulation (1D DP Array) =====
// Time Complexity: O(n²) | Space Complexity: O(n)
class Solution {
	public int lis(int arr[]) {
		int n = arr.length;
		
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		
		int max = 0;
		for (int idx = 0; idx<n; idx++) {
			for (int prev = 0; prev <idx; prev++) {
				if (arr[idx] > arr[prev]) {
					dp[idx] = Math.max(dp[idx], 1 + dp[prev]);
				}
			}
			max = Math.max(max, dp[idx]);
		}
		return max;
	}
}

/*
// ===== Approach 4: Better — Space Optimization (1D Rolling Arrays) =====
// Time Complexity: O(n²) | Space Complexity: O(n)
class Solution {
	public int lis(int arr[]) {
		int n = arr.length;
		
		int[] next = new int[n + 1];
		
		for (int idx = n - 1; idx >= 0; idx--) {
			int[] curr = new int[n + 1];
			for (int prev_idx = idx - 1; prev_idx >= -1; prev_idx--) {
				
				int not_take = next[prev_idx + 1];
				
				int take = 0;
				if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {
					take = 1 + next[idx + 1];
				}
				
				curr[prev_idx + 1] = Math.max(not_take, take);
			}
			next = curr;
		}
		return next[0];
	}
}
*/

/*
// ===== Approach 3: Better — Tabulation (2D Array) =====
// Time Complexity: O(n²) | Space Complexity: O(n²)
class Solution {
	public int lis(int arr[]) {
		int n = arr.length;
		
		int[][] dp = new int[n + 1][n + 1];
		
		for (int idx = n - 1; idx >= 0; idx--) {
			for (int prev_idx = idx - 1; prev_idx >= -1; prev_idx--) {
				
				int not_take = dp[idx + 1][prev_idx + 1];
				
				int take = 0;
				if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {
					take = 1 + dp[idx + 1][idx + 1];
				}
				
				dp[idx][prev_idx + 1] = Math.max(not_take, take);
			}
		}
		return dp[0][0];
	}
}
*/

/*
// ===== Approach 2: Better — Memoization =====
// Time Complexity: O(n²) | Space Complexity: O(n²) — DP table + O(n) recursion stack
class Solution {
	public int lis(int arr[]) {
		int n = arr.length;
		
		int[][] dp = new int[n][n];
		for (int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		return solve(0, -1, arr, dp);
	}
	
	private int solve(int idx, int prev_idx, int[] arr, int[][] dp) {
		if (idx == arr.length)
			return 0;
		
		if (dp[idx][prev_idx + 1] != -1)
			return dp[idx][prev_idx + 1];
		
		int not_take = solve(idx + 1, prev_idx, arr, dp);
		
		int take = 0;
		if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {
			take = 1 + solve(idx + 1, idx, arr, dp);
		}
		
		return dp[idx][prev_idx + 1] = Math.max(take, not_take);
	}
}
*/

/*
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(2^n) | Space Complexity: O(n) — recursion stack
class Solution {
	public int lis(int arr[]) {
		// code here
		return solve(0, -1, arr);
	}
	
	private int solve(int idx, int prev_idx, int[] arr) {
		if (idx == arr.length)
			return 0;
		
		int not_take = solve(idx + 1, prev_idx, arr);
		
		int take = 0;
		if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {
			take = 1 + solve(idx + 1, idx, arr);
		}
		
		return Math.max(take, not_take);
	}
}
*/
