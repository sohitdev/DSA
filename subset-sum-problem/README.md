# Subset Sum Problem

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1)

## Problem Description

Given an array of non-negative integers and a target sum, determine whether there is a subset whose elements add up exactly to the target sum.

### Tabulation

Build a boolean DP table where `dp[i][s]` indicates whether sum `s` can be formed using elements up to index `i`. For each element, either skip it or include it when possible.

- **Time Complexity:** O(n * sum).
- **Space Complexity:** O(n * sum).

### Memoization

Recursively try taking or skipping each element and cache each `(index, sum)` state.

- **Time Complexity:** O(n * sum).
- **Space Complexity:** O(n * sum), including the memoization table and recursion stack.

### Recursive Approach

Try both choices—take or skip—for every element without caching results.

- **Time Complexity:** O(2^n).
- **Space Complexity:** O(n), for the recursion stack.
