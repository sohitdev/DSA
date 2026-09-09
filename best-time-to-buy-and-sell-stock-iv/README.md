# 188. Best Time to Buy and Sell Stock IV

**LeetCode Problem:** [https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)

**Difficulty:** Hard

---

## Problem Description

You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `i`<sup>th</sup> day, and an integer `k`.

Find the maximum profit you can achieve. You may complete at most `k` transactions.

**Note:** You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

---

## Examples

**Example 1:**

**Input:** `k = 2`, `prices = [2,4,1]`  
**Output:** `2`  
**Explanation:**  
Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4 - 2 = 2.

---

**Example 2:**

**Input:** `k = 2`, `prices = [3,2,6,5,0,3]`  
**Output:** `7`  
**Explanation:**  
- Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6 - 2 = 4.
- Buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3 - 0 = 3.  
Total profit is 4 + 3 = 7.

---

## Approaches

---

### Approach 2: Optimal — Space Optimized (2D Array) (Active)

**Idea:**  
Since calculating DP state for day `i` only depends on the results of day `i + 1` (`next[buy][cap]`), we can optimize the space complexity by keeping only two 2D arrays (`next` and `curr`) of size `2 × (k + 1)` instead of a full 3D DP grid.

**Algorithm:**
1. Initialize `int[][] next = new int[2][k + 1]` representing base cases at day `n` (all profits 0).
2. Loop `i` backwards from `n - 1` down to `0`:
   - Initialize `int[][] curr = new int[2][k + 1]`.
   - Loop `buy` from 0 to 1 and `cap` from 0 to `k - 1`:
     - If `buy == 1`: `curr[buy][cap] = max(-prices[i] + next[0][cap], next[1][cap])`.
     - Else: `curr[buy][cap] = max(prices[i] + next[1][cap + 1], next[0][cap])`.
   - Update `next = curr`.
3. Return `next[1][0]` (profit starting at day 0, allowed to buy, 0 transactions completed).

**Complexity:**
- **Time:** O(n × k) — Nested loops running $n \times 2 \times k$ times.
- **Space:** O(k) — Space allocated for two 2D arrays of size $2 \times (k + 1)$.

---

### Approach 1: Better — Tabulation

**Idea:**  
Bottom-up 3D DP table `dp[n+1][2][k+1]` where `dp[i][buy][cap]` stores the maximum profit from day `i` with `buy` status (1 = buy, 0 = sell) and `cap` completed transactions.

**Algorithm:**
1. Create `int[][][] dp = new int[n + 1][2][k + 1]`.
2. Base cases at `dp[n][buy][cap] = 0` and `dp[i][buy][k] = 0` are implicitly 0.
3. Loop `i` from `n - 1` down to `0`:
   - Loop `buy` from 0 to 1 and `cap` from 0 to `k - 1`:
     - If `buy == 1`: `dp[i][buy][cap] = max(-prices[i] + dp[i+1][0][cap], dp[i+1][1][cap])`.
     - Else: `dp[i][buy][cap] = max(prices[i] + dp[i+1][1][cap+1], dp[i+1][0][cap])`.
4. Return `dp[0][1][0]`.

**Complexity:**
- **Time:** O(n × k) — Loops $n \times 2 \times k$ times.
- **Space:** O(n × k) — 3D DP table of size `(n + 1) × 2 × (k + 1)`.
