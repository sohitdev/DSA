# Minimum Cost to Cut a Stick

**GFG Problem:** [https://www.geeksforgeeks.org/problems/minimum-cost-to-cut-a-stick/1](https://www.geeksforgeeks.org/problems/minimum-cost-to-cut-a-stick/1)

**Difficulty:** Hard

---

## Problem Description

Given a stick of length `n` and an array `cuts` where `cuts[i]` denotes a position to cut the stick, you need to cut the stick at each of these positions. The cost of making a cut is equal to the length of the stick being cut. Return the minimum total cost to cut the stick at all given positions.

---

## Examples

**Example 1:**

**Input:** `n = 7`, `cuts = [1,3,4,5]`
**Output:** `16`
**Explanation:** One optimal way is to cut in the order `[3, 4, 5, 1]`. The total cost is `7 + 4 + 3 + 2 = 16`.

**Example 2:**

**Input:** `n = 9`, `cuts = [5,6,1,4,2]`
**Output:** `22`
**Explanation:** The optimal sequence of cuts yields a total cost of 22.

---

## Approaches

---

### Approach 1: Optimal — DP + Memoization (Active)

**Idea:**

We augment the `cuts` array with the two ends of the stick (`0` and `n`) and sort it. The problem then becomes finding the minimum cost to cut the segment between any two cuts `i-1` and `j+1`. We use a top‑down DP where `dp[i][j]` stores the minimum cost for the sub‑segment `(i-1, j+1)`. The transition tries every possible cut `k` in `[i, j]` and adds the cost of the current segment plus the optimal costs of the left and right sub‑segments.

**Algorithm:**
1. Build `cost[]` of size `c+2` (`c = cuts.length`) containing `0`, all cuts, and `n`. Sort it.
2. Initialise a memoisation table `dp` of size `(c+2) × (c+2)` with `-1`.
3. Define a recursive function `solve(i, j)` that returns `0` if `i>j`. If `dp[i][j]` is already computed, return it.
4. For each possible cut `k` between `i` and `j`, compute:
   `cur = cost[j+1] - cost[i-1] + solve(i, k-1) + solve(k+1, j)`.
   Keep the minimum of `cur`.
5. Store the minimum in `dp[i][j]` and return it.
6. The answer is `solve(1, c)`.

**Complexity:**
- **Time:** `O(c³)` – there are `O(c²)` states and each state iterates over `O(c)` possible cuts.
- **Space:** `O(c²)` – memoisation table.

---

### Approach 2: Recursive (Brute‑Force) — Inactive

**Idea:**

A pure recursive solution that tries every possible order of cuts without memoisation. It explores all `c!` permutations and therefore is exponential.

**Algorithm:**
1. Recursively consider cutting at each position `k` in `[i, j]`.
2. The cost of cutting the current segment is `cost[j+1] - cost[i-1]` plus the costs of the left and right sub‑segments.
3. Return the minimum cost among all choices.

**Complexity:**
- **Time:** `O(c!)` – exponential due to exploring all permutations.
- **Space:** `O(c)` – recursion stack.

---

**Reference Implementation (Java):** See the accompanying `min-cost-to-cut-a-stick.java` file.

---

**How to Use**

Compile and run with:
```bash
cd min-cost-to-cut-a-stick
javac min-cost-to-cut-a-stick.java
java Solution
```
(Replace the `main` method with your own driver code as needed.)
