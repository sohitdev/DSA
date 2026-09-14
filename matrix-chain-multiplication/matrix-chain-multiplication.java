// ===== Approach 3: Optimal — Tabulation =====
// Time Complexity: O(n³) | Space Complexity: O(n²)
class Solution {
	static int matrixMultiplication(int arr[]) {
		// code here
		int n = arr.length;
		
		int[][] dp = new int[n][n];
		for (int i = 0; i<n; i++) {
			dp[i][i] = 0;
		}
		
		for (int i = n - 1; i >= 1; i--) {
			for (int j = i + 1; j <= n - 1; j++) {
				int min_steps = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
					min_steps = Math.min(min_steps, steps);
				}
				dp[i][j] = min_steps;
			}
		}
		
		return dp[1][n - 1];
	}
}

/*
// ===== Approach 2: Better — Memoization =====
// Time Complexity: O(n³) | Space Complexity: O(n²) — DP table + O(n) recursion stack
class Solution {
	static int matrixMultiplication(int arr[]) {
		// code here
		int n = arr.length;
		
		int[][] dp = new int[n][n];
		return solve(1, n - 1, arr, dp);
	}
	
	private static int solve(int i, int j, int[] arr, int[][] dp) {
		if (i == j)
			return 0;
		
		if (dp[i][j] != 0)
			return dp[i][j];
		
		int min_steps = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int steps = arr[i - 1] * arr[k] * arr[j] + solve(i, k, arr, dp) + solve(k + 1, j, arr, dp) ;
			min_steps = Math.min(min_steps, steps);
		}
		
		return dp[i][j] = min_steps;
	}
}
*/

/*
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(2ⁿ) | Space Complexity: O(n) — recursion stack
class Solution {
	static int matrixMultiplication(int arr[]) {
		// code here
		int n = arr.length;
		return solve(1, n - 1, arr);
	}
	
	private static int solve(int i, int j, int[] arr) {
		if (i == j)
			return 0;
		
		int min_steps = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int steps = arr[i - 1] * arr[k] * arr[j] + solve(i, k, arr) + solve(k + 1, j, arr) ;
			min_steps = Math.min(min_steps, steps);
		}
		
		return min_steps;
	}
}
*/
