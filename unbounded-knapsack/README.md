# Unbounded Knapsack

**GFG Problem:** [https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1](https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1)

**Difficulty:** Medium

---

## Problem Description

Given `n` items, each with a weight `wt[i]` and value `val[i]`, and a knapsack of capacity `W`, find the maximum total value that can be obtained by filling the knapsack. Unlike 0/1 Knapsack, each item can be picked **unlimited number of times**.

---

## Examples

**Example 1:**

**Input:** `val[] = [1, 1]`, `wt[] = [2, 1]`, `capacity = 3`
**Output:** `3`
**Explanation:** Pick item 2 (weight 1, value 1) three times → total value = 3.

---

**Example 2:**

**Input:** `val[] = [6, 1, 10, 16]`, `wt[] = [1, 3, 2, 20]`, `capacity = 20`
**Output:** `136`
**Explanation:** Pick item 1 (weight 1, value 6) twice and item 3 (weight 2, value 10) nine times → 2×6 + 9×10 = 12 + 90 doesn't work out; optimal is picking item 4 once and item 3 repeatedly for 136.

---

## Approaches

---

### Approach 4: Space Optimized — 1D Rolling Array (Active)

**Idea:**
Instead of storing the full 2D DP table, maintain only two 1D arrays: `prev` (previous row) and `curr` (current row). Since the unbounded knapsack allows re-picking the same item, `curr[w - wt[i]]` is used for the `take` transition (pulling from the current row, not the previous one).

**Algorithm:**
1. Initialize `prev[w] = (w / wt[0]) * val[0]` for all `w` — max copies of item 0 that fit.
2. For each item `i` from 1 to n-1:
   - Create `curr` array of size `capacity + 1`.
   - For each capacity `w`: compute `skip = prev[w]`, `take = val[i] + curr[w - wt[i]]` (if fits).
   - `curr[w] = max(skip, take)`.
   - Set `prev = curr`.
3. Return `prev[capacity]`.

**Complexity:**
- **Time:** O(n × capacity) — two nested loops.
- **Space:** O(capacity) — two 1D arrays of size capacity + 1.

---

### Approach 3: Tabulation — 2D Bottom-Up DP

**Idea:**
Build a 2D DP table `dp[i][w]` representing the max value using items `0..i` with knapsack capacity `w`. The key insight for unbounded knapsack is that the `take` transition reads from `dp[i][w - wt[i]]` (same row) rather than `dp[i-1][...]`, allowing unlimited re-use of item `i`.

**Algorithm:**
1. Initialize base case: `dp[0][w] = (w / wt[0]) * val[0]` for all `w`.
2. For each item `i` from 1 to n-1:
   - For each capacity `w`: compute `skip = dp[i-1][w]`, `take = val[i] + dp[i][w - wt[i]]` (if fits).
   - `dp[i][w] = max(skip, take)`.
3. Return `dp[n-1][capacity]`.

**Complexity:**
- **Time:** O(n × capacity) — filling the entire DP table.
- **Space:** O(n × capacity) — 2D DP table.

---

### Approach 2: Memoization — Top-Down DP

**Idea:**
Solve recursively using `solve(idx, capacity)`: either skip item `idx` (recurse to `idx-1` with same capacity) or take item `idx` (recurse to same `idx` with reduced capacity, since it can be taken again). Cache results in a `dp[idx][capacity]` table to avoid recomputation.

**Algorithm:**
1. Initialize `dp[n][capacity+1]` with `Integer.MIN_VALUE` as sentinel for uncomputed states.
2. Base case: if `idx == 0`, return `(capacity / wt[0]) * val[0]` if it fits, else 0.
3. If `dp[idx][capacity]` is already computed, return it.
4. Compute `skip = solve(idx-1, ...)` and `take = val[idx] + solve(idx, capacity - wt[idx])` (if fits).
5. Store and return `dp[idx][capacity] = max(take, skip)`.

**Complexity:**
- **Time:** O(n × capacity) — each unique (idx, capacity) state is computed once.
- **Space:** O(n × capacity) — dp table + O(n + capacity) recursion stack depth.

---

### Approach 1: Brute Force — Pure Recursion

**Idea:**
Recursively explore all possibilities at each index: skip item `idx` (move to `idx-1`) or take item `idx` (stay at same `idx` with reduced capacity, enabling unlimited re-picks). No memoization, so overlapping subproblems are recomputed many times.

**Algorithm:**
1. Base case: if `idx == 0`, return `(capacity / wt[0]) * val[0]` if it fits, else 0.
2. Compute `skip = solve(idx-1, capacity)`.
3. If `wt[idx] <= capacity`: compute `take = val[idx] + solve(idx, capacity - wt[idx])`.
4. Return `max(take, skip)`.

**Complexity:**
- **Time:** O(n^(capacity/min_wt)) — exponential; subproblems recomputed without caching.
- **Space:** O(n + capacity) — maximum recursion stack depth.
