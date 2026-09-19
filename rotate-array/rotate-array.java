// ===== Approach 2: Optimal — Array Reversal =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        rotateArray(0, n - k - 1, nums);
        rotateArray(n-k, n - 1, nums);
        rotateArray(0, n - 1, nums);
    }

    private void rotateArray(int i, int j, int[] nums) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

/*
// ===== Approach 1: Brute Force — Extra Array =====
// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
         k = k % n;

        int[] temp = new int[n]; 

        for(int i=0;i<n;i++){
            temp[(i+k)%n] = nums[i];
        }
        

        for(int i=0;i<n;i++) {
            nums[i] = temp[i];
        }
    }
}
*/
