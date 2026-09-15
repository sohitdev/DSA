# 312. Burst Balloons

**LeetCode Problem:** [https://leetcode.com/problems/burst-balloons/](https://leetcode.com/problems/burst-balloons/)

**Difficulty:** Hard

---

## Problem Description

You are given `n` balloons, indexed from `0` to `n - 1`. Each balloon is painted with a number on it represented by the array `nums`. You are asked to burst all the balloons.

If you burst the `i`th balloon, you will get `nums[i - 1] * nums[i] * nums[i + 1]` coins. If `i - 1` or `i + 1` goes out of bounds, treat those balloons as having a `1` painted on them.

Return the **maximum coins** you can collect by bursting all the balloons wisely.

---

## Examples

**Example 1:**

**Input:** `nums = [3,1,5,8]`
**Output:** `167`
**Explanation:** Burst balloons in order `[1,5,3,8]`. Coins: `3×1×5 + 3×5×8 + 1×3×8 + 1×8×1 = 15 + 120 + 24 + 8 = 167`.

---

**Example 2:**

**Input:** `nums = [1,5]`
**Output:** `10`

---

## Approaches

---

### Approach 3: Optimal — Tabulation (Active)

**Idea:**
Instead of thinking about which balloon to burst *first*, think about which balloon to burst *last* in any sub-range `[i, j]`. Pad the array with virtual `1`s at both ends. `dp[i][j]` represents the maximum coins obtainable by bursting all balloons in the range `[i, j]` when the boundaries `arr[i-1]` and `arr[j+1]` are still intact (i.e., balloon `k` is burst last in this window, giving `arr[i-1] * arr[k] * arr[j+1]`).

**Algorithm:**
1. Build `arr[]` of size `n+2`: set `arr[0] = arr[n+1] = 1`, copy `nums` into `arr[1..n]`.
2. Create `dp[n+2][n+2]` initialized to `0`.
3. Iterate `i` from `n` down to `1`, and `j` from `1` up to `n`:
   - For each possible last balloon `k` in `[i, j]`:
     - `coins = arr[i-1] * arr[k] * arr[j+1] + dp[i][k-1] + dp[k+1][j]`
     - `dp[i][j] = max(dp[i][j], coins)`.
4. Return `dp[1][n]`.

**Complexity:**
- **Time:** O(n³) — Three nested loops over range length, start index, and partition point.
- **Space:** O(n²) — 2D DP table of size `(n+2) × (n+2)`.

---

### Approach 2: Better — Memoization

**Idea:**
Same recurrence as tabulation but computed top-down with recursion. `solve(i, j)` returns the maximum coins from bursting all balloons in range `[i, j]`, trying each `k` as the last balloon to burst in that range.

**Algorithm:**
1. Build `arr[]` with virtual boundary `1`s.
2. Initialise `dp[n+2][n+2]` filled with `-1`.
3. In `solve(i, j)`: if `i > j` return `0`; if cached, return `dp[i][j]`.
4. Try each `k` in `[i, j]` as last burst: `coins = arr[i-1]*arr[k]*arr[j+1] + solve(i,k-1) + solve(k+1,j)`.
5. Cache and return the maximum.

**Complexity:**
- **Time:** O(n³) — O(n²) states, each doing O(n) work.
- **Space:** O(n²) — Memoization table plus O(n) recursion stack.

---

### Approach 1: Brute Force — Recursion

**Idea:**
Try all possible orders of bursting balloons by choosing which balloon to burst last in each sub-range, without any caching.

**Algorithm:**
1. For range `[i, j]`, try each `k` as the last balloon to burst.
2. Recursively compute coins from left and right sub-ranges and add the boundary coin gain.
3. Return the maximum.

**Complexity:**
- **Time:** O(n! × n) — Exponential due to no memoization.
- **Space:** O(n) — Recursion stack depth.
