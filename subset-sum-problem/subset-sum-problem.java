//=====Tabulation=====//
// Time Complexity: O(n * sum) | Space Complexity: O(n * sum)
class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum + 1];

        // sum == 0 is always achievable (take nothing)
        for(int i = 0; i < n; i++) dp[i][0] = true;

        // first element: only achievable if arr[0] <= sum
        if(arr[0] <= sum) dp[0][arr[0]] = true;

        for(int idx = 1; idx < n; idx++) {
            for(int s = 1; s <= sum; s++) {
                boolean skip = dp[idx-1][s];
                boolean take = s >= arr[idx] ? dp[idx-1][s - arr[idx]] : false;
                dp[idx][s] = take || skip;
            }
        }

        return dp[n-1][sum];
    }
}

/*
//=====Memoizaton=====//
// Time Complexity: O(n * sum) | Space Complexity: O(n * sum)
class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        Boolean[][] dp = new Boolean[arr.length][sum+1];
        return solve(arr.length-1, sum, arr, dp);
    }
    private static boolean solve(int idx, int sum, int[] arr, Boolean[][] dp) {
        if(sum < 0) return false;
        if(sum == 0) return true;
        if(idx < 0) return false;
        
        if(dp[idx][sum] != null) return dp[idx][sum];
        
        //take
        boolean take = solve(idx-1, sum - arr[idx], arr, dp);
        
        //not Take
        boolean skip = solve(idx-1, sum , arr, dp);
        
        return dp[idx][sum] = skip || take;
    }
}
*/

/*
//=====RecursionApproach=====//
// Time Complexity: O(2^n) | Space Complexity: O(n)
class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        return solve(arr.length-1, sum, arr);
    }
    private static boolean solve(int idx, int sum, int[] arr) {
        if(sum < 0) return false;
        if(sum == 0) return true;
        if(idx < 0) return false;
        
        //take
        if(solve(idx-1, sum - arr[idx], arr)) return true;
        
        //not Take
        return solve(idx-1, sum , arr);
    }
}*/
