# Min Path Sum

[Link to Problem on LeetCode](https://leetcode.com/problems/minimum-path-sum/)

## Problem Description

Given an `m x n` grid filled with non-negative numbers, find a path from the top-left to the bottom-right corner that minimizes the sum of all numbers along the path. The robot can only move right or down.

### Space Optimization

Use a one-dimensional DP array. For each cell, calculate the minimum path sum from the top and left cells. The current `dp[j]` represents the top value, while `dp[j - 1]` represents the left value.

- **Time Complexity:** O(m * n).
- **Space Complexity:** O(n).

### Tabulation

Build a two-dimensional DP table where `dp[i][j]` stores the minimum path sum to reach cell `(i, j)`. Each value is calculated from the minimum of the top and left paths plus the current grid value.

- **Time Complexity:** O(m * n).
- **Space Complexity:** O(m * n).

### Memoization + Recursive Approach

Recursively calculate the minimum path sum from the top and left cells, caching each result in the DP table to avoid repeated calculations.

- **Time Complexity:** O(m * n).
- **Space Complexity:** O(m * n), including the memoization table and recursion stack.

### Recursive Approach

Try both possible directions recursively at every cell and choose the smaller path sum.

- **Time Complexity:** O(2^(m + n)).
- **Space Complexity:** O(m + n), for the recursion stack.
