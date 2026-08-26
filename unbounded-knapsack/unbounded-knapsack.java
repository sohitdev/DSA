// ===== Approach 5: Most Optimal — True 1D In-Place DP (single array) =====
// Time Complexity: O(n × capacity) | Space Complexity: O(capacity)
class Solution {
	public int knapSack(int val[], int wt[], int capacity) {
		int n = val.length;
		
		int[] prev = new int[capacity + 1];
		
		for (int w = 0; w <= capacity; w++) {
				prev[w] = (w/wt[0])*val[0];
		}
		
		for (int i = 1; i<n; i++) {
		    int[] curr = new int[capacity+1];
			for (int w = 0; w <= capacity; w++) {
				
				int skip = prev[w];
				int take = Integer.MIN_VALUE;
				if (wt[i] <= w)
					take = val[i] + prev[w - wt[i]];
				
				prev[w] = Math.max(skip, take);
			}
		}
		
		return prev[capacity];
	}
}

/*
// ===== Approach 4: Space Optimized — 1D Rolling Array (two arrays) =====
// Time Complexity: O(n × capacity) | Space Complexity: O(capacity)
class Solution {
	public int knapSack(int val[], int wt[], int capacity) {
		int n = val.length;
		
		int[] prev = new int[capacity + 1];
		
		for (int w = 0; w <= capacity; w++) {
				prev[w] = (w/wt[0])*val[0];
		}
		
		for (int i = 1; i<n; i++) {
		    int[] curr = new int[capacity+1];
			for (int w = 0; w <= capacity; w++) {
				
				int skip = prev[w];
				int take = Integer.MIN_VALUE;
				if (wt[i] <= w)
					take = val[i] + curr[w - wt[i]];
				
				curr[w] = Math.max(skip, take);
			}
			prev = curr;
		}
		
		return prev[capacity];
	}
}
*/

/*
// ===== Approach 3: Tabulation — 2D Bottom-Up DP =====
// Time Complexity: O(n × capacity) | Space Complexity: O(n × capacity)
class Solution {
	public int knapSack(int val[], int wt[], int capacity) {
		int n = val.length;
		
		int[][] dp = new int[n][capacity + 1];
		
		for (int w = 0; w <= capacity; w++) {
				dp[0][w] = (w/wt[0])*val[0];
		}
		
		for (int i = 1; i<n; i++) {
			for (int w = 0; w <= capacity; w++) {
				
				int skip = dp[i - 1][w];
				int take = Integer.MIN_VALUE;
				if (wt[i] <= w)
					take = val[i] + dp[i][w - wt[i]];
				
				dp[i][w] = Math.max(skip, take);
			}
		}
		
		return dp[n - 1][capacity];
	}
}
*/

/*
// ===== Approach 2: Memoization — Top-Down DP =====
// Time Complexity: O(n × capacity) | Space Complexity: O(n × capacity) — dp table + O(n + capacity) recursion stack
class Solution {
	public int knapSack(int val[], int wt[], int capacity) {
		int n = val.length;
		
		int[][] dp = new int[n][capacity + 1];
		for (int[] row: dp) {
			Arrays.fill(row, Integer.MIN_VALUE);
		}
		
		return solve(n - 1, val, wt, capacity, dp);
	}
	
	private int solve(int idx, int[] val, int []wt, int capacity, int[][] dp) {
		if (idx == 0) {
			if (wt[idx] <= capacity) {
				return (capacity/wt[idx])*val[idx];
			}
			else
				return 0;
		}
		
		if (dp[idx][capacity] != Integer.MIN_VALUE)
			return dp[idx][capacity];
		
		int skip = solve(idx - 1, val, wt, capacity, dp);
		int take = Integer.MIN_VALUE;
		if (wt[idx] <= capacity)
			take = val[idx] + solve(idx, val, wt, capacity - wt[idx], dp);
		
		return dp[idx][capacity] = Math.max(take, skip);
	}
}
*/

/*
// ===== Approach 1: Brute Force — Pure Recursion =====
// Time Complexity: O(n^(capacity/min_wt)) — exponential, no memoization | Space Complexity: O(n + capacity) — recursion stack
class Solution {
	public int knapSack(int val[], int wt[], int capacity) {
		int n = val.length;
		
		return solve(n - 1, val, wt, capacity);
	}
	
	private int solve(int idx, int[] val, int []wt, int capacity) {
		if (idx == 0) {
			if (wt[idx] <= capacity) {
				return (capacity/wt[idx])*val[idx];
			}
			else
				return 0;
		}
		
		int skip = solve(idx - 1, val, wt, capacity);
		int take = Integer.MIN_VALUE;
		if (wt[idx] <= capacity)
			take = val[idx] + solve(idx, val, wt, capacity - wt[idx]);
		
		return Math.max(take, skip);
	}
}
*/
