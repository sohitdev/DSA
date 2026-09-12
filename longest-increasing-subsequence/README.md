# 300. Longest Increasing Subsequence

**LeetCode Problem:** [https://leetcode.com/problems/longest-increasing-subsequence/](https://leetcode.com/problems/longest-increasing-subsequence/)

**Difficulty:** Medium

---

## Problem Description

Given an integer array `nums` (or `arr`), return the length of the longest **strictly increasing subsequence**.

A **subsequence** is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

---

## Examples

**Example 1:**

**Input:** `nums = [10,9,2,5,3,7,101,18]`  
**Output:** `4`  
**Explanation:** The longest increasing subsequence is `[2, 3, 7, 101]`, therefore the length is `4`.

---

**Example 2:**

**Input:** `nums = [0,1,0,3,2,3]`  
**Output:** `4`

---

**Example 3:**

**Input:** `nums = [7,7,7,7,7,7,7]`  
**Output:** `1`

---

## Approaches

---

### Approach 5: Optimal — Tabulation (1D DP Array) (Active)

**Idea:**  
Let `dp[i]` store the length of the longest increasing subsequence ending at index `i`. For each index `idx` from `0` to `n-1`, check all previous indices `prev` (`0` to `idx-1`). If `arr[idx] > arr[prev]`, then `dp[idx] = max(dp[idx], 1 + dp[prev])`. The maximum value in `dp` array is the length of the overall LIS.

**Algorithm:**
1. Create `int[] dp = new int[n]` and initialize all elements to `1` (each element is an LIS of length 1 by itself).
2. Loop `idx` from `0` to `n-1`:
   - Loop `prev` from `0` to `idx-1`:
     - If `arr[idx] > arr[prev]`, update `dp[idx] = Math.max(dp[idx], 1 + dp[prev])`.
   - Update `max = Math.max(max, dp[idx])`.
3. Return `max`.

**Complexity:**
- **Time:** O(n²) — Two nested loops.
- **Space:** O(n) — 1D DP array of size `n`.

---

### Approach 4: Better — Space Optimization (1D Rolling Arrays)

**Idea:**  
Optimize space of 2D DP table down to two 1D arrays `next` and `curr` of size `n + 1` by tracking values from the next index. Coordinate shift `prev_idx + 1` handles index `-1`.

**Algorithm:**
1. Initialize `int[] next = new int[n + 1]`.
2. Loop `idx` backwards from `n - 1` down to `0`:
   - Initialize `int[] curr = new int[n + 1]`.
   - Loop `prev_idx` from `idx - 1` down to `-1`:
     - `not_take = next[prev_idx + 1]`.
     - `take = (prev_idx == -1 || arr[idx] > arr[prev_idx]) ? 1 + next[idx + 1] : 0`.
     - `curr[prev_idx + 1] = Math.max(not_take, take)`.
   - Set `next = curr`.
3. Return `next[0]`.

**Complexity:**
- **Time:** O(n²) — Two nested loops.
- **Space:** O(n) — Two 1D arrays of size `n + 1`.

---

### Approach 3: Better — Tabulation (2D Array)

**Idea:**  
Build a 2D DP grid `dp[n+1][n+1]` where `dp[idx][prev_idx+1]` represents the LIS from `idx` onwards given the index of the previously included element.

**Algorithm:**
1. Create `int[][] dp = new int[n + 1][n + 1]`.
2. Base case at `dp[n][...]` is 0.
3. Loop `idx` from `n - 1` down to `0`:
   - Loop `prev_idx` from `idx - 1` down to `-1`:
     - `not_take = dp[idx + 1][prev_idx + 1]`.
     - `take = (prev_idx == -1 || arr[idx] > arr[prev_idx]) ? 1 + dp[idx + 1][idx + 1] : 0`.
     - `dp[idx][prev_idx + 1] = Math.max(not_take, take)`.
4. Return `dp[0][0]`.

**Complexity:**
- **Time:** O(n²) — Nested loops over indices.
- **Space:** O(n²) — 2D DP grid of size `(n + 1) × (n + 1)`.

---

### Approach 2: Better — Memoization

**Idea:**  
Top-down recursion memoized with a 2D table `dp[n][n]`, storing computed results for `(idx, prev_idx + 1)`.

**Algorithm:**
1. Initialize `dp[n][n]` filled with `-1`.
2. Call `solve(0, -1, arr, dp)`.
3. In `solve(idx, prev_idx, arr, dp)`:
   - Base case: if `idx == arr.length`, return `0`.
   - If `dp[idx][prev_idx + 1] != -1`, return cached result.
   - `not_take = solve(idx + 1, prev_idx, arr, dp)`.
   - `take = (prev_idx == -1 || arr[idx] > arr[prev_idx]) ? 1 + solve(idx + 1, idx, arr, dp) : 0`.
   - Return `dp[idx][prev_idx + 1] = Math.max(take, not_take)`.

**Complexity:**
- **Time:** O(n²) — Evaluates $O(n^2)$ states.
- **Space:** O(n²) — Memoization table `n × n` + recursion call stack depth $O(n)$.

---

### Approach 1: Brute Force — Recursion

**Idea:**  
Recursively make a choice at each index whether to include the element (if strictly greater than previous included element) or skip it.

**Algorithm:**
1. Call `solve(0, -1, arr)`.
2. Base case: if `idx == arr.length`, return `0`.
3. Calculate `not_take = solve(idx + 1, prev_idx, arr)`.
4. Calculate `take = (prev_idx == -1 || arr[idx] > arr[prev_idx]) ? 1 + solve(idx + 1, idx, arr) : 0`.
5. Return `Math.max(take, not_take)`.

**Complexity:**
- **Time:** O(2^n) — Exponential decision tree.
- **Space:** O(n) — Recursion call stack.
