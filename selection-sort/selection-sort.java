// ===== Approach 1: Optimal — Find Minimum and Swap =====
// Time Complexity: O(n^2) | Space Complexity: O(1)

class Solution {
	void selectionSort(int[] arr) {
		// code here
		int n = arr.length;
		
		for (int i = 0; i<n; i++) {
			int j = i;
			int min_idx = i;
			while (j<n) {
				if (arr[j] < arr[min_idx])
					min_idx = j;
				j++;
			}
			
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
		
		return;
	}
}
