//=====space Optimization Approach=====//
// Time Complexity: O(n^2) | Space Complexity: O(n)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[] = new int[n];

        for(int j=0;j<n;j++) {
            dp[j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2;i >= 0 ; i--) {
            for(int j =0;j<=i;j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}

/*
//=====Tabulation Approach=====//
// Time Complexity: O(n^2) | Space Complexity: O(n^2)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int j=0;j<n;j++) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2;i >= 0 ; i--) {
            for(int j =0;j<triangle.get(i).size();j++) {
                int down = dp[i+1][j];
                int downRight = dp[i+1][j+1];

                dp[i][j] = Math.min(down, downRight) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }
}
*/

/*
//=====Memoization Approach=====//
// Time Complexity: O(n^2) | Space Complexity: O(n^2)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] row: dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return solve(0, 0, n, triangle, dp);
    }

    private int solve(int level, int idx, int n, List<List<Integer>> triangle, int[][] dp) {
        if(level == n-1)  {
            return triangle.get(level).get(idx);
        }
        if(dp[level][idx] != Integer.MIN_VALUE) return dp[level][idx];

        int curr = triangle.get(level).get(idx);

        int down = curr + solve(level+1, idx, n, triangle, dp);
        int downRight = curr + solve(level+1, idx+1, n, triangle, dp);

        return dp[level][idx] =  Math.min(down, downRight);
    }
}
*/

/*
//=====Recursive Approach=====//
// Time Complexity: O(2^n) | Space Complexity: O(n)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        return solve(0, 0, n, triangle);
    }

    private int solve(int level, int idx, int n, List<List<Integer>> triangle) {
        if(level == n-1)  {
            return triangle.get(level).get(idx);
        }

        int curr = triangle.get(level).get(idx);

        int down = curr + solve(level+1, idx, n, triangle);
        int downRight = curr + solve(level+1, idx+1, n, triangle);

        return Math.min(down, downRight);
    }
}
*/
