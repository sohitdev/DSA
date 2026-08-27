# 1143. Longest Common Subsequence

**LeetCode Problem:** [https://leetcode.com/problems/longest-common-subsequence/](https://leetcode.com/problems/longest-common-subsequence/)

**Difficulty:** Medium

---

## Problem Description

Given two strings `text1` and `text2`, return the length of their longest common subsequence. If there is no common subsequence, return `0`.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

---

## Examples

**Example 1:**

**Input:** `text1 = "abcde"`, `text2 = "ace"`
**Output:** `3`
**Explanation:** The longest common subsequence is `"ace"` and its length is `3`.

---

**Example 2:**

**Input:** `text1 = "abc"`, `text2 = "abc"`
**Output:** `3`
**Explanation:** The longest common subsequence is `"abc"` and its length is `3`.

---

## Approaches

---

### Approach 4: Optimal — Space Optimized (1D Array) (Active)

**Idea:**
To calculate `curr[idx2]`, we only need the value from the previous row at `idx2` (`prev[idx2]`) and `idx2-1` (`prev[idx2-1]`). Therefore, we can optimize space by keeping only two rows: `prev` and `curr` arrays of size `m + 1`.

**Algorithm:**
1. Create `prev` array of size `m + 1` initialized to `0`.
2. Loop `idx1` from 1 to `n`:
   - Create `curr` array of size `m + 1`.
   - Loop `idx2` from 1 to `m`:
     - If `text1.charAt(idx1 - 1) == text2.charAt(idx2 - 1)`, set `curr[idx2] = 1 + prev[idx2 - 1]`.
     - Otherwise, set `curr[idx2] = max(prev[idx2], curr[idx2 - 1])`.
   - Set `prev = curr`.
3. Return `prev[m]`.

**Complexity:**
- **Time:** O(n × m) — Two nested loops iterating over the lengths of both strings.
- **Space:** O(m) — Single 1D array of size `m + 1`.

---

### Approach 3: Better — Tabulation

**Idea:**
A 2D DP grid `dp[n+1][m+1]` where `dp[idx1][idx2]` stores the LCS of `text1[0...idx1-1]` and `text2[0...idx2-1]`.

**Algorithm:**
1. Create a 2D DP table `dp` of size `(n + 1) x (m + 1)`.
2. Initialize base cases: `dp[0][idx2] = 0` and `dp[idx1][0] = 0`.
3. Loop `idx1` from 1 to `n`:
   - Loop `idx2` from 1 to `m`:
     - If characters match, `dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1]`.
     - If characters don't match, `dp[idx1][idx2] = max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1])`.
4. Return `dp[n][m]`.

**Complexity:**
- **Time:** O(n × m) — Filling the 2D DP table.
- **Space:** O(n × m) — 2D DP table size.

---

### Approach 2: Better — Memoization

**Idea:**
Top-down memoization where we start matching from the end of the strings. We use a 2D array `dp` of size `l1 x l2` initialized to `-1` to cache intermediate states.

**Algorithm:**
1. Create `dp` grid initialized with `-1`.
2. Call `solve(l1 - 1, text1, l2 - 1, text2, dp)`.
3. In `solve(idx1, text1, idx2, text2, dp)`:
   - Base case: if `idx1 < 0` or `idx2 < 0`, return `0`.
   - If `dp[idx1][idx2] != -1`, return cached result.
   - If characters match, return `dp[idx1][idx2] = 1 + solve(idx1 - 1, text1, idx2 - 1, text2, dp)`.
   - If characters don't match, return `dp[idx1][idx2] = max(solve(idx1 - 1, text1, idx2, text2, dp), solve(idx1, text1, idx2 - 1, text2, dp))`.

**Complexity:**
- **Time:** O(n × m) — Each state is computed at most once.
- **Space:** O(n × m) — DP array space + recursion stack O(n + m).

---

### Approach 1: Brute Force — Recursion

**Idea:**
Recursively try all combinations of characters from both strings to find the length of the longest common subsequence.

**Algorithm:**
1. Call `solve(l1 - 1, text1, l2 - 1, text2)`.
2. In `solve(idx1, text1, idx2, text2)`:
   - If `idx1 < 0` or `idx2 < 0`, return `0`.
   - If `text1[idx1] == text2[idx2]`, return `1 + solve(idx1-1, text1, idx2-1, text2)`.
   - Otherwise, return `max(solve(idx1-1, text1, idx2, text2), solve(idx1, text1, idx2-1, text2))`.

**Complexity:**
- **Time:** O(2^(n + m)) — Exponential search space.
- **Space:** O(n + m) — Maximum depth of the recursion tree.
