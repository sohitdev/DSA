import java.util.HashMap;

// ===== Approach: Optimal (Prefix Sum with HashMap) =====
// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            // If prefix sum is exactly k, it means subarray from index 0 to i is a valid subarray
            if (sum == k) {
                count += 1;
            }

            // Check if there is a prefix sum we can subtract to get k
            int rem = sum - k;

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            // Store the current prefix sum in the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}

/*
// ===== Approach: Brute Force =====
// Time Complexity: O(n^2) | Space Complexity: O(1)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                
                if (sum == k) {
                    count += 1;
                }
            }
        }
        
        return count;
    }
}
*/
