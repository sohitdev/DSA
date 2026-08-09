# House Robber

[Link to Problem on LeetCode](https://leetcode.com/problems/house-robber/)

## Problem Description

You are given an integer array `nums` representing the amount of money in each house. You cannot rob two adjacent houses. Return the maximum amount of money you can rob without alerting the police.

### Example

**Input:** `nums = [2, 7, 9, 3, 1]`  
**Output:** `12`

**Explanation:** Rob houses with amounts `2`, `9`, and `1`.

## Explanation

### Space-Optimized Dynamic Programming

For each house, choose between robbing it along with the best result from two houses earlier, or skipping it and keeping the previous result.

1. Track the best results for the previous two positions using `prev2` and `prev1`.
2. For each house, calculate the amount gained by taking it and the amount gained by skipping it.
3. Store the larger value as the current result.
4. Shift the two previous results forward and return the final result.

- **Time Complexity:** O(n).
- **Space Complexity:** O(1).

### Tabulation

Use a `dp` array where `dp[i]` stores the maximum amount that can be robbed from houses `0` through `i`. For each house, compute the maximum of taking the current house plus `dp[i - 2]` or skipping it with `dp[i - 1]`.

- **Time Complexity:** O(n).
- **Space Complexity:** O(n).

### Memoization

Define `solve(idx)` as the maximum amount obtainable from houses `0` through `idx`. Recursively consider taking or skipping the current house, and cache each result in `dp`.

- **Time Complexity:** O(n).
- **Space Complexity:** O(n), including the memoization array and recursion stack.

### Recursion

Use the same take-or-skip recurrence without caching previously computed states.

- **Time Complexity:** O(2^n).
- **Space Complexity:** O(n), for the recursion stack.
