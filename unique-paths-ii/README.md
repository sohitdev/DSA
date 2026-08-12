# Unique Paths II

[Link to Problem on LeetCode](https://leetcode.com/problems/unique-paths-ii/)

## Problem Description

Given an `m x n` grid containing obstacles, return the number of unique paths from the top-left cell to the bottom-right cell. The robot can only move right or down, and cannot move through obstacle cells.

### Tabulation + DP

Use a 2D DP table where each cell stores the number of ways to reach it. Obstacle cells have zero ways. For every open cell, add the ways from the cell above and the cell to the left.

- **Time Complexity:** O(m * n).
- **Space Complexity:** O(m * n).

### Memoization + Recursive Approach

Recursively calculate paths from the top and left cells while caching each computed cell in the DP table. Return zero for out-of-bounds or obstacle cells.

- **Time Complexity:** O(m * n).
- **Space Complexity:** O(m * n), including the memoization table and recursion stack.

### Recursive Approach

Try both possible moves at every open cell without caching results.

- **Time Complexity:** O(2^(m + n)).
- **Space Complexity:** O(m + n), for the recursion stack.
