# 309. Best Time to Buy and Sell Stock with Cooldown

**LeetCode Problem:** [https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)

**Difficulty:** Medium

---

## Problem Description

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`<sup>th</sup> day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restriction:
- After you sell your stock, you cannot buy stock on the next day (i.e., **cooldown 1 day**).

**Note:** You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

---

## Examples

**Example 1:**

**Input:** `prices = [1,2,3,0,2]`  
**Output:** `3`  
**Explanation:** transactions = [buy, sell, cooldown, buy, sell]

---

**Example 2:**

**Input:** `prices = [1]`  
**Output:** `0`

---

## Approaches

---

### Approach 3: Optimal — Tabulation (Active)

**Idea:**  
Construct a 2D DP table `dp[n+2][2]`, where `dp[i][buy]` represents the maximum profit starting from day `i` with `buy` status (1 = allowed to buy, 0 = holding stock). Because selling requires a 1-day cooldown, after selling on day `i`, the next available day to buy is `i + 2`, which is handled by referencing `dp[i + 2][1]`. DP size is `(n+2) × 2` to safely access `dp[i+2]` without index out-of-bound errors.

**Algorithm:**
1. Initialize `int[][] dp = new int[n + 2][2]`.
2. Base case: `dp[n][0] = dp[n][1] = 0` and `dp[n+1][0] = dp[n+1][1] = 0`.
3. Loop `i` backwards from `n - 1` down to `0`:
   - For `buy == 1`: `dp[i][1] = max(-prices[i] + dp[i+1][0], dp[i+1][1])`.
   - For `buy == 0`: `dp[i][0] = max(prices[i] + dp[i+2][1], dp[i+1][0])`.
4. Return `dp[0][1]`.

**Complexity:**
- **Time:** O(n) — Single loop from $n - 1$ down to 0 with constant state updates.
- **Space:** O(n) — 2D DP grid of size `(n + 2) × 2`.

---

### Approach 2: Better — Memoization

**Idea:**  
Top-down recursion with memoization grid `dp[n][2]` initialized to `-1`.

**Algorithm:**
1. Initialize `dp[prices.length][2]` filled with `-1`.
2. Call `solve(0, prices, 1, dp)`.
3. In `solve(i, prices, buy, dp)`:
   - Base case: if `i >= prices.length`, return `0`.
   - If `dp[i][buy] != -1`, return cached result.
   - If `buy == 1`: return `dp[i][1] = max(-prices[i] + solve(i + 1, prices, 0, dp), solve(i + 1, prices, 1, dp))`.
   - Else (`buy == 0`): return `dp[i][0] = max(prices[i] + solve(i + 2, prices, 1, dp), solve(i + 1, prices, 0, dp))`.

**Complexity:**
- **Time:** O(n) — Evaluates at most $2 \times n$ subproblems.
- **Space:** O(n) — DP grid + recursion call stack depth of $O(n)$.

---

### Approach 1: Brute Force — Recursion

**Idea:**  
Recursively try buying/skipping or selling/skipping at each day. When selling, skip to `i + 2` to enforce the 1-day cooldown restriction.

**Algorithm:**
1. Call `solve(0, prices, 1)`.
2. Base case: if `i == prices.length`, return `0`.
3. If `buy == 1`: return `max(-prices[i] + solve(i + 1, prices, 0), solve(i + 1, prices, 1))`.
4. Else: return `max(prices[i] + solve(i + 2, prices, 1), solve(i + 1, prices, 0))`.

**Complexity:**
- **Time:** O(2^n) — Exponential branching factor of choices.
- **Space:** O(n) — Maximum recursion call stack depth.
