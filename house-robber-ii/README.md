# House Robber II

[Link to Problem on LeetCode](https://leetcode.com/problems/house-robber-ii/)

## Problem Description

You are given an integer array `nums` representing money in houses arranged in a circle. You cannot rob two adjacent houses. Return the maximum amount of money you can rob without alerting the police.

### Example

**Input:** `nums = [2, 3, 2]`  
**Output:** `3`

**Explanation:** Because the houses form a circle, the first and last houses are adjacent. Rob only the second house.

## Explanation

### Space-Optimized Dynamic Programming

Since the first and last houses cannot both be robbed, solve two linear cases:

1. Exclude the last house and find the best result from indices `0` through `n - 2`.
2. Exclude the first house and find the best result from indices `1` through `n - 1`.
3. For each linear range, track only the best results from the previous two houses.
4. Return the larger result from the two cases.

- **Time Complexity:** O(n), because the two linear ranges together process a constant multiple of `n` houses.
- **Space Complexity:** O(1), excluding the recursion-call parameters; the helper uses two state variables.
