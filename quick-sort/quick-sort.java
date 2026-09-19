// ===== Approach 1: Optimal — Quick Sort =====
// Time Complexity: O(n log n) average, O(n^2) worst | Space Complexity: O(n) worst, O(log n) average
class Solution {
	public void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			
			int p = partition(arr, low, high);
			quickSort(arr, low, p - 1);
			quickSort(arr, p + 1, high);
		}
		
	}
	
	private int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = low ;
		int j = high;
		while (i < j) {
			while (i <= high-1 && arr[i] <= pivot)
				i++;
			while (j >= low+1 && arr[j] > pivot)
				j--;
			
			if (i<j) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		int temp = arr[j];
		arr[j] = arr[low];
		arr[low] = temp;
		
		return j;
	}
}
