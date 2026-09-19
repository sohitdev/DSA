// ===== Approach 2: Optimal — Two Pointers =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            } 
            j++;
        }

        return i+1;
    }
}

/*
// ===== Approach 1: Brute Force — Using Set =====
// Time Complexity: O(n log n) | Space Complexity: O(n)
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new TreeSet<>();

        for(int i=0;i<n;i++) {
            set.add(nums[i]);
        }

        int i=0;
        for(int num: set){
            nums[i++] = num;
        }

        return set.size();
    }
}
*/
