# 115. Distinct Subsequences

**LeetCode Problem:** [https://leetcode.com/problems/distinct-subsequences/](https://leetcode.com/problems/distinct-subsequences/)

**Difficulty:** Hard

---

## Problem Description

Given two strings `s` and `t`, return the number of distinct **subsequences** of `s` which equals `t`.

The test cases are generated so that the answer fits in a 32-bit signed integer.

---

## Examples

**Example 1:**

**Input:** `s = "rabbbit"`, `t = "rabbit"`  
**Output:** `3`  
**Explanation:**  
There are 3 ways you can generate `"rabbit"` from `s`:
- `ra`**b**`bbit`
- `rab`**b**`it`
- `rabb`**b**`it`

---

**Example 2:**

**Input:** `s = "babgbag"`, `t = "bag"`  
**Output:** `5`  
**Explanation:**  
There are 5 ways you can generate `"bag"` from `s`:
- `ba`**b**`g`**bag**
- `ba`**b**`gbag`
- `b`**ab**`g`**bag**
- `babg`**bag**
- `bab`**gbag**

---

## Approaches

---

### Approach 3: Optimal — Tabulation (Active)

**Idea:**  
Build a 2D DP table `dp[i][j]` representing the number of distinct subsequences of `s[0...i-1]` that equal `t[0...j-1]`. An empty string `t` (`j=0`) matches any prefix of `s` in exactly 1 way (base case `dp[i][0] = 1`). If `s[i-1] == t[j-1]`, we have two options: match current characters (`dp[i-1][j-1]`) or skip character in `s` (`dp[i-1][j]`). If characters differ, we can only skip character in `s` (`dp[i-1][j]`).

**Algorithm:**
1. Create a 2D array `dp[n+1][m+1]`.
2. Base case: `dp[i][0] = 1` for `0 <= i <= n` (matching empty string `t`).
3. Base case: `dp[0][j] = 0` for `1 <= j <= m` (empty `s` cannot match non-empty `t`).
4. Loop `i` from 1 to `n` and `j` from 1 to `m`:
   - If `s.charAt(i - 1) == t.charAt(j - 1)`: `dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]`.
   - Else: `dp[i][j] = dp[i - 1][j]`.
5. Return `dp[n][m]`.

**Complexity:**
- **Time:** O(n × m) — Two nested loops iterating over string lengths `n` and `m`.
- **Space:** O(n × m) — 2D DP grid size `(n + 1) × (m + 1)`.

---

### Approach 2: Better — Memoization

**Idea:**  
Top-down recursion with memoization caching subproblem results in a 2D table `dp[n][m]`.

**Algorithm:**
1. Initialize `dp` grid of size `n × m` filled with `-1`.
2. Recursive function `solve(i, s, j, t, dp)`:
   - If `j < 0`, return `1` (entire string `t` matched).
   - If `i < 0`, return `0` (`s` exhausted before `t`).
   - If `dp[i][j] != -1`, return cached `dp[i][j]`.
   - If `s[i] == t[j]`, result is `solve(i-1, s, j-1, t, dp) + solve(i-1, s, j, t, dp)`.
   - Else, result is `solve(i-1, s, j, t, dp)`.
   - Save and return `dp[i][j]`.

**Complexity:**
- **Time:** O(n × m) — Each state `(i, j)` is calculated at most once.
- **Space:** O(n × m) — DP grid + recursion stack of depth O(n).

---

### Approach 1: Brute Force — Recursion

**Idea:**  
Explore all possibilities recursively by matching or skipping characters of `s` when they match `t`.

**Algorithm:**
1. Call `solve(n - 1, s, m - 1, t)`.
2. Base cases: if `j < 0`, return `1`; if `i < 0`, return `0`.
3. If `s[i] == t[j]`, return `solve(i - 1, s, j - 1, t) + solve(i - 1, s, j, t)`.
4. Else, return `solve(i - 1, s, j, t)`.

**Complexity:**
- **Time:** O(2^n) — Exponential search tree.
- **Space:** O(n) — Maximum recursion stack depth.
