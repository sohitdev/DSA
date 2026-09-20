// ===== Approach 2: Optimal — Math (Sum Formula) =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected_sum = n * (n+1) /2;

        int actual_sum = 0;
        for(int num : nums)
            actual_sum += num;

        return (expected_sum - actual_sum);
    }
}

/*
// ===== Approach 1: Brute Force — Using Set =====
// Time Complexity: O(n log n) | Space Complexity: O(n)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int k = 0;
        for (int i : set) {
            if (i != k) {
                return k;
            }
            k++;
        }

        return n;
    }
}
*/
