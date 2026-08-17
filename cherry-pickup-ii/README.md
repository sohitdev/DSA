# Cherry Pickup II

[Link to Problem on LeetCode](https://leetcode.com/problems/cherry-pickup-ii/)

## Problem Description

Two robots start at the top row of a grid: one at the leftmost column and one at the rightmost column. Each robot moves to the next row and may shift left, stay in the same column, or shift right. Return the maximum number of cherries the robots can collect. A cell's cherries are counted once if both robots occupy it.

### Tabulation

Use a three-dimensional DP table where `dp[i][j1][j2]` stores the maximum cherries collected from row `i` when the robots are at columns `j1` and `j2`. Evaluate all nine pairs of possible next moves.

- **Time Complexity:** O(n * m^2).
- **Space Complexity:** O(n * m^2).

### Recursive + Memoization

Recursively explore both robots' nine possible move combinations and cache each state defined by the row and both robot columns.

- **Time Complexity:** O(n * m^2).
- **Space Complexity:** O(n * m^2), including the memoization table and recursion stack.

### Recursive Solution

Explore all nine combinations of the robots' moves at every row without memoization.

- **Time Complexity:** O(9^n).
- **Space Complexity:** O(n), for the recursion stack.
