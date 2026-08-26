// ===== Approach 4: Optimal — Space Optimized (1D Array) =====
// Time Complexity: O(N²) | Space Complexity: O(N)
class Solution {
	public int cutRod(int[] price) {
		int N = price.length;
		
		int[] prev = new int[N + 1];
		
		for (int n = 0; n <= N; n++) {
			prev[n] = price[0]*n;
		}
		
		for (int i = 1; i<N; i++) {
			for (int n = 0; n <= N; n++) {
				int skip = prev[n];
				int take = Integer.MIN_VALUE;
				if (i + 1 <= n)
					take = price[i] + prev[n - (i + 1)];
					
				prev[n] = Math.max(skip, take);
				
			}
		}
		
		return prev[N];
	}
}

/*
// ===== Approach 3: Better — Tabulation =====
// Time Complexity: O(N²) | Space Complexity: O(N²)
class Solution {
	public int cutRod(int[] price) {
		int N = price.length;
		
		int[][] dp = new int[N][N + 1];
		
		for (int n = 0; n <= N; n++) {
			dp[0][n] = price[0]*n;
		}
		
		for (int i = 1; i<N; i++) {
			for (int n = 0; n <= N; n++) {
				int skip = dp[i - 1][n];
				int take = Integer.MIN_VALUE;
				if (i + 1 <= n)
					take = price[i] + dp[i][n - (i + 1)];
					
				dp[i][n] = Math.max(skip, take);
				
			}
		}
		
		return dp[N-1][N];
	}
}
*/

/*
// ===== Approach 2: Better — Memoization =====
// Time Complexity: O(N²) | Space Complexity: O(N²) — DP table + O(N) recursion stack
class Solution {
	public int cutRod(int[] price) {
		int N = price.length;
		
		int[][] dp = new int[N][N + 1];
		for (int[] row: dp) {
			Arrays.fill(row, Integer.MIN_VALUE);
		}
		return solve(N - 1, price, N, dp);
	}
	
	private int solve(int idx, int[] price, int N, int[][] dp) {
		if (idx == 0) {
			if (idx + 1 <= N)
				return (N/(idx + 1))*price[idx];
			return 0;
		}
		if (dp[idx][N] != Integer.MIN_VALUE)
			return dp[idx][N];
		
		int skip = solve(idx - 1, price, N, dp);
		int take = Integer.MIN_VALUE;
		if (idx + 1 <= N)
			take = price[idx] + solve(idx, price, N - (idx + 1), dp);
		
		return dp[idx][N] = Math.max(take, skip);
	}
}
*/

/*
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(2^N) | Space Complexity: O(N) — recursion stack
class Solution {
	public int cutRod(int[] price) {
		int N = price.length;
		
		return solve(N - 1, price, N);
	}
	
	private int solve(int idx, int[] price, int N) {
		if (idx == 0) {
			if (idx + 1 <= N)
				return (N/(idx + 1))*price[idx]; // or N * price[0];
			return 0;
		}
		
		int skip = solve(idx - 1, price, N);
		int take = Integer.MIN_VALUE;
		if (idx + 1 <= N)
			take = price[idx] + solve(idx, price, N - (idx + 1));
		
		return Math.max(take, skip);
	}
}
*/
