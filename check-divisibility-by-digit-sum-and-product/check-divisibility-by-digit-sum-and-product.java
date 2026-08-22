/**
 * 3622. Check Divisibility by Digit Sum and Product
 *
 * Given a positive integer n, return true if n is divisible by the sum of
 * its digit sum and digit product, otherwise return false.
 */

class Solution {

    // -------------------------------------------------------------------------
    // Approach 1 (Active): Inline Single-Pass — compute sum and product in one loop
    // Time Complexity:  O(d) — where d is the number of digits in n
    // Space Complexity: O(1) — constant extra space
    // -------------------------------------------------------------------------

    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0, prod = 1;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            prod *= digit;
            temp /= 10;
        }

        int div = sum + prod;
        return div != 0 && n % div == 0;
    }
}

// class Solution {
//     public boolean checkDivisibility(int n) {
//        int div = getSumAndProd(n);
//
//         if ((n % div) == 0)
//             return true;
//         return false;
//     }
//
//     // Approach 2 (Helper Method): Extract digit sum+product via a separate helper
//     // Time Complexity:  O(d) — where d is the number of digits in n
//     // Space Complexity: O(1) — constant extra space
//     private int getSumAndProd(int n) {
//         int temp = n;
//         int sum = 0;
//         int prod = 1;
//         while (temp != 0) {
//             int digit = temp % 10;
//
//             sum += digit;
//             prod *= digit;
//
//             temp = temp / 10;
//         }
//
//         return sum + prod;
//     }
// }
