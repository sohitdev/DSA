# Rod Cutting

**GFG Problem:** [https://www.geeksforgeeks.org/problems/rod-cutting0840/1](https://www.geeksforgeeks.org/problems/rod-cutting0840/1)

**Difficulty:** Medium

---

## Problem Description

Given a rod of length `N` inches and an array of prices, `price[]` that contains prices of all pieces of size smaller than `N`. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

---

## Examples

**Example 1:**

**Input:** `price[] = [1, 5, 8, 9, 10, 17, 17, 20]`, `N = 8`
**Output:** `22`
**Explanation:** The maximum value is obtained by cutting the rod into two pieces of lengths 2 and 6, giving a price of 5 + 17 = 22.

---

**Example 2:**

**Input:** `price[] = [3, 5, 8, 9, 10, 17, 17, 20]`, `N = 8`
**Output:** `24`
**Explanation:** The maximum value is obtained by cutting the rod into 8 pieces of length 1, giving a price of 3 * 8 = 24.

---

## Approaches

---

### Approach 4: Optimal — Space Optimized (1D Array) (Active)

**Idea:**
Since the transition formula for the current state only relies on values from the current row (if we choose to cut the rod at the current piece length) and values from the previous row (if we skip the current piece length), we can optimize the space to a single 1D array of size `N + 1`. By updating it from left to right, we can reuse the updated values of the current row directly.

**Algorithm:**
1. Initialize `prev` array of size `N + 1` where `prev[n] = price[0] * n` (base case for only using piece of length 1).
2. Loop `i` from 1 to `N - 1` (different cut lengths):
   - For each rod length `n` from 0 to `N`:
     - `skip = prev[n]`
     - `take = price[i] + prev[n - (i + 1)]` (if `i + 1 <= n`)
     - `prev[n] = max(skip, take)`
3. Return `prev[N]`.

**Complexity:**
- **Time:** O(N²) — Nested loops for item index and rod length.
- **Space:** O(N) — Single 1D array of size N + 1.

---

### Approach 3: Better — Tabulation

**Idea:**
Using a 2D table `dp[i][n]` where `i` represents the piece size index and `n` represents the remaining length of the rod. At each state, we can either skip the current piece size `i` (and take the result from `dp[i-1][n]`) or cut a piece of size `i + 1` (and add `price[i]` to `dp[i][n - (i+1)]`).

**Algorithm:**
1. Create a 2D DP table `dp` of size `N x (N + 1)`.
2. Initialize base case for `dp[0][n] = price[0] * n` for all `n`.
3. Loop `i` from 1 to `N - 1`:
   - Loop `n` from 0 to `N`:
     - `skip = dp[i-1][n]`
     - `take = price[i] + dp[i][n - (i+1)]` (if `i + 1 <= n`)
     - `dp[i][n] = max(skip, take)`
4. Return `dp[N-1][N]`.

**Complexity:**
- **Time:** O(N²) — Nested loops filling the DP grid.
- **Space:** O(N²) — 2D DP grid of size N x (N + 1).

---

### Approach 2: Better — Memoization

**Idea:**
Use a top-down approach with recursion and memoize the results using a 2D DP table to avoid redundant calculations.

**Algorithm:**
1. Initialize a 2D table `dp` of size `N x (N + 1)` with `Integer.MIN_VALUE`.
2. Call helper function `solve(N - 1, price, N, dp)`.
3. Inside `solve(idx, price, N, dp)`:
   - Base case: If `idx == 0`, return `N * price[0]`.
   - If already computed, return `dp[idx][N]`.
   - Calculate `skip` and `take` choices.
   - Cache and return `dp[idx][N] = max(skip, take)`.

**Complexity:**
- **Time:** O(N²) — N x N states, each computed in O(1) time.
- **Space:** O(N²) — 2D table of size N x (N + 1) + recursion stack space O(N).

---

### Approach 1: Brute Force — Recursion

**Idea:**
Recursively try to cut pieces of length `idx + 1` or skip them to find the maximum price.

**Algorithm:**
1. Start recursive solver from `solve(N - 1, price, N)`.
2. Base case: If `idx == 0`, return `N * price[0]`.
3. Calculate `skip = solve(idx - 1, price, N)`.
4. Calculate `take = price[idx] + solve(idx, price, N - (idx + 1))` (if `idx + 1 <= N`).
5. Return the maximum of `skip` and `take`.

**Complexity:**
- **Time:** O(2^N) — Exponential recursion tree.
- **Space:** O(N) — Recursion stack depth.
