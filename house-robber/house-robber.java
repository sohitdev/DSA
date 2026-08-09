//===== Space-Optimized Dynamic Programming =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int prev2 = 0;
        int prev1 = nums[0];

        for(int i=1;i<n;i++) {
            int take = nums[i] ;
            if(i > 1) take += prev2;
            int skip = prev1; 
            
            int curr = Math.max(take, skip);
            
            prev2 = prev1;
            prev1 = curr;
        }
       
       return prev1;
    }
}

/*
//======Tabulation=====//
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[0] = nums[0];

        for(int i=1;i<n;i++) {

            int take = nums[i];
            if(i > 1) take += dp[i-2];
            int skip = dp[i-1];

            dp[i] = Math.max(take, skip);
        }
       
       return dp[n-1];
    }
}
*/

 /*
//======Memoisation======//
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
       return solve(n-1, nums, dp); 
    }

    private int solve(int idx, int[] nums, int[] dp) {
        if(idx < 0) return 0;
        if(idx == 0) return nums[0];

        if(dp[idx] != -1) return dp[idx];

        int take = nums[idx] + solve(idx-2, nums, dp);
        int skip = solve(idx-1, nums, dp);

        return dp[idx] = Math.max(take, skip);
    }
}
*/

/*
//=====Recursive=====//
class Solution {
    public int rob(int[] nums) {
       return solve(nums.lenght-1, nums); 
    }

    private int solve(int idx, int[] nums) {
        if(idx < 0) return 0;
        if(idx == 0) return nums[0];

        int take = nums[idx] + solve(idx-2, nums);
        int skip = solve(idx-1, nums);

        return Math.max(take, skip);
    }
}
*/
