// ===== Approach 1: Optimal — Adjacent Swap (Bubble Sort) =====
// Time Complexity: O(n^2) | Space Complexity: O(1)

class Solution {
    public void bubbleSort(int[] arr) {
        // code here
        int n = arr.length;
        
        
        for(int i=0;i<n-1;i++) {
            for(int j=1;j<n-i;j++) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j]  = temp;
                }
            }
        }
    }
}
