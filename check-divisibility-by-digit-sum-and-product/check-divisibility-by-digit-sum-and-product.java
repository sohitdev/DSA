// ===== Approach 1 (Active): Inline Single-Pass — compute sum and product in one loop =====
// Time Complexity: O(d) | Space Complexity: O(1)
class Solution {
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

/*
// ===== Approach 2: Helper Method — extract digit sum+product via a separate helper =====
// Time Complexity: O(d) | Space Complexity: O(1)
class Solution {
    public boolean checkDivisibility(int n) {
       int div = getSumAndProd(n);

        if ((n % div) == 0)
            return true;
        return false;
    }

    private int getSumAndProd(int n) {
        int temp = n;
        int sum = 0;
        int prod = 1;
        while (temp != 0) {
            int digit = temp % 10;

            sum += digit;
            prod *= digit;

            temp = temp / 10;
        }

        return sum + prod;
    }
}
*/
