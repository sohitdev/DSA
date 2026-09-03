# 44. Wildcard Matching

**LeetCode Problem:** [https://leetcode.com/problems/wildcard-matching/](https://leetcode.com/problems/wildcard-matching/)

**Difficulty:** Hard

---

## Problem Description

Given an input string (`s`) and a pattern (`p`), implement wildcard pattern matching with support for `'?'` and `'*'` where:
- `'?'` Matches any single character.
- `'*'` Matches any sequence of characters (including the empty sequence).

The matching should cover the **entire** input string (not partial).

---

## Examples

**Example 1:**

**Input:** `s = "aa"`, `p = "a"`  
**Output:** `false`  
**Explanation:** `"a"` does not match the entire string `"aa"`.

---

**Example 2:**

**Input:** `s = "aa"`, `p = "*"`  
**Output:** `true`  
**Explanation:** `'*'` matches any sequence of characters.

---

**Example 3:**

**Input:** `s = "cb"`, `p = "?a"`  
**Output:** `false`  
**Explanation:** `'?'` matches `'c'`, but the second letter is `'a'`, which does not match `'b'`.

---

## Approaches

---

### Approach 3: Optimal — Tabulation (Active)

**Idea:**  
Build a 2D DP table `dp[i][j]` of size `(n+1) × (m+1)` where `dp[i][j]` represents whether `s[0...i-1]` matches `p[0...j-1]`. Base cases: `dp[0][0] = true`, and for `dp[0][j]`, it is `true` if `p[j-1] == '*'` and `dp[0][j-1]` was `true`. If `p[j-1] == '*'`, it can match empty string (`dp[i][j-1]`) or match current character (`dp[i-1][j]`).

**Algorithm:**
1. Create `boolean[][] dp = new boolean[n+1][m+1]`.
2. Set `dp[0][0] = true`.
3. Fill row 0 for prefix of `*` characters in pattern: if `p.charAt(j-1) == '*'`, `dp[0][j] = dp[0][j-1]`.
4. Loop `i` from 1 to `n` and `j` from 1 to `m`:
   - If `p[j-1] == s[i-1]` or `p[j-1] == '?'`, `dp[i][j] = dp[i-1][j-1]`.
   - Else if `p[j-1] == '*'`, `dp[i][j] = dp[i][j-1] || dp[i-1][j]`.
   - Else `dp[i][j] = false`.
5. Return `dp[n][m]`.

**Complexity:**
- **Time:** O(n × m) — Filling the 2D DP grid of size `(n+1) × (m+1)`.
- **Space:** O(n × m) — 2D DP grid storage.

---

### Approach 2: Better — Memoization

**Idea:**  
Top-down recursive solution caching state outcomes in a `Boolean[][] dp` table.

**Algorithm:**
1. Initialize `Boolean[][] dp = new Boolean[n+1][m+1]`.
2. Call `solve(n, s, m, p, dp)`.
3. In `solve(i, s, j, p, dp)`:
   - Base cases: if `i == 0 && j == 0`, return `true`; if `j == 0 && i > 0`, return `false`; if `i == 0 && j > 0`, return `true` only if all remaining characters in pattern `p` are `'*'`.
   - If `dp[i][j] != null`, return cached result.
   - If `p[j-1] == s[i-1]` or `p[j-1] == '?'`, return `dp[i][j] = solve(i-1, s, j-1, p, dp)`.
   - If `p[j-1] == '*'`, return `dp[i][j] = solve(i, s, j-1, p, dp) || solve(i-1, s, j, p, dp)`.
   - Otherwise, return `dp[i][j] = false`.

**Complexity:**
- **Time:** O(n × m) — At most `(n+1) × (m+1)` states evaluated once.
- **Space:** O(n × m) — DP grid + recursion call stack depth O(n + m).

---

### Approach 1: Brute Force — Recursion

**Idea:**  
Recursively check all possible branches for matching characters, wildcard `'?'`, and sequence wildcard `'*'`.

**Algorithm:**
1. Call `solve(n, s, m, p)`.
2. Base cases: if `i == 0 && j == 0`, return `true`; if `j == 0 && i > 0`, return `false`; if `i == 0 && p[j-1] == '*'`, return `solve(i, s, j-1, p)`.
3. If `p[j-1] == s[i-1]` or `p[j-1] == '?'`, return `solve(i-1, s, j-1, p)`.
4. If `p[j-1] == '*'`, return `solve(i, s, j-1, p) || solve(i-1, s, j, p)`.
5. Return `false`.

**Complexity:**
- **Time:** O(2^(n+m)) — Exponential recursion tree when handling `'*'`.
- **Space:** O(n + m) — Recursion call stack depth.
