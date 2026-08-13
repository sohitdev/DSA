# Triangle

[Link to Problem on LeetCode](https://leetcode.com/problems/triangle/)

## Problem Description

Given a triangle array, return the minimum path sum from the top to the bottom. At each step, you may move to an adjacent number on the row below.

### Space Optimization Approach

Copy the bottom row into a one-dimensional DP array. Process rows from bottom to top, replacing each position with its value plus the smaller of its two children.

- **Time Complexity:** O(n^2).
- **Space Complexity:** O(n).

### Tabulation Approach

Use a two-dimensional DP table. Start with the bottom row and calculate the minimum path sum for each cell while moving upward.

- **Time Complexity:** O(n^2).
- **Space Complexity:** O(n^2).

### Memoization Approach

Recursively explore the two adjacent choices below each cell and cache the minimum result for every triangle position.

- **Time Complexity:** O(n^2).
- **Space Complexity:** O(n^2), including the memoization table and recursion stack.

### Recursive Approach

Explore both downward paths from every cell without caching results.

- **Time Complexity:** O(2^n).
- **Space Complexity:** O(n), for the recursion stack.
