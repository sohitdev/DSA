// ===== Approach 1: Optimal — Single Pass =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public static int largest(int[] arr) {
        int maxi = 0;
        for(int num : arr){
            maxi = Math.max(maxi, num);
        }
        
        return maxi;
        
    }
}
