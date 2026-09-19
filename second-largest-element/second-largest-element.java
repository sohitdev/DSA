// ===== Approach 1: Optimal — Single Pass =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public int getSecondLargest(int[] arr) {
       int l = -1;
       int sl = -1;
       
       for(int num: arr) {
            if(num > l){
                sl = l;
                l = num;
            }else if(num > sl && num != l) sl = num;
           
       }
       
       return sl;
        
    }
}
