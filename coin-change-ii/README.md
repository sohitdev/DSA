# 518. Coin Change II

**LeetCode Problem:** [https://leetcode.com/problems/coin-change-ii/](https://leetcode.com/problems/coin-change-ii/)

**Difficulty:** Medium

---

## Problem Description

You are given an integer `amount` and an array of distinct integers `coins` representing coin denominations. Return the number of combinations that make up that amount. You may use each coin an unlimited number of times, and different orders of the same coins count as one combination.

---

## Examples

**Example 1:**

**Input:** `amount = 5, coins = [1,2,5]`
**Output:** `4`
**Explanation:** The combinations are `5`, `2 + 2 + 1`, `2 + 1 + 1 + 1`, and `1 + 1 + 1 + 1 + 1`.

---

**Example 2:**

**Input:** `amount = 3, coins = [2]`
**Output:** `0`

---

## Approaches

---

### Approach 4: Optimal — Space-Optimized Tabulation (Active)

**Idea:**
Use one previous row and one current row of the two-dimensional dynamic programming table. For each coin and target, combine ways that skip the coin with ways that take it. Reading the current row from left to right allows unlimited reuse of the current coin.

**Algorithm:**

1. Initialize the first row: every target divisible by the first coin has one combination.
2. For each remaining coin, compute every target using the previous row for skipping and the current row for taking.
3. Return the number of combinations for the final target.

**Complexity:**

- **Time:** O(n \* amount) — each coin processes every target.
- **Space:** O(amount) — two one-dimensional rows.

---

### Approach 3: Better — Tabulation

**Idea:**
Build a two-dimensional table where `dp[i][t]` stores the number of combinations to make target `t` using coins through index `i`.

**Algorithm:**

1. Initialize the first row for targets divisible by the first coin.
2. For each coin and target, add the ways that skip the coin to the ways that take it.
3. Return `dp[n - 1][amount]`.

**Complexity:**

- **Time:** O(n \* amount)
- **Space:** O(n \* amount)

---

### Approach 2: Better — Memoization

**Idea:**
Recursively choose whether to skip the current coin or take it, caching each `(index, target)` state to avoid repeated work.

**Algorithm:**

1. For index `0`, return one when the target is divisible by the first coin; otherwise return zero.
2. Return a cached result when the state has already been computed.
3. Add the skip and take results and cache the sum.

**Complexity:**

- **Time:** O(n \* amount)
- **Space:** O(n \* amount) — memoization table and recursion stack.

---

### Approach 1: Brute Force — Recursion

**Idea:**
Recursively explore skipping or taking each coin without caching previously computed states.

**Algorithm:**

1. For index `0`, check whether the target is divisible by the first coin.
2. Recursively count combinations that skip the current coin.
3. Recursively count combinations that take the current coin when possible, then add both results.

**Complexity:**

- **Time:** O(2^(n + amount))
- **Space:** O(n + amount) — recursion stack.
