import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// ===== Approach: Optimal (HashSet) =====
// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        Set<Integer> set = new HashSet<>();

        // Add all elements to the set
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int currLen = 0;
        int maxLen = 0;

        // Find the start of each sequence and count the length
        for (int num : set) {
            // Only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int last = num;
                currLen = 1;
                while (set.contains(last + 1)) {
                    currLen += 1;
                    last = last + 1;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }
}

/*
// ===== Approach: Better (Sorting) =====
// Time Complexity: O(n log n) | Space Complexity: O(1) or O(n) depending on sorting
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);

        int n = nums.length;
        int currLen = 0;
        int maxLen = 0;
        int last = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(nums[i] - 1 == last) {
                currLen += 1;
                last = nums[i];
                maxLen = Math.max(maxLen, currLen);
            } else if (last == nums[i]) {
                continue;
            } else {
                currLen = 1;
                last = nums[i];
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }
}
*/
