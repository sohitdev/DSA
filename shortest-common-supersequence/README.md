# 1092. Shortest Common Supersequence

**LeetCode Problem:** [https://leetcode.com/problems/shortest-common-supersequence/](https://leetcode.com/problems/shortest-common-supersequence/)

**Difficulty:** Hard

---

## Problem Description

Given two strings `str1` and `str2`, return the shortest string that has both `str1` and `str2` as **subsequences**. If there are multiple valid strings, return **any** of them.

A string `s` is a **subsequence** of string `t` if deleting some number of characters from `t` (possibly 0) results in the string `s`.

---

## Examples

**Example 1:**

**Input:** `str1 = "abac"`, `str2 = "cab"`  
**Output:** `"cabac"`  
**Explanation:** 
- `str1 = "abac"` is a subsequence of `"cabac"` (by deleting the first `'c'`).
- `str2 = "cab"` is a subsequence of `"cabac"` (by deleting the last `"ac"`).

---

**Example 2:**

**Input:** `str1 = "aaaaaaaa"`, `str2 = "aaaaaaaa"`  
**Output:** `"aaaaaaaa"`  

---

## Approaches

---

### Approach 1: Optimal — DP Tabulation & Backtracking (Active)

**Idea:**
First, build the 2D DP table for the **Longest Common Subsequence (LCS)** of `str1` and `str2`. The length of the Shortest Common Supersequence will be `n + m - LCS(str1, str2)`. To construct the actual supersequence string, backtrack from `dp[n][m]` to `dp[0][0]`. If characters match, append the character once and move diagonally (`i--, j--`). If they differ, move in the direction of the larger DP value while appending the skipped character of the respective string. Finally, append any remaining characters from `str1` or `str2` and reverse the built string.

**Algorithm:**
1. Initialize a 2D grid `dp[n+1][m+1]` with base cases `dp[0][j] = 0` and `dp[i][0] = 0`.
2. Fill the table: if `str1[i-1] == str2[j-1]`, `dp[i][j] = 1 + dp[i-1][j-1]`; else `dp[i][j] = max(dp[i][j-1], dp[i-1][j])`.
3. Initialize a `StringBuilder str` and pointers `i = n`, `j = m`.
4. While `i > 0` and `j > 0`:
   - If `str1[i-1] == str2[j-1]`, append `str1[i-1]` to `str` and decrement both `i` and `j`.
   - Else if `dp[i-1][j] > dp[i][j-1]`, append `str1[i-1]` and decrement `i`.
   - Else, append `str2[j-1]` and decrement `j`.
5. Append remaining characters of `str1` (if `i > 0`) or `str2` (if `j > 0`).
6. Return `str.reverse().toString()`.

**Complexity:**
- **Time:** O(n × m) — Filling the `n × m` DP table takes $O(n \times m)$ time, and the backtracking loop runs in $O(n + m)$ time.
- **Space:** O(n × m) — 2D DP array of size `(n + 1) × (m + 1)`.
