# Perfect Sum Problem

[Link to Problem on GeeksforGeeks](https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1)

## Problem Description

Given an array of non-negative integers and a target sum, count the number of subsets whose elements add up exactly to the target. Each array element can be included at most once, and different index selections are counted as different subsets. A zero can be either included or excluded without changing the sum.

### Example

For `arr = [5, 2, 3, 10, 6, 8]` and `target = 10`, the answer is `3` because the valid subsets are `[10]`, `[5, 2, 3]`, and `[2, 8]`.

### Tabulation

Build a DP table where `dp[i][s]` stores the number of subsets that form sum `s` using elements through index `i`. Initialize sum `0` as achievable by the empty subset. For each element, add the counts from skipping it and taking it when its value does not exceed the current sum. The first element equal to zero contributes two choices: take it or skip it.

- **Time Complexity:** O(n * target).
- **Space Complexity:** O(n * target).

### Memoization

Recursively consider taking or skipping each element. Cache each `(index, sum)` state so that every state is computed only once.

- **Time Complexity:** O(n * target).
- **Space Complexity:** O(n * target), including the memoization table and recursion stack.

### Recursive Approach

Try both choices, taking or skipping each element, and count the successful paths that reach sum `0`. This approach does not cache repeated states.

- **Time Complexity:** O(2^n).
- **Space Complexity:** O(n), for the recursion stack.
