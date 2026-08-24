# 0/1 Knapsack Problem

**GeeksforGeeks Problem:** [https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1](https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1)

**Difficulty:** Medium

---

## Problem Description

Given two arrays `val[]` and `wt[]` representing the values and weights of `n` items, and an integer `W` representing the maximum weight a knapsack can hold, determine the maximum total value that can be put in the knapsack. Each item can be selected at most once.

---

## Examples

**Example 1:**

**Input:** `W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]`
**Output:** `3`
**Explanation:** Select the item with value 3 and weight 1. No combination of the remaining items fits within the capacity with greater value.

---

**Example 2:**

**Input:** `W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6]`
**Output:** `0`

---

## Approaches

---

### Approach 3: Optimal — Space Optimization (Active)

**Idea:**
Keep the best values for the previous item in `prev` and build the current item row in `curr`. The transition either skips the current item or takes it and uses the best value from the previous row at the remaining capacity.

**Algorithm:**

1. Initialize the first row using the value of the first item wherever it fits.
2. For every remaining item and capacity, calculate the best value by skipping or taking the item.
3. Replace `prev` with the current row and return the result for capacity `W`.

**Complexity:**

- **Time:** O(n \* W) — each item is evaluated for every capacity.
- **Space:** O(W) — two one-dimensional arrays.

---

### Approach 2: Better — Tabulation

**Idea:**
Store the best value for every item prefix and capacity in a two-dimensional dynamic programming table. Each state considers skipping or taking the current item.

**Algorithm:**

1. Initialize the first row for all capacities.
2. Fill each following row using the previous row's skip and take values.
3. Return the state for the last item and capacity `W`.

**Complexity:**

- **Time:** O(n \* W)
- **Space:** O(n \* W)

---

### Approach 1: Brute Force — Recursion

**Idea:**
Recursively choose whether to skip or take each item, exploring every possible subset of items.

**Algorithm:**

1. For each item, recursively compute the result when it is skipped.
2. If it fits, recursively compute the result when it is taken.
3. Return the larger of the two results, with the first item as the base case.

**Complexity:**

- **Time:** O(2^n) — both choices are explored for each item.
- **Space:** O(n) — recursion stack.
