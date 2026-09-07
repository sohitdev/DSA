# 122. Best Time to Buy and Sell Stock II

**LeetCode Problem:** [https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

**Difficulty:** Medium

---

## Problem Description

You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `i`<sup>th</sup> day.

On each day, you may decide to buy and/or sell the stock. You can only hold **at most one** share of the stock at any time. However, you can buy it then immediately sell it on the **same day**.

Find and return the **maximum profit** you can achieve.

---

## Examples

**Example 1:**

**Input:** `prices = [7,1,5,3,6,4]`  
**Output:** `7`  
**Explanation:**  
- Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5 - 1 = 4.
- Buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6 - 3 = 3.  
Total profit is 4 + 3 = 7.

---

**Example 2:**

**Input:** `prices = [1,2,3,4,5]`  
**Output:** `4`  
**Explanation:**  
- Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5 - 1 = 4.  
Total profit is 4.

---

**Example 3:**

**Input:** `prices = [7,6,4,3,1]`  
**Output:** `0`  
**Explanation:**  
There is no way to make a positive profit, so we never buy the stock to achieve a maximum profit of 0.

---

## Approaches

---

### Approach 4: Optimal — Space Optimized (1D Array) (Active)

**Idea:**  
Since calculating DP state for day `i` only depends on the results of day `i + 1` (`prev[0]` and `prev[1]`), we only need two 1D arrays of size 2 (or two variables) to maintain `prev` and `curr` states instead of a 2D matrix.

**Algorithm:**
1. Initialize `int[] prev = new int[2]` representing profit states for day `n` (which is `0`).
2. Iterate `i` backwards from `n - 1` down to `0`:
   - Initialize `int[] curr = new int[2]`.
   - If `buy == 1`: `curr[1] = max(-prices[i] + prev[0], prev[1])`.
   - If `buy == 0`: `curr[0] = max(prices[i] + prev[1], prev[0])`.
   - Update `prev = curr`.
3. Return `prev[1]` (profit starting at day 0 with buying allowed).

**Complexity:**
- **Time:** O(n) — Single loop through prices array.
- **Space:** O(1) — Uses fixed size arrays of length 2.

---

### Approach 3: Better — Tabulation

**Idea:**  
Bottom-up 2D DP table `dp[n+1][2]` where `dp[i][buy]` represents maximum profit achievable starting from day `i` with `buy` status (1 = allowed to buy, 0 = holding stock).

**Algorithm:**
1. Create `int[][] dp = new int[n + 1][2]`.
2. Base case: `dp[n][0] = dp[n][1] = 0`.
3. Loop `i` from `n - 1` down to `0`:
   - For `buy == 1`: `dp[i][1] = max(-prices[i] + dp[i+1][0], dp[i+1][1])`.
   - For `buy == 0`: `dp[i][0] = max(prices[i] + dp[i+1][1], dp[i+1][0])`.
4. Return `dp[0][1]`.

**Complexity:**
- **Time:** O(n) — Loops `n` times with 2 states each.
- **Space:** O(n) — 2D DP grid of size `(n + 1) × 2`.

---

### Approach 2: Better — Memoization

**Idea:**  
Top-down recursive approach with memoization table `dp[n][2]` initialized to `Integer.MIN_VALUE`.

**Algorithm:**
1. Initialize `dp[n][2]` filled with `Integer.MIN_VALUE`.
2. Call `solve(0, n, prices, 1, dp)`.
3. In `solve(i, n, prices, buy, dp)`:
   - Base case: if `i == n`, return `0`.
   - If `dp[i][buy] != Integer.MIN_VALUE`, return cached result.
   - If `buy == 1`, return `dp[i][buy] = max(-prices[i] + solve(i+1, n, prices, 0, dp), solve(i+1, n, prices, 1, dp))`.
   - Else, return `dp[i][buy] = max(prices[i] + solve(i+1, n, prices, 1, dp), solve(i+1, n, prices, 0, dp))`.

**Complexity:**
- **Time:** O(n) — Evaluates $O(n \times 2)$ states.
- **Space:** O(n) — DP grid of size `n × 2` + recursion call stack of depth $O(n)$.

---

### Approach 1: Brute Force — Recursion

**Idea:**  
Recursively evaluate all decisions on each day: either buy/skip if allowed to buy, or sell/hold if holding stock.

**Algorithm:**
1. Call `solve(0, n, prices, true)`.
2. Base case: if `i == n`, return `0`.
3. If `buy == true`, return `max(-prices[i] + solve(i+1, n, prices, false), solve(i+1, n, prices, true))`.
4. Else, return `max(prices[i] + solve(i+1, n, prices, true), solve(i+1, n, prices, false))`.

**Complexity:**
- **Time:** O(2^n) — Exponential decision tree (2 choices at each day).
- **Space:** O(n) — Recursion stack depth.
