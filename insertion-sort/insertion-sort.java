// ===== Approach 1: Optimal — Shift and Insert =====
// Time Complexity: O(n^2) | Space Complexity: O(1)

class Solution {
	// Please change the array in-place
	public void insertionSort(int arr[]) {
		int n = arr.length;
		
		for (int i = 1; i<n; i++) {
			for (int j = i; j >= 1; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				} else
				    break;
			}
		}
		
		return;
	}
}
