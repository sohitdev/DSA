# 72. Edit Distance

**LeetCode Problem:** [https://leetcode.com/problems/edit-distance/](https://leetcode.com/problems/edit-distance/)

**Difficulty:** Medium

---

## Problem Description

Given two strings `word1` and `word2`, return the *minimum number of operations required to convert `word1` to `word2`*.

You have the following three operations permitted on a word:
- Insert a character
- Delete a character
- Replace a character

---

## Examples

**Example 1:**

**Input:** `word1 = "horse"`, `word2 = "ros"`  
**Output:** `3`  
**Explanation:**  
1. `horse` -> `rorse` (replace `'h'` with `'r'`)
2. `rorse` -> `rose` (remove `'r'`)
3. `rose` -> `ros` (remove `'e'`)

---

**Example 2:**

**Input:** `word1 = "intention"`, `word2 = "execution"`  
**Output:** `5`  
**Explanation:**  
1. `intention` -> `inention` (remove `'t'`)
2. `inention` -> `enention` (replace `'i'` with `'e'`)
3. `enention` -> `exention` (replace `'n'` with `'x'`)
4. `exention` -> `exection` (replace `'n'` with `'c'`)
5. `exection` -> `execution` (insert `'u'`)

---

## Approaches

---

### Approach 4: Optimal — Space Optimized (2 Rows) (Active)

**Idea:**  
Notice that evaluating `curr[j]` only requires values from the current row `curr[j-1]` (for insertion) and the previous row `prev[j]` (for deletion) and `prev[j-1]` (for replacement/match). We can optimize space by keeping only two 1D arrays `prev` and `curr` of size `m + 1`.

**Algorithm:**
1. Initialize `prev` array of size `m + 1` where `prev[j] = j` (converting empty string to `word2[0...j-1]`).
2. Loop `i` from 1 to `n`:
   - Set `curr[0] = i` (converting `word1[0...i-1]` to empty string requires `i` deletions).
   - Loop `j` from 1 to `m`:
     - If `word1[i-1] == word2[j-1]`, `curr[j] = prev[j-1]`.
     - Else, `curr[j] = 1 + min(curr[j-1] (insert), prev[j] (delete), prev[j-1] (replace))`.
   - Update `prev = curr.clone()`.
3. Return `prev[m]`.

**Complexity:**
- **Time:** O(n × m) — Two nested loops of lengths `n` and `m`.
- **Space:** O(m) — Two 1D arrays of size `m + 1`.

---

### Approach 3: Better — Tabulation

**Idea:**  
Build a 2D DP table `dp[i][j]` representing the minimum edit distance between `word1[0...i-1]` and `word2[0...j-1]`.

**Algorithm:**
1. Create a 2D array `dp` of size `(n + 1) × (m + 1)`.
2. Initialize base cases: `dp[i][0] = i` for all `0 <= i <= n`, and `dp[0][j] = j` for all `0 <= j <= m`.
3. Loop `i` from 1 to `n` and `j` from 1 to `m`:
   - If `word1[i-1] == word2[j-1]`: `dp[i][j] = dp[i-1][j-1]`.
   - Else: `dp[i][j] = 1 + min(dp[i][j-1] (insert), dp[i-1][j] (delete), dp[i-1][j-1] (replace))`.
4. Return `dp[n][m]`.

**Complexity:**
- **Time:** O(n × m) — Filling the 2D DP table.
- **Space:** O(n × m) — 2D DP grid size `(n + 1) × (m + 1)`.

---

### Approach 2: Better — Memoization

**Idea:**  
Top-down recursion with a memoization table `dp[n+1][m+1]` initialized to `-1`.

**Algorithm:**
1. Initialize `dp` grid of size `(n + 1) × (m + 1)` filled with `-1`.
2. Call `solve(n, word1, m, word2, dp)`.
3. In `solve(i, word1, j, word2, dp)`:
   - Base cases: if `j == 0`, return `i`; if `i == 0`, return `j`.
   - If `dp[i][j] != -1`, return cached result.
   - If characters match: `dp[i][j] = solve(i-1, word1, j-1, word2, dp)`.
   - Else: `dp[i][j] = 1 + min(insert, delete, replace)`.
4. Return `dp[i][j]`.

**Complexity:**
- **Time:** O(n × m) — Each state `(i, j)` is evaluated once.
- **Space:** O(n × m) — DP grid space + recursion stack of depth O(n + m).

---

### Approach 1: Brute Force — Recursion

**Idea:**  
Recursively compute the edit distance by exploring all 3 operations (insert, delete, replace) at each step when characters don't match.

**Algorithm:**
1. Call `solve(n, word1, m, word2)`.
2. Base cases: if `j == 0`, return `i`; if `i == 0`, return `j`.
3. If `word1[i-1] == word2[j-1]`, return `solve(i-1, word1, j-1, word2)`.
4. Else, return `1 + min(solve(i, word1, j-1) (insert), solve(i-1, word1, j) (delete), solve(i-1, word1, j-1) (replace))`.

**Complexity:**
- **Time:** O(3^(n+m)) — Exponential branching factor of 3.
- **Space:** O(n + m) — Maximum recursion stack depth.
