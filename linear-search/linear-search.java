// ===== Approach 1: Optimal — Linear Scan =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int search(int arr[], int x) {
        for(int i= 0;i<arr.length;i++) {
            if(arr[i] == x){
                return i;
            }
            
        }
        
        return -1;
    }
}
