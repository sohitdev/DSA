# Matrix Chain Multiplication

**GFG Problem:** [https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0309/1](https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0309/1)

**Difficulty:** Hard

---

## Problem Description

Given an array `arr[]` of integers representing dimensions of matrices such that the $i$-th matrix $A_i$ has dimensions `arr[i-1] × arr[i]`, find the minimum number of scalar multiplications needed to multiply the chain of $n-1$ matrices.

---

## Examples

**Example 1:**

**Input:** `arr[] = [40, 20, 30, 10, 30]`  
**Output:** `26000`  
**Explanation:**  
The matrices have dimensions 40×20, 20×30, 30×10, 10×30.  
Minimum operations are obtained by multiplying in the order `(A(BC))D` = $20 \times 30 \times 10 + 40 \times 20 \times 10 + 40 \times 10 \times 30 = 6000 + 8000 + 12000 = 26000$.

---

**Example 2:**

**Input:** `arr[] = [10, 20, 30]`  
**Output:** `6000`  
**Explanation:**  
There are 2 matrices of dimensions 10×20 and 20×30.  
Scalar multiplications required = $10 \times 20 \times 30 = 6000$.

---

## Approaches

---

### Approach 3: Optimal — Tabulation (Active)

**Idea:**  
Use a 2D DP table `dp[i][j]` representing the minimum multiplication operations needed to compute the matrix chain product $A_i \dots A_j$. Base case: `dp[i][i] = 0` (a single matrix requires 0 operations). Fill `dp` by iterating starting index `i` backwards from `n-1` down to `1` and ending index `j` from `i+1` up to `n-1`, testing all possible partition points `k` between `i` and `j-1`.

**Algorithm:**
1. Create `int[][] dp = new int[n][n]`.
2. Initialize base case: `dp[i][i] = 0` for all $0 \le i < n$.
3. Outer loop `i` from `n - 1` down to `1`:
   - Middle loop `j` from `i + 1` to `n - 1`:
     - Set `min_steps = Integer.MAX_VALUE`.
     - Inner partition loop `k` from `i` to `j - 1`:
       - `steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j]`.
       - Update `min_steps = min(min_steps, steps)`.
     - Set `dp[i][j] = min_steps`.
4. Return `dp[1][n - 1]`.

**Complexity:**
- **Time:** O(n³) — Three nested loops: `i`, `j`, and partition point `k`.
- **Space:** O(n²) — 2D DP table of size `n × n`.

---

### Approach 2: Better — Memoization

**Idea:**  
Top-down recursive partitioning memoized in a 2D table `dp[n][n]`.

**Algorithm:**
1. Initialize `dp[n][n]` filled with `0` (or `-1` as unvisited sentinel).
2. Call helper `solve(1, n - 1, arr, dp)`.
3. In `solve(i, j, arr, dp)`:
   - Base case: if `i == j`, return `0`.
   - If `dp[i][j] != 0`, return cached `dp[i][j]`.
   - Loop `k` from `i` to `j - 1`:
     - `steps = arr[i - 1] * arr[k] * arr[j] + solve(i, k, arr, dp) + solve(k + 1, j, arr, dp)`.
     - `min_steps = min(min_steps, steps)`.
   - Save and return `dp[i][j] = min_steps`.

**Complexity:**
- **Time:** O(n³) — $O(n^2)$ states, each doing $O(n)$ work in the loop.
- **Space:** O(n²) — DP table + recursion call stack of depth $O(n)$.

---

### Approach 1: Brute Force — Recursion

**Idea:**  
Try all possible parenthesizations by placing a partition at every index `k` between `i` and `j-1` recursively.

**Algorithm:**
1. Call `solve(1, n - 1, arr)`.
2. Base case: if `i == j`, return `0`.
3. Loop `k` from `i` to `j - 1`:
   - `steps = arr[i - 1] * arr[k] * arr[j] + solve(i, k, arr) + solve(k + 1, j, arr)`.
   - `min_steps = min(min_steps, steps)`.
4. Return `min_steps`.

**Complexity:**
- **Time:** O(2ⁿ) — Catalan number / exponential number of parenthesization trees.
- **Space:** O(n) — Maximum recursion call stack depth.
