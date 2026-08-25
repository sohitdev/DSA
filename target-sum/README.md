# 494. Target Sum

**LeetCode Problem:** [https://leetcode.com/problems/target-sum/](https://leetcode.com/problems/target-sum/)

**Difficulty:** Medium

---

## Problem Description

You are given an integer array `nums` and an integer `target`. You need to find the number of ways to assign either `+` or `-` to each element so that the sum of the resulting signed values equals `target`.

This problem can be transformed into a subset-sum problem by considering the difference between the positive and negative groups.

---

## Examples

**Example 1:**

**Input:** `nums = [1,1,1,1,1], target = 3`  
**Output:** `5`  
**Explanation:** There are 5 ways to assign signs to make the total sum 3.

---

**Example 2:**

**Input:** `nums = [1], target = 1`  
**Output:** `1`

---

## Approaches

---

### Approach 3: Optimal — Subset Sum Transformation (Active)

**Idea:**  
Reduce the problem to finding how many subsets can sum to half of `sum(nums) - target`. If the transformed value is not valid, the answer is zero.

**Algorithm:**

1. Compute `sum` of all array elements.
2. Let `rem = sum - target`; if `rem < 0` or `rem % 2 != 0`, return `0`.
3. Let `newTarget = rem / 2`.
4. Count the number of subsets whose sum is `newTarget` using dynamic programming.
5. Return the count as the total number of sign assignments.

**Complexity:**

- **Time:** O(n \* target) — each item is processed against each possible subset sum.
- **Space:** O(n \* target) — DP table for states.

---

### Approach 2: Better — Memoization

**Idea:**  
Use recursion on the index and the remaining target, caching states to avoid recomputation. This is a classic top-down dynamic programming approach.

**Algorithm:**

1. Recurse with the current index and remaining sum.
2. Either skip the current element or subtract it from the target if it fits.
3. Memoize each `(index, target)` state.
4. Return the sum of both choices.

**Complexity:**

- **Time:** O(n \* target) — each state is computed once.
- **Space:** O(n \* target) — memo table plus recursion stack.

---

### Approach 1: Brute Force — Recursion

**Idea:**  
Try both possibilities for each number: add it with a `+` sign or a `-` sign. Explore all combinations and count those that match the target.

**Algorithm:**

1. Recurse on each index.
2. For the current element, try both `+num` and `-num` branches.
3. Base case: if all numbers are processed, check whether the running sum equals the target.
4. Count valid assignments.

**Complexity:**

- **Time:** O(2^n) — every assignment is explored.
- **Space:** O(n) — recursion stack.
