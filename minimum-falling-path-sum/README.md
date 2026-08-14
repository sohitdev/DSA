# Minimum Falling Path Sum

[Link to Problem on LeetCode](https://leetcode.com/problems/minimum-falling-path-sum/)

## Problem Description

Given an `n x n` array of integers, return the minimum sum of a falling path through the array. A falling path starts at any element in the first row and chooses the element directly below, below-left, or below-right in the next row.

### Space Optimization Approach

Store only the previous row's minimum path sums in a one-dimensional DP array. Build a new current row using the three possible values from the previous row.

- **Time Complexity:** O(n^2).
- **Space Complexity:** O(n).

### Tabulation Approach

Use a two-dimensional DP table where each cell stores the minimum falling path sum ending at that cell. For each position, select the minimum of the valid three cells from the previous row.

- **Time Complexity:** O(n^2).
- **Space Complexity:** O(n^2).

### Memoization + Recursive Approach

Recursively calculate the minimum path sum for each cell and cache results in a DP table to avoid repeated calculations.

- **Time Complexity:** O(n^2).
- **Space Complexity:** O(n^2), including the memoization table and recursion stack.

### Recursive Approach

Try all valid downward, down-left, and down-right paths recursively without caching results.

- **Time Complexity:** O(3^n).
- **Space Complexity:** O(n), for the recursion stack.
