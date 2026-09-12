// ===== Approach 1: Optimal — Sort by Length + 1D DP =====
// Time Complexity: O(N log N + N² × L) | Space Complexity: O(N)
class Solution {
    boolean compare(String s1, String s2) {
        if(s1.length() != s2.length() + 1) return false;
        int first = 0;
        int second = 0;

        while(first != s1.length()) {
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            }else {
                first++;
            }
        }

        if(first == s1.length() && second == s2.length()) return true;
        return false;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b)-> a.length()- b.length());

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];
        for (int i = 0; i < n; i++)
            hash[i] = i;

        int max = 1;
        for (int idx = 0; idx < n; idx++) {
            for (int prev = 0; prev < idx; prev++) {
                if (compare(words[idx], words[prev]) && 1 + dp[prev] > dp[idx]) {
                    dp[idx] = Math.max(dp[idx], 1 + dp[prev]);
                    hash[idx] = prev;
                }
            }
            if (dp[idx] > max) {
                max = dp[idx];
            }
        }

        return max;
    }
}
