import java.util.HashMap;

// ===== Approach: Optimal (Prefix Sum with HashMap) =====
// Time Complexity: O(n) or O(n log n) depending on map | Space Complexity: O(n)
class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int maxLen = 0;
        int prefixSum = 0;
        
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            
            // If prefix sum up to i is exactly k, the length is i + 1
            if (prefixSum == k) {
                maxLen = i + 1;
            }
            
            // If (prefixSum - k) is present in map, it means we have a subarray ending at i with sum k
            int rem = prefixSum - k;
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            
            // Only add prefix sum to map if it doesn't already exist.
            // This ensures we keep the earliest index to maximize the subarray length.
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        
        return maxLen;
    }
}

/*
// ===== Approach: Brute Force =====
// Time Complexity: O(n^2) | Space Complexity: O(1)
class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        
        return maxLen;
    }
}
*/
