// ===== Approach: Optimal (In-place swap and reverse) =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    private void reverse(int i, int j, int[] nums) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        // Step 1: Find the break point
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]){
                idx = i;
                break;
            }
        }

        // If no break point, the array is entirely in descending order.
        // Thus, the next permutation is the array sorted in ascending order.
        if (idx == -1) {
            reverse(0, n - 1, nums);
        } else {
            // Step 2: Find the smallest element on the right side of the break point
            // that is strictly greater than nums[idx]
            for (int i = n - 1; i >= idx; i--) {
                if (nums[i] > nums[idx]) {
                    // Step 3: Swap these two elements
                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;

                    // Step 4: Reverse the right half
                    reverse(idx + 1, n - 1, nums);
                    break;
                }
            }
        }
    }
}
