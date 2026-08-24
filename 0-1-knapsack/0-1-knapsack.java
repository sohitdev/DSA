//=====Spaec optimization=====//
// ===== Approach 3: Optimal — Space Optimization =====
// Time Complexity: O(n * W) | Space Complexity: O(W)
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[] prev = new int[W + 1];

        // base case
        for (int w = 0; w <= W; w++) {
            if (wt[0] <= w)
                prev[w] = val[0];
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                int skip = prev[w];

                int take = Integer.MIN_VALUE;
                if (wt[i] <= w)
                    take = val[i] + prev[w - wt[i]];

                curr[w] = Math.max(skip, take);
            }
            prev = curr;
        }

        return prev[W];
    }
}
/*
// =====Tabualtion=====//
// ===== Approach 2: Better — Tabulation =====
// Time Complexity: O(n * W) | Space Complexity: O(n * W)
class Solution {
	public int knapsack(int W, int val[], int wt[]) {
		// code here
		int n = val.length;
		int dp[][] = new int[n][W + 1];
		
		for (int w = 0; w <= W; w++) {
			if (wt[0] <= w)
				dp[0][w] = val[0];
			else
				dp[0][w] = 0;
		}
		
		for (int i = 1; i<n; i++) {
			for (int w = 0; w <= W; w++) {
				int skip = dp[i - 1][w];
				
				int take = Integer.MIN_VALUE;
				if (wt[i] <= w) {
					take = val[i] + dp[i - 1][w-wt[i]];
				}
				
				dp[i][w] = Math.max(skip, take);
			}
		}
		
		return dp[n-1][W];
	}
}
*/

/*
// ======Recursion=====//
// ===== Approach 1: Brute Force — Recursion =====
// Time Complexity: O(2^n) | Space Complexity: O(n) — recursion stack
class Solution {
	public int knapsack(int W, int val[], int wt[]) {
		// code here
		
		int dp =
		
		int n = val.length;
		return solve(n - 1, W, val, wt);
	}
	
	private int solve(int idx, int W, int val[], int wt[]) {
		if (idx == 0) {
			if (wt[0] <= W)
				return val[0];
			else
				return 0;
		}
		
		int skip = solve(idx - 1, W, val, wt);
		
		int take = Integer.MIN_VALUE;
		if (wt[idx] <= W)
			take = val[idx] + solve(idx - 1, W - wt[idx], val, wt);
		
		return Math.max(take, skip);
	}
}
*/
