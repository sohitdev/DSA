// ===== Approach: Optimal (Two Pointers) =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int lmax = 0;
        int rmax = 0;
        int total = 0;

        while (l < r) {
            if (height[l] <= height[r]) {
                if (lmax > height[l]) {
                    total += lmax - height[l];
                } else {
                    lmax = height[l];
                }
                l++;
            } else {
                if (rmax > height[r]) {
                    total += rmax - height[r];
                } else {
                    rmax = height[r];
                }
                r--;
            }
        }

        return total;
    }
}

/*
// ===== Approach: Better (Prefix and Suffix Max Arrays) =====
// Time Complexity: O(n) | Space Complexity: O(n)
class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] prefix = new int[n];
        prefix[0] = height[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }

        int[] suffix = new int[n]; 
        suffix[n-1] = height[n-1];
        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i+1], height[i]);
        }

        int total = 0;
        for(int i = 0; i < n; i++) {
            total += (Math.min(suffix[i], prefix[i]) - height[i]);
        }

        return total;
    }
}
*/
