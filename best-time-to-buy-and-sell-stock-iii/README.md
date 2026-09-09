# 123. Best Time to Buy and Sell Stock III

**LeetCode Problem:** [https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)

**Difficulty:** Hard

---

## Problem Description

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`<sup>th</sup> day.

Find the maximum profit you can achieve. You may complete **at most two transactions**.

**Note:** You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

---

## Examples

**Example 1:**

**Input:** `prices = [3,3,5,0,0,3,1,4]`  
**Output:** `6`  
**Explanation:**  
- Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3 - 0 = 3.
- Buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4 - 1 = 3.  
Total profit is 3 + 3 = 6.

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
In this case, no transaction is done, i.e. max profit = 0.

---

## Approaches

---

### Approach 4: Optimal — Space Optimized (2D Array) (Active)

**Idea:**  
Notice that evaluating day `i`'s state only requires values from day `i + 1` (`next[buy][cap]`). Thus, we can compress the 3D DP grid into two 2D arrays (`curr[2][3]` and `next[2][3]`) of fixed size $2 \times 3$, reducing auxiliary space to $O(1)$.

**Algorithm:**
1. Initialize `int[][] next = new int[2][3]` representing base cases at day `n` (all profits 0).
2. Loop `i` backwards from `n - 1` down to `0`:
   - Initialize `int[][] curr = new int[2][3]`.
   - Loop `buy` from 0 to 1 and `cap` from 0 to 1:
     - If `buy == 1`: `curr[buy][cap] = max(-prices[i] + next[0][cap], next[1][cap])`.
     - Else: `curr[buy][cap] = max(prices[i] + next[1][cap + 1], next[0][cap])`.
   - Update `next = curr`.
3. Return `next[1][0]` (profit starting at day 0, allowed to buy, 0 transactions completed).

**Complexity:**
- **Time:** O(n) — Single loop through prices array ($n \times 2 \times 2$ iterations).
- **Space:** O(1) — Uses fixed size $2 \times 3$ matrices.

---

### Approach 3: Better — Tabulation

**Idea:**  
Bottom-up 3D DP table `dp[n+1][2][3]` where `dp[i][buy][cap]` stores maximum profit from day `i` with status `buy` (1 = buy, 0 = sell) and `cap` completed transactions.

**Algorithm:**
1. Create `int[][][] dp = new int[n + 1][2][3]`.
2. Base cases at `dp[n][buy][cap] = 0` and `dp[i][buy][2] = 0` are implicitly 0.
3. Loop `i` from `n - 1` down to `0`:
   - Loop `buy` from 0 to 1 and `cap` from 0 to 1:
     - If `buy == 1`: `dp[i][buy][cap] = max(-prices[i] + dp[i+1][0][cap], dp[i+1][1][cap])`.
     - Else: `dp[i][buy][cap] = max(prices[i] + dp[i+1][1][cap+1], dp[i+1][0][cap])`.
4. Return `dp[0][1][0]`.

**Complexity:**
- **Time:** O(n) — Loops $n \times 2 \times 2$ times.
- **Space:** O(n) — 3D DP table of size `(n + 1) × 2 × 3`.

---

### Approach 2: Better — Memoization

**Idea:**  
Top-down recursion with memoization table `dp[n][2][3]` initialized to `-1`.

**Algorithm:**
1. Initialize `dp[n][2][3]` filled with `-1`.
2. Call `solve(0, prices, 1, 0, dp)`.
3. In `solve(i, prices, buy, cap, dp)`:
   - Base case: if `i == prices.length` or `cap == 2`, return `0`.
   - If `dp[i][buy][cap] != -1`, return cached result.
   - If `buy == 1`, return `dp[i][buy][cap] = max(-prices[i] + solve(i+1, prices, 0, cap, dp), solve(i+1, prices, 1, cap, dp))`.
   - Else, return `dp[i][buy][cap] = max(prices[i] + solve(i+1, prices, 1, cap + 1, dp), solve(i+1, prices, 0, cap, dp))`.

**Complexity:**
- **Time:** O(n) — Evaluates $O(n \times 2 \times 3)$ states.
- **Space:** O(n) — DP grid of size `n × 2 × 3` + recursion stack of depth $O(n)$.

---

### Approach 1: Brute Force — Recursion

**Idea:**  
Recursively explore choices (buy/skip or sell/skip) while tracking transaction cap up to 2.

**Algorithm:**
1. Call `solve(0, prices, true, 0)`.
2. Base case: if `i == prices.length` or `cap == 2`, return `0`.
3. If `buy == true`, return `max(-prices[i] + solve(i+1, prices, false, cap), solve(i+1, prices, true, cap))`.
4. Else, return `max(prices[i] + solve(i+1, prices, true, cap + 1), solve(i+1, prices, false, cap))`.

**Complexity:**
- **Time:** O(2^n) — Exponential decision tree.
- **Space:** O(n) — Recursion call stack.
