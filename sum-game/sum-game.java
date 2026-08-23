// ===== Approach 1: Optimal — Balance Half-Sum and Wildcards =====
// Time Complexity: O(n) | Space Complexity: O(1)
class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int qL = 0, qR = 0, sumL = 0, sumR = 0;

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?')
                qL++;
            else
                sumL += num.charAt(i) - '0';
        }
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?')
                qR++;
            else
                sumR += num.charAt(i) - '0';
        }

        return (qL + qR) % 2 != 0 || 2 * (sumR - sumL) != 9 * (qL - qR);
    }
}
