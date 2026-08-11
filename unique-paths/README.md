# Unique Paths

[Link to Problem on LeetCode](https://leetcode.com/problems/unique-paths/)

## Problem Description

You are given an `m x n` grid. A robot starts at the top-left cell and wants to reach the bottom-right cell. At each step, it can only move right or down.

Return the number of unique paths the robot can take.

### Example

**Input:** `m = 3, n = 7`  
**Output:** `28`

## Explanation

### Tabulation

Build a 2D `dp` table where `dp[i][j]` stores the number of ways to reach cell `(i, j)`.

1. Set `dp[0][0] = 1`.
2. For every other cell, add the number of ways from the top and left cells.
3. Return `dp[m - 1][n - 1]`.

- **Time Complexity:** O(m * n).
- **Space Complexity:** O(m * n).

### Memoization

Use recursion to compute the number of ways to reach a cell, and cache each result in a `dp` table to avoid repeated work.

- **Time Complexity:** O(m * n).
- **Space Complexity:** O(m * n), including the memoization table and recursion stack.

### Recursive Solution

Try both possible moves from each cell: right and down.

- **Time Complexity:** O(2^(m + n)).
- **Space Complexity:** O(m + n), for the recursion stack.
