// ===== Approach 1: Optimal — Linear Scan =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_ones = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                max_ones = Math.max(max_ones, count);
            }else {
                count = 0;
            }
        }

        return max_ones;
    }
}
